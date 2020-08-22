package com.lvym.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lvym.alibaba.dao"})
public class MyBatisConfig {
}
