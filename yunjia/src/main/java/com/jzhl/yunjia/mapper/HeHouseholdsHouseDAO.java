package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.HeHouseholdsHouse;
import com.jzhl.yunjia.model.HeHouseholdsHouseExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * HeHouseholdsHouseDAO继承基类
 */
@Mapper
public interface HeHouseholdsHouseDAO extends MyBatisBaseDao<HeHouseholdsHouse, Integer, HeHouseholdsHouseExample> {
}