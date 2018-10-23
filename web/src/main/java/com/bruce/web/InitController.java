package com.bruce.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {


    @Value("${info.env.param}")
    private String env;

    @Value("${info.env.randomValue}")
    private String randomValue;

    @Value("${info.env.randomNum}")
    private String randomNum;

    @RequestMapping("/")
    public String init(){
        return "application init env "+env;
    }


    @RequestMapping("/randomValue")
    public String randomValue(){
        return "application init randomValue "+randomValue;
    }


    @RequestMapping("/randomNum")
    public String randomNum(){
        return "application init randomValue "+randomNum;
    }
}
