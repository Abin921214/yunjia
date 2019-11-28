package com.jzhl.yunjia.utils;

import com.alibaba.fastjson.JSONObject;
import com.jzhl.yunjia.config.SpringFactory;
import com.jzhl.yunjia.model.*;
import com.jzhl.yunjia.service.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;

import javax.servlet.ServletContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class YunJiaUtil {


    /**
     *  将通讯保存在上下文中
     * @param context  上下文
     * @param ctx      tcp 通道链接
     * @param deviceName  设备名称
     */
    public static void setServletContext(ServletContext context, ChannelHandlerContext ctx, String deviceName){
        Map<String, ChannelHandlerContext> map = (Map<String, ChannelHandlerContext>)context.getAttribute("ctx");
        if(map == null){
            map = new HashMap<>();
        }

        map.put(deviceName, ctx);

        context.setAttribute("ctx", map);
    }

    /**
     * 给客户端返心跳的反馈数据
     */
    public static void sendHeartDate(ChannelHandlerContext ctx, String deviceName){
        String data = "020056ff008a005ba000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000da03";

        //回复心跳
        writeToClient(data, ctx, "心跳");


        //添加对应的设备上线状态
        RedisUtil redisUtil = ((RedisUtil) SpringFactory.getBean("redisUtil"));
        Map<String,Date> map = (Map<String,Date>)redisUtil.get("yunjia_device_online");
        if(map == null){
            map = new HashMap<>();
        }

        map.put(deviceName,new Date());
        redisUtil.set("yunjia_device_online",map);
    }


    /**
     * 传送历史刷卡记录
     */
    public static void command53(ChannelHandlerContext ctx, String data){

        System.out.println("传送历史刷卡记录:" + data);

        if(data.length() < 42){
            return;
        }

        String serialNum = data.substring(40,42);

        System.out.println("------------- history  serialNum ----------------" + serialNum);

        String start = "020053FF000100" + serialNum ;

        String code = StringUtil.checkcode(start);

        String end = start + StringUtil.addZeroForNum(code, 2) + "03";

        System.out.println("----------- history card record end -------------");

        writeToClient(end, ctx, "history card record");
    }

    /**
     *  传送门禁请求数据  涵盖 刷卡， 二维码， 人脸，指静脉等
     * @param ctx
     * @param data
     */
    public static void commandE7(ChannelHandlerContext ctx, String data, RedisUtil redisUtil) throws Exception{
        String type = data.substring(58,60);
        switch (type){
            case "00": //刷卡
                CommandE7Util.type00(ctx,data,redisUtil);
                break;
            case "01": //串口232接口输入字符串,如二维码等
                CommandE7Util.type01(ctx,data,redisUtil);
                break;
            case "02": // 密码
                CommandE7Util.type02(ctx,data,redisUtil);
                break;
            case "03": //按钮
                CommandE7Util.type03(ctx,data,redisUtil);
                break;
            case "06": //二代证数据 数据结构见后面身份证数据结构
                break;
            case "09": // Base64数据，来自串口二维码编码后
                break;
            case "0A": // 指纹数据
                break;
            case "0B":// 指静脉数据
                break;
            case "0C": // RFID
                break;
            case "0D": // 人脸
                break;
            default:
                break;
        }
    }

    /**
     *  添加开门日志
     */
    public static void addOpenLog(int openType,SubDevice deviceSubDevice, SubDevice doorSubDevice,String cardId,RedisUtil redisUtil){
        OpenLog openLog = new OpenLog();
        openLog.setHeId(deviceSubDevice.getHeId());
        openLog.setCompanyId(deviceSubDevice.getCompanyId());
        openLog.setDeviceId(deviceSubDevice.getDeviceId());
        openLog.setOpenSubDeviceId(doorSubDevice.getId()); //打开的那个门

        switch (openType){
            case 4: //按钮开门
                openLog.setReadSubDeviceId(deviceSubDevice.getId());
                openLog.setUnitId(deviceSubDevice.getUnitId());
                openLog.setBuildingId(deviceSubDevice.getBuildingId());
                openLog.setOpenType(4);
                openLog.setActivTime(deviceSubDevice.getActivTime());
                break;
            case 0: //门禁卡
                openLog.setReadSubDeviceId(deviceSubDevice.getId());
                openLog.setUnitId(deviceSubDevice.getUnitId());
                openLog.setBuildingId(deviceSubDevice.getBuildingId());
                openLog.setOpenType(0);
                openLog.setActivTime(deviceSubDevice.getActivTime());
                openLog.setCardNumber(cardId);
                break;
            case 1:
                openLog.setOpenType(1);
                openLog.setReadSubDeviceId(deviceSubDevice.getId());
                openLog.setUnitId(deviceSubDevice.getUnitId());
                openLog.setBuildingId(deviceSubDevice.getBuildingId());
                openLog.setReadInfo(cardId);
                openLog.setActivTime(deviceSubDevice.getActivTime());
            case 2:
                openLog.setOpenType(2);
                openLog.setReadSubDeviceId(deviceSubDevice.getId());
                openLog.setUnitId(deviceSubDevice.getUnitId());
                openLog.setBuildingId(deviceSubDevice.getBuildingId());
                openLog.setReadInfo(cardId);
                openLog.setActivTime(deviceSubDevice.getActivTime());
            case 3:
                openLog.setOpenType(3);
                openLog.setReadSubDeviceId(deviceSubDevice.getId());
                openLog.setUnitId(deviceSubDevice.getUnitId());
                openLog.setBuildingId(deviceSubDevice.getBuildingId());
                openLog.setReadInfo(cardId);
                openLog.setActivTime(deviceSubDevice.getActivTime());
        }
        openLog.setBuildTime(new Date());

        addOpenLog(openLog);
    }

    public static void addOpenLog(OpenLog openLog){
        OpenLogService openLogService = ((OpenLogService) SpringFactory.getBean("openLogService"));
        openLogService.insert(openLog);
    }

    /**
     *  commandE7 的控制设备开门指令
     * @param ctx
     * @param trueAndFalse   继电器	1	输出的继电器编号，从0开始。0进门、1出门、2报警。
     * @param time   开门时间	2	输出继电器动作的时间，秒为单位。
     * @param reader  读头	1	读头，0进门 1出门。
     */
    public static void openE7(ChannelHandlerContext ctx, String out,String trueAndFalse, int time, String reader){

        System.out.println("------------openE7----------------");

        String start = "020057FF00";

        String data =  out + trueAndFalse + StringUtil.addZeroForNum(StringUtil.intToHex(time),2) + "00" + StringUtil.addZeroForNum(reader, 2) +"0000" + "000000000000000000000000000000000000"

                + "00000000000000000000000000000000000000000000000000000000000000000000000000000000" + "00000000000000000000000000000000" + "0000000000000000000000000000000000000000000000000000000000000000"

                + "0000000000000000000000000000000000000000";

        start = start + StringUtil.addZeroForNum(StringUtil.intToHex(data.length()/2),2) + "00";

        String code = StringUtil.checkcode(start + data);

        String end = start + data + StringUtil.addZeroForNum(code, 2) + "03";

        writeToClient(end, ctx, "传送门禁请求数据");
    }


    /**
     *  command73 的控制设备开门指令
     * @param ctx
     * @param trueAndFalse   继电器	1	输出的继电器编号，从0开始。0进门、1出门、2报警。
     * @param time   开门时间	2	输出继电器动作的时间，秒为单位。
     * @param reader  读头	1	读头，0进门 1出门。
     */
    public static void open73(ChannelHandlerContext ctx, String out,String trueAndFalse, int time, String reader){

        System.out.println("------------open73----------------");

        String start = "020073FF00";

        String data =  out + StringUtil.addZeroForNum(trueAndFalse,2) + StringUtil.addZeroForNum(StringUtil.intToHex(time),2) + "00" + StringUtil.addZeroForNum(reader, 2) +"00" + "000000000000000000000000000000000000"

                + "00000000000000000000000000000000000000000000000000000000000000000000000000000000" + "00000000000000000000000000000000" + "0000000000000000000000000000000000000000000000000000000000000000"

                + "0000000000000000000000000000000000000000";

        start = start + StringUtil.addZeroForNum(StringUtil.intToHex(data.length()/2),2) + "00";

        String code = StringUtil.checkcode(start + data);

        String end = start + data + StringUtil.addZeroForNum(code, 2) + "03";

        writeToClient(end, ctx, "传送门禁主动开门请求数据");
    }


    /**
     * 语音板—播报语音语句
     * @param ctx
     */
    public static void command80(ChannelHandlerContext ctx, String content){
        String start = "020080FF00";

        //语音对应16进制
        String content16 = StringUtil.toChineseHex(content);

        //语音对应长度
        String length = StringUtil.addZeroForNum(StringUtil.intToHex(content16.length()/2),2);

        String end = "00" + StringUtil.addZeroForNum(StringUtil.intToHex(content16.length()/2),2) + "00" + content16;


        String con = start + StringUtil.addZeroForNum(StringUtil.intToHex(end.length()/2),2) + "00" + end;


        String code = StringUtil.checkcode(con);

        String last = con + StringUtil.addZeroForNum(code, 2) + "03";

        writeToClient(last, ctx, "语音播报");
    }



    /**
     * 门长开
     * @param ctx
     * @param door   开门继电器 编号  01   02  03
     */
    public static void command2D(ChannelHandlerContext ctx, String door){
        String start = "02002DFF" + StringUtil.addZeroForNum(door,2) + "0000";

        String code = StringUtil.checkcode(start);

        String end = start + code + "03";

        writeToClient(end, ctx, "门长开");
    }


    /**
     * 关门
     * @param ctx
     * @param door   开门继电器 编号  01   02  03
     */
    public static void command2E(ChannelHandlerContext ctx, String door){
        String start = "02002EFF" + StringUtil.addZeroForNum(door,2) + "0000";

        String code = StringUtil.checkcode(start);

        String end = start + code + "03";


        writeToClient(end, ctx, "关门");
    }

    /**
     * 开门
     * @param ctx
     * @param door   开门继电器 编号  01   02  03
     */
    public static void command2C(ChannelHandlerContext ctx, String door){
        String start = "02002CFF" + StringUtil.addZeroForNum(door,2) + "0000";

        String code = StringUtil.checkcode(start);

        String end = start + code + "03";

        writeToClient(end, ctx, "开门");
    }


    /**
     * 传送历史报警记录
     */
    public static void command54(ChannelHandlerContext ctx, String data){

        String serialNum = data.substring(32,34);

        String start = "020054FF000100" + serialNum ;

        String code = StringUtil.checkcode(start);

        String end = start + StringUtil.addZeroForNum(code, 2) + "03";

        writeToClient(end, ctx, "传送历史报警记录");
    }



    /**
     * 公用回写数据到客户端的方法
     * @param  //需要回写的字符串
     * @param channel
     * @param mark 用于打印/log的输出
     * <br>//channel.writeAndFlush(msg);//不行
     * <br>//channel.writeAndFlush(receiveStr.getBytes());//不行
     * <br>在netty里，进出的都是ByteBuf，楼主应确定服务端是否有对应的编码器，将字符串转化为ByteBuf
     *
     *     https://blog.csdn.net/yqwang75457/article/details/73913572
     */
    private static void writeToClient(final String receiveStr, ChannelHandlerContext channel, final String mark) {
        try {
            ByteBuf bufff = Unpooled.buffer();//netty需要用ByteBuf传输
            bufff.writeBytes(ConvertCode.hexString2Bytes(receiveStr));//对接需要16进制
            channel.writeAndFlush(bufff).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    StringBuilder sb = new StringBuilder("");
                    if(mark != null){
                        sb.append("【").append(mark).append("】");
                    }
                    if (future.isSuccess()) {
//                        System.out.println(sb.toString()+"回写成功"+receiveStr);
                    } else {
//                        System.out.println(sb.toString()+"回写失败"+receiveStr);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("调用通用writeToClient()异常"+e.getMessage());
        }
    }


    public static long getCardId10(String temp){
        List<String> list = new ArrayList<>();
        int z = 0;
        for(int i=0;i<temp.length()/2;i++){
            String a = temp.substring(z,z+2);
            System.out.println(a);
            list.add(a);
            z = z+2;
        }

        Collections.reverse(list);

        StringBuffer stringBuffer = new StringBuffer();
        for(String string:list){
            stringBuffer.append(string);
        }

        long dec_num = Long.parseLong(stringBuffer.toString(), 16);

        return dec_num;
    }

}
