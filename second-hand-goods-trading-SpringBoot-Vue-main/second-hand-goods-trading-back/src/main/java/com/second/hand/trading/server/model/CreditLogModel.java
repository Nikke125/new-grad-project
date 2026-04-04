package com.second.hand.trading.server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangkai
 */
@Data
@TableName("sh_credit_log")
public class CreditLogModel implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Integer changeType; // 1: 增加，2: 减少
    private Integer changeScore;
    private String reason;
    private Date createTime;

}
