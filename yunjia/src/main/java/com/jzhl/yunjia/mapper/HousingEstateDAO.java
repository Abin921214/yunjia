package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.HousingEstate;
import com.jzhl.yunjia.model.HousingEstateExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * HousingEstateDAO继承基类
 */
@Mapper
public interface HousingEstateDAO extends MyBatisBaseDao<HousingEstate, Integer, HousingEstateExample> {
}