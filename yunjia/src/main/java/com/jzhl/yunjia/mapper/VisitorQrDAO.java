package com.jzhl.yunjia.mapper;

import com.jzhl.yunjia.model.VisitorQr;
import com.jzhl.yunjia.model.VisitorQrExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * VisitorQrDAO继承基类
 */
@Mapper
public interface VisitorQrDAO extends MyBatisBaseDao<VisitorQr, Integer, VisitorQrExample> {
}