package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.DeviceLogDAO;
import com.jzhl.yunjia.model.DeviceLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeviceLogService {

    @Resource
    DeviceLogDAO deviceLogDAO;

    public int insert(DeviceLog deviceLog){
        return deviceLogDAO.insertSelective(deviceLog);
    }
}
