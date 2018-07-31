package com.bruce.web;

import com.bruce.entity.dto.User;
import com.bruce.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String init(){
        return userService.init();
    }

    @GetMapping("list")
    public List<User> list() {
        return  userService.list();
    }
}
