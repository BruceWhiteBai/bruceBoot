package com.bruce.jwt;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.bruce.jwt.base.entity.TUser;
import com.bruce.jwt.base.mapper.TUserMapper;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.UUID;

public class CrudTest extends JwtApplicationTests {
    @Resource
    private TUserMapper userMapper;

    @Test
    public void Insert() {
        TUser user = new TUser();
        user.setUsername("阿斯蒂芬").setPhoneNum(123).setDeleteFlag(0);
        int num = userMapper.insert(user);
        Assert.assertTrue(num > 0);
        System.out.println("插入成功Id为" + user.getUserId());
    }

    /*
    @Test
    public void Delete() {
        Assert.assertTrue(userMapper.deleteById(14L) > 0);
        Assert.assertTrue(userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getName, "我是付林")) > 0);
    }

    @Test
    public void Update() {
        Assert.assertTrue(userMapper.updateById(new User().setId(1L).setAge(100).setName("我是付林")) > 0);
        Assert.assertTrue(userMapper.update(new User(),
                new UpdateWrapper<User>().lambda().set(User::getAge, 2).eq(User::getId, 2)
        ) > 0);
    }

    @Test
    public void Select() {
        Assert.assertEquals("cfulin", userMapper.selectById(3L).getName());
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 2));
        Assert.assertEquals("付林1", user.getName());
        Assert.assertTrue(2 == user.getAge());
    }*/
}
