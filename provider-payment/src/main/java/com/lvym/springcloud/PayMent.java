package com.lvym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayMent {
    public static void main(String[] args) {
        SpringApplication.run(PayMent.class,args);
    }
}
