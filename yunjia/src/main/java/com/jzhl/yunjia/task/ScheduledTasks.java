package com.jzhl.yunjia.task;

import com.jzhl.yunjia.model.*;
import com.jzhl.yunjia.service.*;
import com.jzhl.yunjia.utils.DateUtils;
import com.jzhl.yunjia.utils.RedisUtil;
import com.jzhl.yunjia.utils.YunJiaUtil;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  创建定时任务
 *  每过5s在控制台打印当前时间。
 *
 * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * @Scheduled(cron=” /5 “) ：通过cron表达式定义规则，什么是cro表达式，自行搜索引擎。
 */

@Component     // 暂时关闭  需要是开启
public class ScheduledTasks {

    @Resource
    RedisUtil redisUtil;

    @Resource
    DeviceService deviceService;

    @Resource
    DeviceLogService deviceLogService;

    @Resource
    SubDeviceService subDeviceService;

    @Resource
    HousingEstateService housingEstateService;

    @Resource
    DoorAutoOpenService doorAutoOpenService;

    @Resource
    ServletContext servletContext;


    /**
     * 人脸识别设备定时检测是否上下线
     */
    @Scheduled(fixedRate = 1000 * 60 * 5)
    public void juLongFaceOnline(){
        Boolean deviceFlag = false;
        Boolean devicceLogFlag = false;
        Map<String, Date> map = (Map<String,Date>)redisUtil.get("yunjia_julong_face_heart");
        if(map != null){
            for (Map.Entry<String, Date> entry : map.entrySet()) {
                int seconds = DateUtils.calLastedTime(entry.getValue());

                SubDevice subDevice = new SubDevice();

                SubDeviceExample subDeviceExample = new SubDeviceExample();
                SubDeviceExample.Criteria criteria = subDeviceExample.createCriteria();
                criteria.andSerialEqualTo(entry.getKey());
                criteria.andStatusEqualTo("0");
                criteria.andDelFlagEqualTo("0");
                List<SubDevice> subDeviceList = subDeviceService.selectByExample(subDeviceExample);
                if(subDeviceList.size() > 0){
                    //0在线 1不在线
                    if(subDeviceList.get(0).getOnline().equals("0")){
                        if(seconds > 60 * 5){
                            subDevice.setOnline("1");
                            deviceFlag = true;
                            devicceLogFlag = true;
                        }
                    }else if(subDeviceList.get(0).getOnline().equals("1")){
                        if(seconds < 60 * 5){
                            subDevice.setOnline("0");
                            deviceFlag = true;
                            devicceLogFlag = true;
                        }
                    }else{
                        System.out.println("-------------  system error ----------------");
                    }

                    if(deviceFlag){
                        subDeviceService.updateByExample(subDevice, subDeviceExample);
                    }

                    if(devicceLogFlag){
                        DeviceLog deviceLog = new DeviceLog();
                        deviceLog.setDeviceId(subDeviceList.get(0).getId());
                        deviceLog.setDeviceType("1");
                        if(subDevice.getOnline().equals("0")){
                            deviceLog.setLogType("onLine");
                        }else if(subDevice.getOnline().equals("1")){
                            deviceLog.setLogType("offLine");
                        }

                        deviceLog.setCompanyId(subDeviceList.get(0).getCompanyId());
                        deviceLog.setBuildTime(new Date());

                        int id = deviceLogService.insert(deviceLog);
                    }

                }

            }
        }
    }


