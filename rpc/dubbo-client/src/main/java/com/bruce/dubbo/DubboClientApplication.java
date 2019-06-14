package com.bruce.dubbo;

import com.bruce.dubbo.dubbo.CityDubboConsumerService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo
public class DubboClientApplication {

    public static void main(String[] args) {
        //to solve  error : [xxx is not visible from class loader]
//        System.setProperty("spring.devtools.restart.enabled", "false");
        //去掉devtools
        // IllegalArgumentException: java.lang.ClassCastException: com.bruce.dubbo.dubbo.impl.CityDubboServiceImpl cannot be cast to com.bruce.dubbo.dubbo.impl.CityDubboServiceImpl

        ConfigurableApplicationContext run = SpringApplication.run(DubboClientApplication.class, args);
        CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
        cityService.printCity();
    }

}

