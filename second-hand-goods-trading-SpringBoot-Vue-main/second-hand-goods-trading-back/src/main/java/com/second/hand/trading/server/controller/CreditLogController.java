package com.second.hand.trading.server.controller;

import com.second.hand.trading.server.service.CreditLogService;
import com.second.hand.trading.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
@RequestMapping("/credit/log")
public class CreditLogController {

    @Autowired
    private CreditLogService creditLogService;

    /**
     * 获取个人信誉积分流水
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResultVo getCreditLogList(@RequestParam("userId") @NotNull(message = "用户ID不能为空") Long userId) {
        return ResultVo.success(creditLogService.getCreditLogByUserId(userId));
    }
}
