package com.lvym.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9003.class,args);
    }
}
