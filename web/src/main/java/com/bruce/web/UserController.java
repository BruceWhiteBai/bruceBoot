package com.bruce.web;

import com.bruce.entity.dto.User;
import com.bruce.redis.RedisService;
import com.bruce.service.userService.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/list")
    public List<User> list() {
        return  userService.list();
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "id") String id) {
        return  userService.getUserById(id);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来删除")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
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
