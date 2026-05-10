package com.second.hand.trading.server.service.impl;

import com.second.hand.trading.server.dao.AdminDao;
import com.second.hand.trading.server.dao.IdleItemDao;
import com.second.hand.trading.server.dao.OrderDao;
import com.second.hand.trading.server.dao.UserDao;
import com.second.hand.trading.server.model.AdminModel;
import com.second.hand.trading.server.service.AdminService;
import com.second.hand.trading.server.vo.PageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Resource
    private UserDao userDao;

    @Resource
    private IdleItemDao idleItemDao;

    @Resource
    private OrderDao orderDao;

    public AdminModel login(String accountNumber, String adminPassword){
        return adminDao.login(accountNumber,adminPassword);
    }

    public PageVo<AdminModel> getAdminList(int page, int nums){
        List<AdminModel> list=adminDao.getList((page-1)*nums,nums);
        int count=adminDao.getCount();
        return new PageVo<>(list,count);
    }

    public boolean addAdmin(AdminModel adminModel){
        return adminDao.insert(adminModel)==1;
    }

    @Override
    public Map<String, Object> getStatisticsOverview() {
        Map<String, Object> result = new HashMap<>();
        int totalUsers = userDao.countAllUser();
        int totalProducts = idleItemDao.countAllIdleItem();
        int totalOrders = orderDao.countAllOrder();
        BigDecimal totalTransactionAmount = orderDao.sumCompletedOrderPrice();
        result.put("totalUsers", totalUsers);
        result.put("totalProducts", totalProducts);
        result.put("totalOrders", totalOrders);
        result.put("totalTransactionAmount", totalTransactionAmount != null ? totalTransactionAmount : BigDecimal.ZERO);
        return result;
    }

    @Override
    public List<Map<String, Object>> getOrdersLast7Days() {
        return orderDao.countOrdersByLast7Days();
    }

    @Override
    public List<Map<String, Object>> getCategoryStatistics() {
        return idleItemDao.countIdleItemByCategory();
    }
}
