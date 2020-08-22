package com.lvym.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02.class,args);
    }
}