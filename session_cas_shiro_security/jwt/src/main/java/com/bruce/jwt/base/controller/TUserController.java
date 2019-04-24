package com.bruce.jwt.base.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bruce.jwt.base.entity.TUser;
import com.bruce.jwt.base.service.ITUserService;
import com.bruce.jwt.config.jwt.JwtUtils;
import com.bruce.jwt.config.jwt.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bruce
 * @since 2019-04-22
 */
@Controller
@RequestMapping("/base/t-user")
public class TUserController {

    @Autowired
    ITUserService userService;


    //登录
    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody TUser user) {
        JSONObject jsonObject = new JSONObject();
        TUser userForBase = userService.getOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername, user.getUsername()).eq(TUser::getPassword,user.getPassword()));
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = JwtUtils.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage() {
        return "你已通过验证";
    }

}
