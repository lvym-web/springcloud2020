package com.lvym.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLog {

    @Bean
    Logger.Level getFeignLog(){
        return Logger.Level.FULL;
    }
}
