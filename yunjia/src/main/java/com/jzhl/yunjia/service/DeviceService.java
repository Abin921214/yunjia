package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.DeviceDAO;
import com.jzhl.yunjia.model.Device;
import com.jzhl.yunjia.model.DeviceExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceService {

    @Resource
    DeviceDAO deviceDAO;

    public List<Device> selectByExample(DeviceExample deviceExample){
        return deviceDAO.selectByExample(deviceExample);
    }

    public int updateByPrimaryKeySelective(Device device){
        return deviceDAO.updateByPrimaryKeySelective(device);
    }

    public int updateByExampleSelective(Device device, DeviceExample deviceExample){
        return deviceDAO.updateByExampleSelective(device,deviceExample);
    }
}
