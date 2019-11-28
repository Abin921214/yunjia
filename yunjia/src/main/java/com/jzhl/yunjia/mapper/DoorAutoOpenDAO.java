package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.DoorAutoOpen;
import com.jzhl.yunjia.model.DoorAutoOpenExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DoorAutoOpenDAO继承基类
 */
@Mapper
public interface DoorAutoOpenDAO extends MyBatisBaseDao<DoorAutoOpen, Integer, DoorAutoOpenExample> {
}