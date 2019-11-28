package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.OpenLog;
import com.jzhl.yunjia.model.OpenLogExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * OpenLogDAO继承基类
 */
@Mapper
public interface OpenLogDAO extends MyBatisBaseDao<OpenLog, Integer, OpenLogExample> {
}