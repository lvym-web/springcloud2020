package com.lvym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//似乎可以不写
public class PayMent02 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent02.class,args);
    }
}
