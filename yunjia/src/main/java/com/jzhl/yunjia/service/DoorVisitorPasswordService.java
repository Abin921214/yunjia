package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.DoorVisitorPasswordDAO;
import com.jzhl.yunjia.model.DoorVisitorPassword;
import com.jzhl.yunjia.model.DoorVisitorPasswordExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DoorVisitorPasswordService {

    @Resource
    DoorVisitorPasswordDAO doorVisitorPasswordDAO;

    public List<DoorVisitorPassword> getDVP(Integer heId, Integer buildingId, Integer unitId, Integer companyId, String pwd){

        System.out.println("heId:" + heId + "    buildingId:" + buildingId + "     unitId:" + unitId + "      companyId: " + companyId + "    pwd:" + pwd);

        DoorVisitorPasswordExample doorVisitorPasswordExample = new DoorVisitorPasswordExample();
        DoorVisitorPasswordExample.Criteria criteria = doorVisitorPasswordExample.createCriteria();
        criteria.andCompanyIdEqualTo(companyId);
        criteria.andHeIdEqualTo(heId);
        if(buildingId != null && buildingId != 0){
            criteria.andBuildingIdEqualTo(buildingId);
        }

        if(unitId != null && unitId != 0){
            criteria.andUnitIdEqualTo(unitId);
        }

        criteria.andPwdEqualTo(pwd);
        criteria.andDelFlagEqualTo("0");
        criteria.andStatusEqualTo("0");

        List<DoorVisitorPassword> doorVisitorPasswords = doorVisitorPasswordDAO.selectByExample(doorVisitorPasswordExample);
        return doorVisitorPasswords;
    }

}
