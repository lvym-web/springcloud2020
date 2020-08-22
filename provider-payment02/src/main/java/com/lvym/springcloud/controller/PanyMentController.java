package com.lvym.springcloud.controller;


import com.lvym.springcloud.common.CommonResult;
import com.lvym.springcloud.entities.Payment;
import com.lvym.springcloud.service.IPayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PanyMentController {
    @Autowired
    private IPayMentService iPayMentService;


    @Value("${server.port}")
    private String serport;



    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/addPay")
    public CommonResult addPay(@RequestBody(required = false) Payment payment){
        int result = iPayMentService.addPay(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功",result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = iPayMentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功"+serport,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/getDiscoveryClient")
    public Object getDiscover(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
          log.info("getServices"+"\t"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("LVYM-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getServiceId()+"\t"+instance.getInstanceId()+"\t"+instance.getScheme()+"\t"+instance.getMetadata()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serport;
    }

    /**
     * 测试feign超时
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serport;
    }


}
