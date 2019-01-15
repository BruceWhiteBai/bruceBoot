package com.bruce.eurekaserver01.controller;


import com.netflix.appinfo.EurekaInstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @RequestMapping("/index")
    public String index() {
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString().concat(" server-info" + eurekaInstanceConfig.getInstanceId() + "---" + eurekaInstanceConfig.getHostName(false));
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }
}
