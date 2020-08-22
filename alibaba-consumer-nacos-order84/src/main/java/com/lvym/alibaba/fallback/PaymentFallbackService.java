package com.lvym.alibaba.fallback;

import com.lvym.alibaba.feign.PaymentService;
import com.lvym.springcloud.common.CommonResult;
import com.lvym.springcloud.entities.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        return new CommonResult(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }

}
