package com.lvym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignOrder {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder.class,args);
    }
}
