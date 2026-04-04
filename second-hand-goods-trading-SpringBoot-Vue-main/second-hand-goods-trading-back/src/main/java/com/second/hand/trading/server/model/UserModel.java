package com.second.hand.trading.server.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sh_user
 * @author myl
 */
@Data
public class UserModel implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 账号（手机号）
     */
    private String accountNumber;

    /**
     * 登录密码
     */
    private String userPassword;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private Date signInTime;

    private Byte userStatus;

    /**
     * 微信openid
     */
    private String wxOpenid;

    /**
     * 用户分类：1：账号密码登录
     *          2：微信授权登录
     */
    private String userType;

    /**
     * 微信code
     */
    private String code;

    /**
     * 微信token
     */
    private String token;

    /**
     * 信誉积分
     */
    private Integer creditScore;

    private static final long serialVersionUID = 1L;
}