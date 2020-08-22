package com.lvym.springcloud.controller;

import com.lvym.springcloud.common.CommonResult;
import com.lvym.springcloud.entities.Payment;
import com.lvym.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://LVYM-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/postForEntity")
    public CommonResult<Payment> addPay(Payment payment){

        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/addPay", payment, CommonResult.class);

        return  commonResultResponseEntity.getBody();
    }
    @GetMapping(value = "/consumer/payment/addPay")
    public CommonResult<Payment> addPay2(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/addPay",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        }
    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById02(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCodeValue()+"/t"+entity.getHeaders()+"\t"+entity.getStatusCode());
            return entity.getBody();
        }else {
            return new CommonResult(555,"查询失败");
        }
    }
/*自定义
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;*/

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
/*
        List<ServiceInstance> instances = discoveryClient.getInstances("LVYM-PAYMENT-SERVICE");
        if (instances.size()<=0 || instances==null){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);*/
     return restTemplate.getForObject(PAYMENT_URL+"/payment/lb",String.class);
    }


    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }

}
