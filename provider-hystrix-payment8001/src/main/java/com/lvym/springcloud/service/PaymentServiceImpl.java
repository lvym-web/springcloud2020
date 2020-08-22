package com.lvym.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class PaymentServiceImpl {

    public String paymentInfo_OK(Integer id) {

        return "线程池的名称:" + Thread.currentThread().getName() + "\t" + "id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallbackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")})
    public String paymentInfo_TimeOut(Integer id) {
        long start = System.currentTimeMillis();
        int time = 2;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return "线程池的名称:" + Thread.currentThread().getName() + "\t" + "id:" + id + "耗时" + (start - end) + "毫秒";
    }

    public String paymentInfo_TimeOutFallbackMethod(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试 " + "\t" + "id:" + id;
    }

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id不能小于零");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + uuid;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
