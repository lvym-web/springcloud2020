package com.lvym.springcloud.feignFallback;

import com.lvym.springcloud.feign.OrderToPayment;
import org.springframework.stereotype.Component;

@Component
public class Fallback implements OrderToPayment {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

}
