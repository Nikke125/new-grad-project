package com.second.hand.trading.server.service.impl;

import com.second.hand.trading.server.dao.CreditLogDao;
import com.second.hand.trading.server.dao.IdleItemDao;
import com.second.hand.trading.server.dao.UserDao;
import com.second.hand.trading.server.model.CreditLogModel;
import com.second.hand.trading.server.model.IdleItemModel;
import com.second.hand.trading.server.model.UserModel;
import com.second.hand.trading.server.service.IdleItemService;
import com.second.hand.trading.server.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class IdleItemServiceImpl implements IdleItemService {

    @Resource
    private IdleItemDao idleItemDao;

    @Resource
    private UserDao userDao;

    @Resource
    private CreditLogDao creditLogDao;

    /**
     * 发布闲置
     * @param idleItemModel
     * @return
     */
    public boolean addIdleItem(IdleItemModel idleItemModel) {
        return idleItemDao.insert(idleItemModel) == 1;
    }

    /**
     * 查询闲置信息，同时查出发布者的信息
     * @param id
     * @return
     */
    public IdleItemModel getIdleItem(Long id) {
        IdleItemModel idleItemModel=idleItemDao.selectByPrimaryKey(id);
        if(idleItemModel!=null){
            idleItemModel.setUser(userDao.selectByPrimaryKey(idleItemModel.getUserId()));
        }
        return idleItemModel;
    }

    /**
     * 查询用户发布的所有闲置
     * user_id建索引
     * @param userId
     * @return
     */
    public List<IdleItemModel> getAllIdelItem(Long userId) {
        return idleItemDao.getAllIdleItem(userId);
    }

    /**
     * 搜索，分页
     * 同时查出闲置发布者的信息
     * 默认只查询在售状态 (status = 0) 的商品
     * @param findValue
     * @param page
     * @param nums
     * @return
     */
    public PageVo<IdleItemModel> findIdleItem(String findValue, int page, int nums,Boolean randomPick) {
        List<IdleItemModel> list = null;
        int count=0;
        if (randomPick==null || randomPick == false){
            list=idleItemDao.findIdleItem(findValue, (page - 1) * nums, nums,randomPick);
            count=idleItemDao.countIdleItem(findValue);
        }else {
            list=idleItemDao.findIdleItem(findValue, (page - 1) * nums, 40,randomPick);
            Collections.shuffle(list); // 打乱顺序
            // 将 list 的个数减少到 4 个
            if (list != null && list.size() > nums) {
                list = list.subList(0, nums); // 截取前 5 个商品
                count = nums;
            }
        }

        // 过滤：只保留在售状态 (status = 0) 的商品
        if(list != null && list.size() > 0){
            List<IdleItemModel> filteredList = new ArrayList<>();
            for(IdleItemModel item : list){
                if(item.getStatus() == null || item.getStatus().equals(IdleItemModel.STATUS_AVAILABLE)){
                    filteredList.add(item);
                }
            }
            list = filteredList;
        }

        if(list.size()>0){
            List<Long> idList=new ArrayList<>();
            for(IdleItemModel i:list){
                idList.add(i.getUserId());
            }
            /*获取商品对应的卖家信息*/
            List<UserModel> userList=userDao.findUserByList(idList);
            Map<Long,UserModel> map=new HashMap<>();
            for(UserModel user:userList){
                map.put(user.getId(),user);
            }
            for(IdleItemModel i:list){
                i.setUser(map.get(i.getUserId()));
            }
        }

        return new PageVo<>(list,count);
    }

    /**
     * 分类查询，分页
     * 同时查出闲置发布者的信息，代码结构与上面的类似，可封装优化，或改为join查询
     * 默认只查询在售状态 (status = 0) 的商品
     * @param idleLabel
     * @param page
     * @param nums
     * @return
     */
    public PageVo<IdleItemModel> findIdleItemByLable(int idleLabel, int page, int nums) {
        List<IdleItemModel> list=idleItemDao.findIdleItemByLable(idleLabel, (page - 1) * nums, nums);
        
        // 过滤：只保留在售状态 (status = 0) 的商品
        if(list != null && list.size() > 0){
            List<IdleItemModel> filteredList = new ArrayList<>();
            for(IdleItemModel item : list){
                if(item.getStatus() == null || item.getStatus().equals(IdleItemModel.STATUS_AVAILABLE)){
                    filteredList.add(item);
                }
            }
            list = filteredList;
        }
        
        if(list.size()>0){
            List<Long> idList=new ArrayList<>();
            for(IdleItemModel i:list){
                idList.add(i.getUserId());
            }
            List<UserModel> userList=userDao.findUserByList(idList);
            Map<Long,UserModel> map=new HashMap<>();
            for(UserModel user:userList){
                map.put(user.getId(),user);
            }
            for(IdleItemModel i:list){
                i.setUser(map.get(i.getUserId()));
            }
        }
        int count=idleItemDao.countIdleItemByLable(idleLabel);
        return new PageVo<>(list,count);
    }

    /**
     * 更新闲置信息
     * @param idleItemModel
     * @return
     */
    public boolean updateIdleItem(IdleItemModel idleItemModel){
        int n = idleItemDao.updateByPrimaryKeySelective(idleItemModel);
        System.out.println("idleItemDao.updateByPrimaryKeySelective(idleItemModel): "+n);
        return n==1;
    }

    public PageVo<IdleItemModel> adminGetIdleList(int status, int page, int nums) {
        List<IdleItemModel> list=idleItemDao.getIdleItemByStatus(status, (page - 1) * nums, nums);
        if(list.size()>0){
            List<Long> idList=new ArrayList<>();
            for(IdleItemModel i:list){
                idList.add(i.getUserId());
            }
            List<UserModel> userList=userDao.findUserByList(idList);
            Map<Long,UserModel> map=new HashMap<>();
            for(UserModel user:userList){
                map.put(user.getId(),user);
            }
            for(IdleItemModel i:list){
                i.setUser(map.get(i.getUserId()));
            }
        }
        int count=idleItemDao.countIdleItemByStatus(status);
        return new PageVo<>(list,count);
    }


    /**
     * 更新商品交易状态（状态机流转）
     * @param itemId 商品ID
     * @param targetStatus 目标状态 (0-在售, 1-被预订/交易中, 2-已售出, 3-已下架)
     * @return 是否更新成功
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateItemStatus(Long itemId, Integer targetStatus) {
        // 验证目标状态是否合法
        if(targetStatus == null || (targetStatus < 0 || targetStatus > 3)){
            return false;
        }
        
        IdleItemModel idleItemModel = new IdleItemModel();
        idleItemModel.setId(itemId);
        idleItemModel.setStatus(targetStatus);
        
        int result = idleItemDao.updateByPrimaryKeySelective(idleItemModel);
        
        if (result == 1 && targetStatus == IdleItemModel.STATUS_SOLD) { // 假设STATUS_SOLD为2
            IdleItemModel updatedItem = idleItemDao.selectByPrimaryKey(itemId);
            if (updatedItem != null) {
                Long sellerUserId = updatedItem.getUserId();
                // 增加卖家信誉积分
                userDao.addCreditScore(sellerUserId, 10);
                
                // 记录信誉积分流水
                CreditLogModel creditLog = new CreditLogModel();
                creditLog.setUserId(sellerUserId);
                creditLog.setChangeType(1); // 1: 增加
                creditLog.setChangeScore(10);
                creditLog.setReason("闲置物品交易成功，获得积分");
                creditLog.setCreateTime(new Date());
                creditLogDao.insert(creditLog);
            }
        }
        return result == 1;
    }

    public List<IdleItemModel> getRandomBannerImages() {
        // 1. 查询所有商品
        List<IdleItemModel> allProducts = idleItemDao.findBanner();
        // 2. 随机挑选 5 个商品
        List<IdleItemModel> randomImages = new ArrayList<>();
        if (!allProducts.isEmpty()) {
            Collections.shuffle(allProducts); // 打乱顺序
            for (int i = 0; i < Math.min(5, allProducts.size()); i++) {
                IdleItemModel idleItemModel = new IdleItemModel();
                idleItemModel.setPictureList(allProducts.get(i).getPictureList());
                idleItemModel.setId(allProducts.get(i).getId());
                randomImages.add(idleItemModel);
            }
        }
        return randomImages;
    }
}
