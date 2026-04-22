package com.second.hand.trading.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.second.hand.trading.server.dao.UserWXDao;
import com.second.hand.trading.server.model.UserModel;
import com.second.hand.trading.server.service.UserWXService;
import com.second.hand.trading.server.utils.JWTUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserWXServiceImpl implements UserWXService {

    //微信服务接口地址
    public static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";
    @Value("${wx.appid}")
    private String wxAppId;

    @Value("${wx.secret}")
    private String wxSecret;

    @Resource
    private UserWXDao userWXDao;


//     public String getWeChatOpenId(String code) throws Exception {
//         String url = String.format(
//         "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
//                 wxAppId, wxSecret, code
//         );
// //        System.out.println("请求URL: " + url); // 打印完整URL
//         CloseableHttpClient client = HttpClients.createDefault();
//         HttpGet request = new HttpGet(url);
//         String response = EntityUtils.toString(client.execute(request).getEntity());
//         JSONObject json = JSONObject.parseObject(response);
// //        System.out.println("response: "+response);
// //        System.out.println("openid: "+json.getString("openid"));
//         return json.getString("openid"); // 可能包含session_key
//     }
public String getWeChatOpenId(String code) throws Exception {
        String URL = String.format(
                "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                wxAppId, wxSecret, code
        );
        // 🚨 检查点 1：看看你从配置文件里读出来的 appId 是不是 null！
        System.out.println("🚨 准备发送给微信的 AppID 是: " + wxAppId);
        System.out.println("🚨 准备发送给微信的 Secret 是: " + wxSecret);
        System.out.println("🚨 完整的请求URL： " + URL);

        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(URL);
            String response = EntityUtils.toString(client.execute(request).getEntity());
            
            // 🚨 检查点 2：必须把微信的返回结果印出来！
            System.out.println("🚨 微信官方返回的内容是：" + response);
            
            JSONObject json = JSONObject.parseObject(response);
            String openid = json.getString("openid");
            
            if (openid == null) {
                System.out.println("🚨 糟糕，返回的 JSON 里没有 openid！可能是 errcode: " + json.getString("errcode"));
            }
            
            return openid;
        } catch (Exception e) {
            System.out.println("🚨 极其严重的错误：在请求微信接口时代码直接崩溃了！");
            e.printStackTrace();
            throw e;
        }
    }

    public UserModel getWeChatUser(UserModel userModel) {
        UserModel userModel_=userWXDao.getWXUserToOpenid(userModel.getWxOpenid());
        if (userModel_ == null){
            userWXDao.insertWXUser(userModel);
            userModel_=userWXDao.getWXUserToOpenid(userModel.getWxOpenid());
        }else {
            System.out.println("---------------");
            userWXDao.updateWXUser(userModel);
            userModel_=userWXDao.getWXUserToOpenid(userModel.getWxOpenid());
        }
        System.out.println("getWeChatUser: "+userModel_);
        return userModel_;
    }

    @Override
    public UserModel wxLogin(String code) throws Exception {
        // 1. 获取openid
        String openid = getWeChatOpenId(code);
        if (openid == null || openid.isEmpty()) {
            throw new RuntimeException("Failed to get openid from WeChat.");
        }

        // 2. 根据openid查询或注册用户
        UserModel user = userWXDao.getWXUserToOpenid(openid);

        if (user == null) {
            // 新用户注册
            user = new UserModel();
            user.setWxOpenid(openid);
            user.setAvatar("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"); // 默认头像
            user.setNickname("微信用户_" + openid.substring(0, 8)); // 默认昵称
            user.setSignInTime(new Timestamp(System.currentTimeMillis()));
            userWXDao.insertWXUser(user);
            user = userWXDao.getWXUserToOpenid(openid); // 重新获取包含ID的用户信息
        } else {
            // 已有用户，更新登录时间
            user.setSignInTime(new Timestamp(System.currentTimeMillis()));
            userWXDao.updateWXUser(user);
        }

        // 3. 生成JWT Token
        String token = JWTUtils.generateToken(openid);
        user.setToken(token);

        return user;
    }

}
