package com.jzhl.yunjia.controller;

import com.alibaba.fastjson.JSONObject;
import com.jzhl.yunjia.model.SubDevice;
import com.jzhl.yunjia.model.SubDeviceExample;
import com.jzhl.yunjia.service.SubDeviceService;
import com.jzhl.yunjia.utils.RedisUtil;
import com.jzhl.yunjia.utils.YunJiaUtil;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  福盈人脸识别
 */
@RestController
@RequestMapping("/julong")
public class JuLongFaceController {

    @Resource
    RedisUtil redisUtil;

    @Resource
    SubDeviceService subDeviceService;

    @RequestMapping("/heartFace")
    public void heartFace(HttpServletRequest request, HttpServletResponse response) throws  Exception{

        System.out.println("开始心跳");
        request.setCharacterEncoding("UTF-8");         //返回页面防止出现中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wirte = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));//post方式传递读取字符流
        String jsonStr = null;
        StringBuilder result = new StringBuilder();

        try {
            while ((jsonStr = reader.readLine()) != null) {
                result.append(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();// 关闭输入流
        JSONObject jsonObject = JSONObject.parseObject(result.toString()); // 取一个json转换为对象

        //将车牌识别设备的心跳时间添加到 redis  中
        Map<String, Date> map = (Map<String, Date>)redisUtil.get("yunjia_julong_face_heart");
        if(map == null){
            map = new HashMap<>();
        }

        map.put(jsonObject.getString("DeviceId"),new Date());

        redisUtil.set("yunjia_julong_face_heart",map);

    }


    @RequestMapping("/reult")
    public void result(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        System.out.println("----------start result ok---------");
        request.setCharacterEncoding("UTF-8");         //返回页面防止出现中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter wirte = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));//post方式传递读取字符流
        String jsonStr = null;
        StringBuilder result = new StringBuilder();

        try {
            while ((jsonStr = reader.readLine()) != null) {
                result.append(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();// 关闭输入流
        JSONObject jsonObject = JSONObject.parseObject(result.toString()); // 取一个json转换为对象
        System.out.println(jsonObject.get("DeviceId"));

        SubDeviceExample subDeviceExample = new SubDeviceExample();
        SubDeviceExample.Criteria criteria = subDeviceExample.createCriteria();
        criteria.andSerialEqualTo((String)jsonObject.get("DeviceId"));
        criteria.andStatusEqualTo("0");
        criteria.andDelFlagEqualTo("0");

        List<SubDevice> subDeviceList = subDeviceService.selectByExample(subDeviceExample);
        System.out.println(subDeviceList);
        if(subDeviceList.size() > 0){
            ChannelHandlerContext ctx = null;
            Map<String,ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)request.getServletContext().getAttribute("ctx");
            if(map != null){
                ctx = map.get(subDeviceList.get(0).getDeviceSerial());
            }

            if(ctx != null){
                YunJiaUtil.open73(ctx,"01",String.valueOf(subDeviceList.get(0).getActivType()),subDeviceList.get(0).getActivTime() ,String.valueOf(subDeviceList.get(0).getActivType()));
                redisUtil.set("yunjia_voice", "您好, 请通行");

                //添加开门记录  //获取  门的信息
                SubDeviceExample subDeviceExample1 = new SubDeviceExample();
                SubDeviceExample.Criteria criteria1 = subDeviceExample.createCriteria();
                criteria1.andDeviceSerialEqualTo(subDeviceList.get(0).getDeviceSerial());
                criteria1.andSubDeviceTypeEqualTo("1");
                criteria.andStatusEqualTo("0");
                criteria.andDelFlagEqualTo("0");

                List<SubDevice> subDeviceListDoor = subDeviceService.selectByExample(subDeviceExample1);
                if(subDeviceListDoor.size() > 0){
                    //添加开门日志
                    YunJiaUtil.addOpenLog(4, subDeviceList.get(0),subDeviceListDoor.get(0),"时间：" + (String)jsonObject.get("SendTime") +" == 比对结果：" + (String)jsonObject.get("CompareResult") + " == 图片名称"+ (String)jsonObject.get("CurPicName"),redisUtil);
                }
            }
        }
    }

}
