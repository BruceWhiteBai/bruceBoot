package com.bruce.jwt;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bruce.jwt.base.entity.TUser;
import com.bruce.jwt.base.mapper.TUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Collections;

public class CrudTest extends JwtApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(CrudTest.class);

    @Resource
    private TUserMapper userMapper;

    @Test
    public void Insert() {
        TUser user = new TUser();
        user.setUsername("阿斯蒂芬").setPhoneNum(123).setDeleteFlag(0).setPassword("psw123");
        int num = userMapper.insert(user);

        Assert.assertTrue(num > 0);
        System.out.println("插入成功Id为" + user.getUserId());
    }


    @Test
    public void Delete() {
        Assert.assertTrue(userMapper.deleteById("48ed89621002475bb027df1cf2bee9f1") > 0);
        Assert.assertTrue(userMapper.delete(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername, "阿斯蒂芬123")) > 0);
    }

    @Test
    public void Update() {
        Assert.assertTrue(userMapper.updateById(new TUser().setUserId("1").setUsername("asdf2").setPhoneNum(123123)) > 0);
        Assert.assertTrue(userMapper.update(new TUser(),
                new UpdateWrapper<TUser>().lambda().set(TUser::getPhoneNum, 456).eq(TUser::getUserId, 2)
        ) > 0);
    }

    @Test
    public void Select() {
        Assert.assertEquals("asdf1", userMapper.selectById("1").getUsername());
        TUser user = userMapper.selectOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUserId, 2));
        logger.info(JSONObject.toJSONString(user));
        Assert.assertEquals("yizhiwazi", user.getUsername());
        Assert.assertEquals(Integer.valueOf(456), user.getPhoneNum());

    }

    @Test
    public void Select1() {
        Page<TUser> tUserPage = new Page<>(1,2);
        IPage<TUser> tUserIPage = userMapper.selectPage(tUserPage,null);
        logger.info(String.valueOf(Collections.unmodifiableCollection(tUserIPage.getRecords())));
    }


    @Test
    public void testLogicDel(){
        logger.info(String.valueOf(userMapper.selectList(new QueryWrapper<>())));
        userMapper.deleteById("2");
    }

    @Test
    public void testSelect1(){
        TUser user = new TUser();
        user.setUsername("asdf4").setPassword("psw123");
//        logger.info(JSONObject.toJSONString(userMapper.selectAll()));
        TUser userForBase = userMapper.selectOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername, user.getUsername()).eq(TUser::getPassword,user.getPassword()));
        logger.info(JSONObject.toJSONString(userForBase));

    }
}
