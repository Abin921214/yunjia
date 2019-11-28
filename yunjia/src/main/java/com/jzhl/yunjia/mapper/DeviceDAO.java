package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.Device;
import com.jzhl.yunjia.model.DeviceExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * DeviceDAO继承基类
 */
@Mapper
public interface DeviceDAO extends MyBatisBaseDao<Device, Integer, DeviceExample> {
}