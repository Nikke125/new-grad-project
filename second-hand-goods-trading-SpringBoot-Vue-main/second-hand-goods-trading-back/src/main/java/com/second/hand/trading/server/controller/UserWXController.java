package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.enums.ErrorMsg;
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
//     public ResultVo wxLogin(@RequestBody Map<String, String> requestBody,
//                             HttpServletResponse response){
//         String code = requestBody.get("code");
//         if (code == null || code.isEmpty()) {
//             // 改成这样 ✅
// return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
//         }

//         try {
//             UserModel userModelWithToken = userWXService.wxLogin(code);
            
//             // Set cookie for user ID, assuming userModelWithToken contains the ID
//             if (userModelWithToken != null && userModelWithToken.getId() != null) {
//                 Cookie cookie = new Cookie("shUserId", String.valueOf(userModelWithToken.getId()));
//                 cookie.setPath("/");
//                 cookie.setHttpOnly(false); // Adjust based on security requirements
//                 response.addCookie(cookie);
//             }
//             return ResultVo.success(userModelWithToken);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
//         }
//     }

// 注解保持你原来的样子，比如 @PostMapping("/login") 
    // 把方法的参数和里面改成这样：
    public ResultVo wxLogin(String code, @RequestBody(required = false) java.util.Map<String, String> body) {
        try {
            // 1. 终极兼容：不管前端把 code 放在 URL 还是 Body 里，我们全都要！
            String finalCode = code;
            if (finalCode == null && body != null) {
                finalCode = body.get("code");
            }
            
            System.out.println("====== 后端终于拿到的 code 是: " + finalCode + " ======");

            // 如果连兼容大法都拿不到，直接抛出异常
            if (finalCode == null || finalCode.isEmpty()) {
                throw new RuntimeException("完蛋，接收到的 code 是空的！");
            }

            // 2. 调用微信登录核心逻辑
            UserModel user = userWXService.wxLogin(finalCode);
            
            // 3. 返回成功数据
            return ResultVo.success(user); // 💡注意：如果这行在你的 IDEA 里报红，请换回你原本不报红的写法（比如 ResultVo.success("成功", user) 等）
            
        } catch (Exception e) {
            // 🚨 救命代码：强制在控制台打印满屏红字，告诉你真正的死因！
            e.printStackTrace(); 
            return ResultVo.fail(ErrorMsg.SYSTEM_ERROR);
        }
    }
}
