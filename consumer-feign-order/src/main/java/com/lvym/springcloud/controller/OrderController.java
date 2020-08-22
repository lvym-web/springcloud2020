package com.lvym.springcloud.controller;

import com.lvym.springcloud.common.CommonResult;
import com.lvym.springcloud.entities.Payment;
import com.lvym.springcloud.feign.OrderToPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderToPayment orderToPayment;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return orderToPayment.getPaymentById(id);
    }


    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
       return orderToPayment.paymentFeignTimeout();
    }
}
