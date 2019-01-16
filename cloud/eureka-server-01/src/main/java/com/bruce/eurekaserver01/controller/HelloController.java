package com.bruce.eurekaserver01.controller;


import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Random;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @RequestMapping("/index")
    public String index() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        //xxx  Hystrix 默认超时时间为 2000 毫秒
        logger.info("{} sleep {}",eurekaInstanceConfig.getInstanceId(),sleepTime);
        Thread.sleep(sleepTime);
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString().concat(" server-info" + eurekaInstanceConfig.getInstanceId() + "---" + eurekaInstanceConfig.getHostName(false));
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }
}
