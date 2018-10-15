package com.bruce;

import com.bruce.entity.dto.User;
import com.bruce.service.userService.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends WebApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void test01(){
        User user = userService.getUserById(String.valueOf(1));
        System.out.println("user obj " + user.getUserId() );

    }
}
