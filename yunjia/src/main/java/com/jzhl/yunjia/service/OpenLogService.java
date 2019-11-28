package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.OpenLogDAO;
import com.jzhl.yunjia.model.OpenLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenLogService {

    @Resource
    OpenLogDAO openLogDAO;

    public int insert(OpenLog openLog){
        return openLogDAO.insertSelective(openLog);
    }
}
