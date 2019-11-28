package com.jzhl.yunjia.utils;

import com.jzhl.yunjia.config.SpringFactory;
import com.jzhl.yunjia.model.*;
import com.jzhl.yunjia.service.*;
import io.netty.channel.ChannelHandlerContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用于处理对应的开门逻辑  为 YunJiaUtil 服务
 */
public class CommandE7Util {


    /**
     *二维码严验证开门
     * @param ctx
     * @param data
     * @param redisUtil
     */
    public static void type01(ChannelHandlerContext ctx, String data, RedisUtil redisUtil){

        try {
            String deviceName = StringUtil.hexStr2Str(data.substring(14,26));
            String content = StringUtil.hexStr2Str(data.substring(100, data.length() - 4));
            String reader = data.substring(46, 48);

            Boolean isDeviceOk = false;
            Boolean isDoorOk = false;

            SubDevice deviceSubDevice = new SubDevice();
            SubDevice doorSubDevice = new SubDevice();
            List<SubDevice> subDeviceList = (List<SubDevice>)redisUtil.get("yunjia_sub_device_list_" + deviceName);

            String[] qrInfo = content.split("_");

            System.out.println(content);

            int openType = 1;

            for(SubDevice subDevice : subDeviceList){
                if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("3")){
                    isDeviceOk = true;
                    deviceSubDevice = subDevice;
                }

                if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("1")){
                    isDoorOk = true;
                    doorSubDevice = subDevice;
                }
            }

            if(qrInfo.length != 4){
                VisitorQRService visitorQRService = ((VisitorQRService) SpringFactory.getBean("visitorQRService"));

                // 访客二维码
                VisitorQrExample visitorQrExample = new VisitorQrExample();
                VisitorQrExample.Criteria visitorQrCriteria = visitorQrExample.createCriteria();
                visitorQrCriteria.andQrEqualTo(content);

//                visitorQrCriteria.andCompanyIdEqualTo(deviceSubDevice.getCompanyId());
                visitorQrCriteria.andHeIdEqualTo(deviceSubDevice.getHeId());
                if(deviceSubDevice.getBuildingId() != null && deviceSubDevice.getBuildingId() != 0){
                    visitorQrCriteria.andBuildingIdEqualTo(deviceSubDevice.getBuildingId());
                }

                if(deviceSubDevice.getUnitId() != null && deviceSubDevice.getUnitId() != 0){
                    visitorQrCriteria.andUnitIdEqualTo(deviceSubDevice.getUnitId());
                }

                visitorQrCriteria.andStatusEqualTo("0");
                visitorQrCriteria.andDelFlagEqualTo("0");
                List<VisitorQr> visitorQrList = visitorQRService.selectByExample(visitorQrExample);

                if(visitorQrList.size() == 0){
                    isDeviceOk = false;
                }else{
                    if(!DateUtils.isExpire(visitorQrList.get(0).getBuildTime(),visitorQrList.get(0).getEffectiveHours())){
                        isDeviceOk = false;
                    }else{
                        isDeviceOk = true;
                    }
                }

                openType = 2;
            }else{
                HeHouseholdsHouseService heHouseholdsHouseService = ((HeHouseholdsHouseService) SpringFactory.getBean("heHouseholdsHouseService"));
                // 业主二维码
                String user_id = qrInfo[0];
                String district_id = qrInfo[1];
                String time = qrInfo[2];
                String key = qrInfo[3];

                DateFormat dtf = new SimpleDateFormat("yyyyMMddHHmmss");
                Date nowDate = dtf.parse(time);

                if(!DateUtils.isExpire(nowDate,4)){
                    isDeviceOk = false;
                }else{
                    String checkNo = StringUtils.MD5Encode("ULSbSsXASLDWxF6t" + user_id + district_id + time + "jFxcmwcLlv8MQPHR");
                    if(!checkNo.equals(key)){
                        isDeviceOk = false;
                    }else{
                        HeHouseholdsHouseExample heHouseholdsHouseExample = new HeHouseholdsHouseExample();
                        HeHouseholdsHouseExample.Criteria heHouseholdsHouseExampleCriteria = heHouseholdsHouseExample.createCriteria();

                        heHouseholdsHouseExampleCriteria.andHeIdEqualTo(deviceSubDevice.getHeId());
                        heHouseholdsHouseExampleCriteria.andCompanyIdEqualTo(deviceSubDevice.getCompanyId());
                        heHouseholdsHouseExampleCriteria.andHouseholdsIdEqualTo(Integer.valueOf(user_id));
                        heHouseholdsHouseExampleCriteria.andIsPastEqualTo(0);
                        heHouseholdsHouseExampleCriteria.andStatusEqualTo("0");
                        heHouseholdsHouseExampleCriteria.andDelFlagEqualTo("0");

                        if(deviceSubDevice.getBuildingId() != 0){
                            heHouseholdsHouseExampleCriteria.andBuildingIdEqualTo(deviceSubDevice.getBuildingId());
                            if(deviceSubDevice.getUnitId() != 0){
                                heHouseholdsHouseExampleCriteria.andUnitIdEqualTo(deviceSubDevice.getUnitId());
                            }
                        }

                        List<HeHouseholdsHouse> heHouseholdsHouseList = heHouseholdsHouseService.selectByExample(heHouseholdsHouseExample);
                        if(heHouseholdsHouseList.size() == 0){
                            isDeviceOk = false;
                        }
                    }
                }

                openType = 1;
            }

