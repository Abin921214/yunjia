package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.DoorVisitorPassword;
import com.jzhl.yunjia.model.DoorVisitorPasswordExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DoorVisitorPasswordDAO继承基类
 */
@Mapper
public interface DoorVisitorPasswordDAO extends MyBatisBaseDao<DoorVisitorPassword, Integer, DoorVisitorPasswordExample> {
}