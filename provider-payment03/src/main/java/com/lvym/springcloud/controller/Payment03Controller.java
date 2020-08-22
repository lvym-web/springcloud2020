package com.lvym.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Payment03Controller {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String getSerport(){

        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();

    }
}
