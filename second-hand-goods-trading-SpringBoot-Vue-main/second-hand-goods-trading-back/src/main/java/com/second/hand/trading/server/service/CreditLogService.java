package com.second.hand.trading.server.service;

import com.second.hand.trading.server.model.CreditLogModel;

import java.util.List;

public interface CreditLogService {

    /**
     * 根据用户ID获取信誉积分流水
     * @param userId
     * @return
     */
    List<CreditLogModel> getCreditLogByUserId(Long userId);
}
