package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.DeviceDAO;
import com.jzhl.yunjia.mapper.DoorAutoOpenDAO;
import com.jzhl.yunjia.model.Device;
import com.jzhl.yunjia.model.DeviceExample;
import com.jzhl.yunjia.model.DoorAutoOpen;
import com.jzhl.yunjia.model.DoorAutoOpenExample;
import com.jzhl.yunjia.utils.RedisUtil;
import com.jzhl.yunjia.utils.YunJiaUtil;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoorAutoOpenService {

    @Resource
    DoorAutoOpenDAO doorAutoOpenDAO;

    @Resource
    DeviceDAO deviceDAO;

    @Resource
    RedisUtil redisUtil;


    /**
     * 获取常开门时间段数据
     */
    public void getDeviceList(){
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();

        criteria.andDelFlagEqualTo("0");
        criteria.andStatusEqualTo("0");

        List<Device> devices = deviceDAO.selectByExample(deviceExample);

        for (Device device : devices){

            DoorAutoOpenExample doorAutoOpenExample = new DoorAutoOpenExample();
            DoorAutoOpenExample.Criteria criteria1 = doorAutoOpenExample.createCriteria();
            criteria1.andDelFlagEqualTo("0");
            criteria1.andStatusEqualTo("0");
            criteria1.andDeviceSerialEqualTo(device.getDeviceSerial());

            List<DoorAutoOpen> doorAutoOpens = doorAutoOpenDAO.selectByExample(doorAutoOpenExample);

            redisUtil.set("yunjia_auto_open_" + device.getDeviceSerial(), doorAutoOpens);
        }
    }


    /**
     * 验证是否常开门
     * @param context
     */
    public void openKeepOrClose(ServletContext context){
        try {
            ChannelHandlerContext ctx = null;
            List<Device> devices = (List<Device>)redisUtil.get("yunjia_device_list");
            if(devices == null){
                return;
            }

            for (Device device : devices){

                Map<String, ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)context.getAttribute("ctx");
                if(map != null){
                    ctx = map.get(device.getDeviceSerial());
                }

                List<DoorAutoOpen> doorAutoOpens = (List<DoorAutoOpen>)redisUtil.get("yunjia_auto_open_" + device.getDeviceSerial());

                if(doorAutoOpens != null){
                    for (DoorAutoOpen doorAutoOpen : doorAutoOpens){

                        Calendar calendar = Calendar.getInstance();
                        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
                        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
                        Integer startMin = Integer.valueOf(doorAutoOpen.getStartHour()) * 60 + Integer.valueOf(doorAutoOpen.getStartMinute());
                        Integer endMin = (Integer.valueOf(doorAutoOpen.getEndHour()) * 60 + Integer.valueOf(doorAutoOpen.getEndMinute()));
                        Integer nowMin = Integer.valueOf(hour) * 60 + Integer.valueOf(minute);

                        if(startMin >= endMin){
                            continue;
                        }

                        if(nowMin >= startMin && nowMin <= endMin){
                            if(ctx != null){
                                YunJiaUtil.command2D(ctx,String.valueOf(doorAutoOpen.getActiveType()+ 1));
                                redisUtil.set("yunjia_device_open_status_" + doorAutoOpen.getDeviceSerial() + "_" + (doorAutoOpen.getActiveType()+ 1), "keep");
                            }
                        }else{
                            String deviceOpenstatus = (String)redisUtil.get("yunjia_device_open_status_" + doorAutoOpen.getDeviceSerial() + "_" + (doorAutoOpen.getActiveType()+ 1));
                            if(deviceOpenstatus != null){
                                if(deviceOpenstatus.equals("keep")){
                                    YunJiaUtil.command2E(ctx,String.valueOf(doorAutoOpen.getActiveType()+ 1));
                                }

                                redisUtil.set("yunjia_device_open_status_" + doorAutoOpen.getDeviceSerial() + "_" + (doorAutoOpen.getActiveType()+ 1), "close");
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
