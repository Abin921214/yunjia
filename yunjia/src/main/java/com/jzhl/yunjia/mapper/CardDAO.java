package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.Card;
import com.jzhl.yunjia.model.CardExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * CardDAO继承基类
 */
@Mapper
public interface CardDAO extends MyBatisBaseDao<Card, Integer, CardExample> {
}