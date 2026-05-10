package com.second.hand.trading.server.service;

import com.second.hand.trading.server.model.AdminModel;
import com.second.hand.trading.server.vo.PageVo;
import java.util.Map;
import java.util.List;

public interface AdminService {

    AdminModel login(String accountNumber, String adminPassword);

    PageVo<AdminModel> getAdminList(int page, int nums);

    boolean addAdmin(AdminModel adminModel);

    Map<String, Object> getStatisticsOverview();

    List<Map<String, Object>> getOrdersLast7Days();

    List<Map<String, Object>> getCategoryStatistics();

}
