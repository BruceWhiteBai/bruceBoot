package com.bruce.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    @RequestMapping("/hello")
    public String hello() {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    @RequestMapping("/index")
    public String index() {
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString();
    }

    //todo get请求 post请求 put请求 delete请求

}
