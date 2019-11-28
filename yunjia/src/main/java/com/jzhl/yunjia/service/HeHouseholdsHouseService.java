package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.HeHouseholdsHouseDAO;
import com.jzhl.yunjia.model.HeHouseholdsHouse;
import com.jzhl.yunjia.model.HeHouseholdsHouseExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HeHouseholdsHouseService {

    @Resource
    HeHouseholdsHouseDAO heHouseholdsHouseDAO;

    public List<HeHouseholdsHouse> selectByExample(HeHouseholdsHouseExample heHouseholdsHouseExample){
        return heHouseholdsHouseDAO.selectByExample(heHouseholdsHouseExample);
    }
}
