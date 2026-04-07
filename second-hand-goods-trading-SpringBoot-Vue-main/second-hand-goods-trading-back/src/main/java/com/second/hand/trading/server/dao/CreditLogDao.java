package com.second.hand.trading.server.dao;

import com.second.hand.trading.server.model.CreditLogModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangkai
 */
@Mapper
public interface CreditLogDao {

    int insert(CreditLogModel creditLogModel);

    List<CreditLogModel> selectByUserId(@Param("userId") Long userId);

}
