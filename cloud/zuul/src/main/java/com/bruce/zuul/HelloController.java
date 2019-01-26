package com.bruce.zuul;


import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String index()  {
        List<String> services = eurekaDiscoveryClient.getServices();
        return services.toString().concat(" server-info" + eurekaInstanceConfig.getInstanceId() + "---" + eurekaInstanceConfig.getHostName(false));
    }


}