    /**
     * 定时器修改 云+ 控制器设备状态
     */
    @Scheduled(fixedRate = 1000 * 60 * 5)
    public void deviceOnline(){
        Boolean deviceFlag = false;
        Boolean devicceLogFlag = false;
        Map<String, Date> map = (Map<String,Date>)redisUtil.get("yunjia_device_online");
        Device device = new Device();
        if(map != null){
            for (Map.Entry<String, Date> entry : map.entrySet()) {
                int seconds = DateUtils.calLastedTime(entry.getValue());

                DeviceExample deviceExample = new DeviceExample();
                DeviceExample.Criteria deviceCriteria = deviceExample.createCriteria();
                deviceCriteria.andDeviceSerialEqualTo(entry.getKey());
                List<Device> deviceList = deviceService.selectByExample(deviceExample);
                if(deviceList.size() != 0){
                    if(deviceList.get(0).getOnline().equals("0")){

                        if(seconds > 60 * 3){
                            device.setOnline("1");
                            deviceFlag = true;
                            devicceLogFlag = true;
                        }
                    }else if(deviceList.get(0).getOnline().equals("1")){
                        if(seconds < 60 * 3){
                            device.setOnline("0");
                            deviceFlag = true;
                            devicceLogFlag = true;
                        }
                    }else{
                        System.out.println("-------------  system error ----------------");
                    }

                }

                if(deviceFlag){
                    DeviceExample deviceExample1 = new DeviceExample();
                    DeviceExample.Criteria deviceCriteria1 = deviceExample1.createCriteria();
                    deviceCriteria1.andDeviceSerialEqualTo(entry.getKey());
                    deviceCriteria1.andDelFlagEqualTo("0");
                    deviceCriteria1.andStatusEqualTo("0");
                    List<Device> devices = deviceService.selectByExample(deviceExample);

                    if(devices.size() > 0){
                        int id = deviceService.updateByExampleSelective(device,deviceExample1);
                        if(id <= 0){
                            System.out.println(entry.getKey() + "更新失败");
                        }
                    }
                }

                if(devicceLogFlag){
                    DeviceLog deviceLog = new DeviceLog();
                    deviceLog.setDeviceId(deviceList.get(0).getId());
                    if(device.getOnline().equals("0")){
                        deviceLog.setLogType("onLine");
                    }else if(device.getOnline().equals("1")){
                        deviceLog.setLogType("offLine");
                    }

                    deviceLog.setCompanyId(deviceList.get(0).getCompanyId());
                    deviceLog.setBuildTime(new Date());

                    int id = deviceLogService.insert(deviceLog);
                    if(id <= 0){
                        System.out.println("-------------  system error ----------------");
                    }else{
                        HousingEstateExample housingEstateExample = new HousingEstateExample();
                        HousingEstateExample.Criteria criteria = housingEstateExample.createCriteria();
                        criteria.andIdEqualTo(deviceList.get(0).getHeId());
                        List<HousingEstate> housingEstateList = housingEstateService.selectByExample(housingEstateExample);
                        if(housingEstateList.size() > 0){
//                            QQUtils.sendMailOnlineOrOffline(housingEstateList.get(0).getHousingEstateName(), deviceList.get(0).getDeviceName(),device.getOnline());
                        }
                    }
                }
            }
        }
    }


    /**
     * 定时器修改 平台地下的设备和子设备信息 （包含自动开门时间）
     */
    @Scheduled(fixedRate = 1000 * 60 * 5)
    public void deviceUpdateToRedis(){
        //查询状态为0 删除状态为0 的设备添加到 redis 中
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDelFlagEqualTo("0");
        criteria.andStatusEqualTo("0");

        List<Device> deviceList = deviceService.selectByExample(deviceExample);

//        System.out.println("设备" + deviceList.size());

        redisUtil.set("yunjia_device_list", deviceList);

        //查询子设备，并添加到redis中去。
        for (Device device : deviceList) {

            SubDeviceExample subDeviceExample = new SubDeviceExample();
            SubDeviceExample.Criteria subDeviceCriteria = subDeviceExample.createCriteria();
            subDeviceCriteria.andDeviceSerialEqualTo(device.getDeviceSerial());
            subDeviceCriteria.andDelFlagEqualTo("0");
            subDeviceCriteria.andStatusEqualTo("0");

            List<SubDevice> subDeviceList = subDeviceService.selectByExample(subDeviceExample);

//            System.out.println("子设备" + subDeviceList.size());

            redisUtil.set("yunjia_sub_device_list_" + device.getDeviceSerial(), subDeviceList);
        }

        //缓存 宜坤 人脸识别设备
        //查询设备序列号设备对应的子设备
        SubDeviceExample subDeviceExample = new SubDeviceExample();
        SubDeviceExample.Criteria subDeviceCriteria = subDeviceExample.createCriteria();
        subDeviceCriteria.andSerialNotEqualTo("");
        subDeviceCriteria.andStatusEqualTo("0");
        subDeviceCriteria.andDelFlagEqualTo("0");
        List<SubDevice> subDeviceList = subDeviceService.selectByExample(subDeviceExample);

//        System.out.println("缓存的人脸设备数量：" + subDeviceList.size());

        for (SubDevice subDevice : subDeviceList){
            redisUtil.set("yunjia_face_" + subDevice.getSerial(), subDevice);
        }

    }


    /**
     * 加载定时器 定时控制设备定时长开门时间
     */
    @Scheduled(fixedRate = 1000 * 60 * 2)
    public void doorKeepOpenAutoTime(){
        doorAutoOpenService.getDeviceList();
    }

    /**
     * 定时器 定时控制设备定时长开门
     */
    @Scheduled(fixedRate = 1000 * 60 * 3)
    public void doorKeepOpen(){
        doorAutoOpenService.openKeepOrClose(servletContext);
    }

}
