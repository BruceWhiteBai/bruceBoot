package com.bruce.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configInfo")
public class ConfigInfo {


    @RequestMapping("/config1")
    public String config1(){
        return "config 123 "  ;
    }
}
