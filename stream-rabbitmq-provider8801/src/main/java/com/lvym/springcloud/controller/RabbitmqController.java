package com.lvym.springcloud.controller;

import com.lvym.springcloud.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    @Autowired
    private IRabbitmqService iRabbitmqService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
      return   iRabbitmqService.send();
    }

}
