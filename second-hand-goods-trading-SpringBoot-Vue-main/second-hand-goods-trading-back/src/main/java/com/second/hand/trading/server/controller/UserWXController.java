package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.model.UserModel;
import com.second.hand.trading.server.service.UserService;
import com.second.hand.trading.server.service.UserWXService;
import com.second.hand.trading.server.utils.JWTUtils;
import com.second.hand.trading.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static com.second.hand.trading.server.enums.ErrorMsg.FAIL_WX_TOKEN;

@CrossOrigin
@RestController
@RequestMapping("/user/wx")
public class UserWXController {
    @Autowired
    private UserWXService userWXService;
    @Autowired
    private UserService userService;
    /**
     * 微信登录
     * @return
     */
    @PostMapping("/login")
    public ResultVo wxLogin(@RequestBody Map<String, String> requestBody,
                            HttpServletResponse response){
        String code = requestBody.get("code");
        if (code == null || code.isEmpty()) {
            return ResultVo.fail("Code cannot be empty");
        }

        try {
            UserModel userModelWithToken = userWXService.wxLogin(code);
            
            // Set cookie for user ID, assuming userModelWithToken contains the ID
            if (userModelWithToken != null && userModelWithToken.getId() != null) {
                Cookie cookie = new Cookie("shUserId", String.valueOf(userModelWithToken.getId()));
                cookie.setPath("/");
                cookie.setHttpOnly(false); // Adjust based on security requirements
                response.addCookie(cookie);
            }
            return ResultVo.success(userModelWithToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.fail(FAIL_WX_TOKEN.getMsg() + ": " + e.getMessage());
        }
    }

}
