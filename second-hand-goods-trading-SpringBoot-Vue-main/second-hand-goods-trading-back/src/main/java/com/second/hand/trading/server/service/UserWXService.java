package com.second.hand.trading.server.service;

import com.second.hand.trading.server.model.UserModel;

public interface UserWXService {
    /**
     * 微信登录接口
     * @param code
     * @return
     */
    public String getWeChatOpenId(String code) throws Exception;


    /**
     * 获取用户信息
     * @param userModel
     * @return
     */
    public UserModel getWeChatUser(UserModel userModel);

    /**
     * 微信一键登录，处理获取openid、用户注册/登录、生成token等所有逻辑
     * @param code 微信登录凭证
     * @return 包含用户信息的UserModel及JWT token
     * @throws Exception
     */
    public UserModel wxLogin(String code) throws Exception;


}
