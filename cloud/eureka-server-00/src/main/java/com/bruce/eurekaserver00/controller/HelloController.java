package com.bruce.eurekaserver00.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;


    @RequestMapping("/index")
    public String index(){
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString();
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }
}
