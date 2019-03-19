package com.bruce.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configInfo")
public class ConfigInfo {

    @RequestMapping("/config1")
    public String config1(){
        return "config 123";
    }
}
