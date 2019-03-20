package com.bruce.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/configInfo")
public class ConfigInfo {

    /**
     * 注解的方式获取配置中心配置
     */
    @Value("${from}")
    private String from;

    /**
     *使用environment获取配置
     */
    @Autowired
    private Environment environment;


    @RequestMapping("/config1")
    public String config1(){
        return "config 123 " + from ;
    }


    @RequestMapping("/config2")
    public String config2(){
        return "config 123 " + environment.getProperty("from") + " --- " + environment.getProperty("get");
    }


}
