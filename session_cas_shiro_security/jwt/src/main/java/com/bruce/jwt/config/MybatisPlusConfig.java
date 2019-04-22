package com.bruce.jwt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.bruce.jwt.base.mapper")
public class MybatisPlusConfig {

}
