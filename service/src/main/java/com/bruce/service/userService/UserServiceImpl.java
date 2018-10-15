package com.bruce.service.userService;

import com.bruce.entity.dto.User;
import com.bruce.repo.userRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {



    @Autowired
    UserRepository userRepository;

    @Override
    public String init() {
        return "user service init";
    }

    @Override
    public List<User> list() {
        return userRepository.selectAll();

    }

    @Override
    @Cacheable(value="user",key="'user'.concat(#id)")
    public User getUserById(String id) {
        return userRepository.selectByPrimaryKey(id);
    }

    /**
     * 清除缓存
     * beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = "user",key="'user'.concat(#id)",allEntries = false,beforeInvocation = false)
    public int deleteById(String id) {
        User user=userRepository.selectByPrimaryKey(id);
        user.setDeleteFlag(1);
        return userRepository.updateByPrimaryKey(user);
    }

    /**
     * allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。当指定了allEntries为true时，Spring Cache将忽略指定的key。
     */
    @Override
    @CacheEvict(value = "user",allEntries = true)
    public void clearUserCache() {

    }
}