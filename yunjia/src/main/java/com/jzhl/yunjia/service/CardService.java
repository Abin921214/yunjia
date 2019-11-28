package com.jzhl.yunjia.service;

import com.jzhl.yunjia.mapper.CardDAO;
import com.jzhl.yunjia.model.Card;
import com.jzhl.yunjia.model.CardExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CardService {

    @Resource
    CardDAO cardDAO;

    public List<Card> selectByExample(CardExample cardExample){
        return cardDAO.selectByExample(cardExample);
    }
}
