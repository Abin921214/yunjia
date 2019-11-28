package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.SubDevice;
import com.jzhl.yunjia.model.SubDeviceExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * SubDeviceDAO继承基类
 */
@Mapper
public interface SubDeviceDAO extends MyBatisBaseDao<SubDevice, Integer, SubDeviceExample> {
}