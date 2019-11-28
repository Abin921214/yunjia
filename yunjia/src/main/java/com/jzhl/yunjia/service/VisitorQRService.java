package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.VisitorQrDAO;
import com.jzhl.yunjia.model.VisitorQr;
import com.jzhl.yunjia.model.VisitorQrExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VisitorQRService {

    @Resource
    VisitorQrDAO visitorQrDAO;

    public List<VisitorQr> selectByExample(VisitorQrExample visitorQrExample){
        return visitorQrDAO.selectByExample(visitorQrExample);
    }
}