            if(isDeviceOk && isDoorOk){
                //添加开门日志
                YunJiaUtil.addOpenLog(openType, deviceSubDevice,doorSubDevice,content,redisUtil);

                YunJiaUtil.openE7(ctx, "01" ,reader, deviceSubDevice.getActivTime(), reader);
                redisUtil.set("yunjia_voice", "您好, 请通行");
            }else{
                YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
                redisUtil.set("yunjia_voice", "您好, 禁止通行");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 刷卡
     * @param ctx
     * @param data
     * @param redisUtil
     */
    public static void type00(ChannelHandlerContext ctx, String data, RedisUtil redisUtil){

        String deviceName = StringUtil.hexStr2Str(data.substring(14,26));
        String content = StringUtil.hexStr2Str(data.substring(100, data.length() - 4));
        String reader = data.substring(46, 48);

        boolean isDeviceOk = false;
        boolean isDoorOk = false;
        SubDevice deviceSubDevice = new SubDevice();
        SubDevice doorSubDevice = new SubDevice();
        List<SubDevice> subDeviceList = (List<SubDevice>)redisUtil.get("yunjia_sub_device_list_" + deviceName);

        CardService cardService = ((CardService) SpringFactory.getBean("cardService"));

        for(SubDevice subDevice : subDeviceList){

            System.out.println("subDevice.getActivType():" + subDevice.getActivType() + ":::" + subDevice.getSubDeviceType());

            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("2")){
                isDeviceOk = true;
                deviceSubDevice = subDevice;
            }

            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("1")){
                isDoorOk = true;
                doorSubDevice = subDevice;
            }
        }

        //根据 小区ID 公司ID 卡ID 查询所有该卡对应的信息
        CardExample cardExample = new CardExample();
        CardExample.Criteria cardCriteria = cardExample.createCriteria();

//        cardCriteria.andCompanyIdEqualTo(deviceSubDevice.getCompanyId());
        cardCriteria.andHeIdEqualTo(deviceSubDevice.getHeId());
        cardCriteria.andCardNumberEqualTo(content);
        cardCriteria.andStatusEqualTo("0");
        cardCriteria.andDelFlagEqualTo("0");

        List<Card> cardList = cardService.selectByExample(cardExample);

        System.out.println("cardList:" + cardList);

        if(cardList.size() == 0){
            isDeviceOk = false;
        }

        for (Card card: cardList) {

            if(card.getCardType().equals("1")){

                System.out.println("工作卡");

                //工作人员卡
                isDeviceOk = true;
                break;
            }

            if(card.getHeId().equals(deviceSubDevice.getHeId()) && !deviceSubDevice.getHeId().equals(0)){
                if(!deviceSubDevice.getBuildingId().equals(0)){
                    if(!deviceSubDevice.getBuildingId().equals(card.getBuildingId())){
                        isDeviceOk = false;
                        break;
                    }else{
                        if(!deviceSubDevice.getUnitId().equals(0)){
                            if(!deviceSubDevice.getUnitId().equals(card.getUnitId())){
                                isDeviceOk = false;
                                break;
                            }else{
                                isDeviceOk = true;
                            }
                        }else{
                            isDeviceOk = true;
                        }
                    }
                }else{
                    isDeviceOk = true;
                }
            }else{
                // 小区不相等或者小区ID 为0 语音播报 直接退出
                isDeviceOk = false;
                break;
            }
        }

