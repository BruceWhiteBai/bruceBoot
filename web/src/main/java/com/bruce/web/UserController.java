package com.bruce.web;

import com.bruce.entity.dto.User;
import com.bruce.redis.RedisService;
import com.bruce.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/index")
    public String init(){
        return userService.init();
    }

    @GetMapping("/list")
    public List<User> list() {
        return  userService.list();
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "id") String id) {
        return  userService.getUserById(id);
    }

    @GetMapping("/deleteById")
    public int deleteById(@RequestParam(value = "id") String id) {
        return  userService.deleteById(id);
    }

    @GetMapping("/clearUserCache")
    public String clearUserCache() {
        userService.clearUserCache();
        return " userService.clearUserCache()";
    }

    @GetMapping("/redis")
    public boolean redis(@RequestParam(value = "key") String key,@RequestParam(value = "value") String value) {
        return  redisService.set(key,value);
    }
}
