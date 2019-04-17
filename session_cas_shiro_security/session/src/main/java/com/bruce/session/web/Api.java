package com.bruce.session.web;

import com.alibaba.fastjson.JSONObject;
import com.bruce.session.vo.ReturnData;
import com.bruce.session.vo.StatusCode;
import com.bruce.session.vo.UserLongin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class Api {

    private static final Logger logger = LoggerFactory.getLogger(Api.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public ReturnData login(HttpServletRequest request, String account, String password) {
        UserLongin userLongin = new UserLongin(1L,"a","a");
        if (userLongin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", userLongin.getId());
            redisTemplate.opsForValue().set("loginUser:" + userLongin.getId(), session.getId());

            return new ReturnData(StatusCode.REQUEST_SUCCESS, "登录成功！", JSONObject.toJSONString(userLongin));
        } else {
            //throw new MyException(StatusCode.ACCOUNT_OR_PASSWORD_ERROR, "账户名或密码错误！");
            throw new RuntimeException("账户名或密码错误！");
        }
    }

    @RequestMapping(value = "/getUserInfo")
    public ReturnData get(long userId) {
        UserLongin user = new UserLongin(1L,"a","a");
        if (user != null) {
            return new ReturnData(StatusCode.REQUEST_SUCCESS, "查询成功！", JSONObject.toJSONString(user));
        } else {
//            throw new MyException(StatusCode.USER_NOT_EXIST, "用户不存在！");
            throw new RuntimeException("账户名或密码错误！");
        }
    }


}