        if(isDeviceOk && isDoorOk){
            //添加开门日志
            YunJiaUtil.addOpenLog(0, deviceSubDevice,doorSubDevice,content,redisUtil);

            YunJiaUtil.openE7(ctx, "01" ,reader, deviceSubDevice.getActivTime(), reader);
            redisUtil.set("yunjia_voice", "您好, 请通行");
        }else{
            YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
            redisUtil.set("yunjia_voice", "您好, 禁止通行");
        }
    }


    /**
     * 密码
     * @param ctx
     * @param data
     * @param redisUtil
     */
    public static void type02(ChannelHandlerContext ctx, String data, RedisUtil redisUtil){
        DoorVisitorPasswordService doorVisitorPasswordService = ((DoorVisitorPasswordService) SpringFactory.getBean("doorVisitorPasswordService"));
        String deviceName = StringUtil.hexStr2Str(data.substring(14,26));
        String content = StringUtil.hexStr2Str(data.substring(100, data.length() - 4));
        String reader = data.substring(46, 48);

        System.out.println("------2222-------" + content + ":" + reader);

        boolean isDeviceOk = false;
        boolean isDoorOk = false;
        SubDevice deviceSubDevice = new SubDevice();
        SubDevice doorSubDevice = new SubDevice();
        List<SubDevice> subDeviceList = (List<SubDevice>)redisUtil.get("yunjia_sub_device_list_" + deviceName);

        System.out.println("------2222-------" + content);

        for(SubDevice subDevice : subDeviceList){
            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("3")){
                isDeviceOk = true;
                deviceSubDevice = subDevice;
            }

            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("1")){
                isDoorOk = true;
                doorSubDevice = subDevice;
            }
        }


        if(isDeviceOk && isDoorOk){
            List<DoorVisitorPassword> doorVisitorPasswords = doorVisitorPasswordService.getDVP(doorSubDevice.getHeId(), doorSubDevice.getBuildingId(), doorSubDevice.getUnitId(), doorSubDevice.getCompanyId(), content);

            System.out.println(doorVisitorPasswords);

            if(doorVisitorPasswords.size() > 0){
                if(DateUtils.isExpire(doorVisitorPasswords.get(0).getBuildTime(),doorVisitorPasswords.get(0).getEffectiveHours())){
                    YunJiaUtil.openE7(ctx, "01" ,reader, doorSubDevice.getActivTime(), reader);
                    redisUtil.set("yunjia_voice", "您好, 请通行");
                }else{
                    YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
                    redisUtil.set("yunjia_voice", "您好, 禁止通行");
                }
            }else{
                YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
                redisUtil.set("yunjia_voice", "您好, 禁止通行");
            }
        }else{
            YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
            redisUtil.set("yunjia_voice", "您好, 禁止通行");
        }

    }


    /**
     * 按钮
     * @param ctx
     * @param data
     * @param redisUtil
     */
    public static void type03(ChannelHandlerContext ctx, String data, RedisUtil redisUtil){
        String deviceName = StringUtil.hexStr2Str(data.substring(14,26));
        String content = StringUtil.hexStr2Str(data.substring(100, data.length() - 4));
        String reader = data.substring(46, 48);

        System.out.println("------2222-------" + content + ":" + reader);

        boolean isDeviceOk = false;
        boolean isDoorOk = false;
        SubDevice deviceSubDevice = new SubDevice();
        SubDevice doorSubDevice = new SubDevice();
        List<SubDevice> subDeviceList = (List<SubDevice>)redisUtil.get("yunjia_sub_device_list_" + deviceName);

        for(SubDevice subDevice : subDeviceList){
            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("5")){
                isDeviceOk = true;
                deviceSubDevice = subDevice;
            }

            if(StringUtil.addZeroForNum(String.valueOf(subDevice.getActivType()),2).equals(reader) && subDevice.getSubDeviceType().equals("1")){
                isDoorOk = true;
                doorSubDevice = subDevice;
            }

            if(isDeviceOk && isDoorOk){
                break;
            }
        }

        if(isDeviceOk && isDoorOk){
            //添加开门日志
            YunJiaUtil.addOpenLog(4, deviceSubDevice,doorSubDevice,null,redisUtil);

            YunJiaUtil.openE7(ctx, "01" ,reader, deviceSubDevice.getActivTime(), reader);
            redisUtil.set("yunjia_voice", "您好, 请通行");
        }else{
            YunJiaUtil.openE7(ctx, "00" ,reader, 0, reader);
            redisUtil.set("yunjia_voice", "您好, 禁止通行");
        }
    }

}
