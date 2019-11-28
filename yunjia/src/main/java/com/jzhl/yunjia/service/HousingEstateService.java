package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.HousingEstateDAO;
import com.jzhl.yunjia.model.HousingEstate;
import com.jzhl.yunjia.model.HousingEstateExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HousingEstateService {

    @Resource
    HousingEstateDAO housingEstateDAO;

    public List<HousingEstate> selectByExample(HousingEstateExample housingEstateExample){
        return housingEstateDAO.selectByExample(housingEstateExample);
    }
}
