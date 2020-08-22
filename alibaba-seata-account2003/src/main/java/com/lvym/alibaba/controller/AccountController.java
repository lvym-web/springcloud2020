package com.lvym.alibaba.controller;

import com.lvym.alibaba.domain.CommonResult;
import com.lvym.alibaba.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        iAccountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

}
