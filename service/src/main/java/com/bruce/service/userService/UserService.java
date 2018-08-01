package com.bruce.service.userService;

import com.bruce.entity.dto.User;

import java.util.List;

public interface UserService {

     List<User> list();

     String init();

     User getUserById(String id);
}
