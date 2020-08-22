package com.lvym.alibaba.controller;

import com.lvym.alibaba.domain.CommonResult;
import com.lvym.alibaba.domain.Order;
import com.lvym.alibaba.server.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private IOrderService iOrderService;
    @GetMapping("/order/create")
    public CommonResult create(Order order){
        iOrderService.create(order);
        return new CommonResult(200,"订单创建成功");

    }

}
