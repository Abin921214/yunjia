package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.SubDeviceDAO;
import com.jzhl.yunjia.model.SubDevice;
import com.jzhl.yunjia.model.SubDeviceExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubDeviceService {

    @Resource
    SubDeviceDAO subDeviceDao;

    public List<SubDevice> selectByExample(SubDeviceExample subDeviceExample){
        return subDeviceDao.selectByExample(subDeviceExample);
    }

    public int updateByExample(SubDevice subDevice, SubDeviceExample subDeviceExample){
        return subDeviceDao.updateByExampleSelective(subDevice, subDeviceExample);
    }
}
