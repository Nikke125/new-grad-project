package com.second.hand.trading.server.service.impl;

import com.second.hand.trading.server.dao.CreditLogDao;
import com.second.hand.trading.server.model.CreditLogModel;
import com.second.hand.trading.server.service.CreditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditLogServiceImpl implements CreditLogService {

    @Autowired
    private CreditLogDao creditLogDao;

    @Override
    public List<CreditLogModel> getCreditLogByUserId(Long userId) {
        return creditLogDao.selectByUserId(userId);
    }
}
