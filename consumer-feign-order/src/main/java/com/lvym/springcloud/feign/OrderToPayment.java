package com.lvym.springcloud.feign;


import com.lvym.springcloud.common.CommonResult;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "LVYM-PAYMENT-SERVICE")
public interface OrderToPayment {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
