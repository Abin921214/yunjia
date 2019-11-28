package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.DeviceLog;
import com.jzhl.yunjia.model.DeviceLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DeviceLogDAO继承基类
 */
@Mapper
public interface DeviceLogDAO extends MyBatisBaseDao<DeviceLog, Integer, DeviceLogExample> {
}