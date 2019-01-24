package com.bruce.eurekaserver00.controller;

import com.bruce.entity.dto.User;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignExtends implements IFeignExtends {

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
        return "Hello " + user.getUsername() + ", " + user.getUserId();
    }
}
