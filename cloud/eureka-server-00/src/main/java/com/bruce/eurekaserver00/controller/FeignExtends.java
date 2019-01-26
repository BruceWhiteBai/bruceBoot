package com.bruce.eurekaserver00.controller;

import com.bruce.entity.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FeignExtends implements IFeignExtends {

    private static final Logger logger = LoggerFactory.getLogger(FeignExtends.class);


    @Override
    public String feign4(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @Override
    public User feign5(@RequestHeader("name") String name, @RequestHeader("userId") String userId) {
        return new User(userId,name,"","",0,"");
    }

    @Override
    public String feign6(User user) {
        int sleepTime = new Random().nextInt(8000);
        logger.info("feign server  sleep {}",sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + user.getUsername() + ", " + user.getUserId();
    }
}
