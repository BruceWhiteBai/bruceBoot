package com.bruce.jwt;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bruce.jwt.base.entity.TUser;
import com.bruce.jwt.base.mapper.TUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class ArCrudTest extends JwtApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ArCrudTest.class);



    @Test
    public void Insert() {
        TUser user = new TUser();
        user.setUsername("阿斯蒂芬").setPhoneNum(123).setDeleteFlag(0).setPassword("psw123");
        user.insert();
        user.insertOrUpdate();
    }


    @Test
    public void Delete() {
        TUser user = new TUser();
        user.setUserId("6");
        user.deleteById();
        user.deleteById("5");
        user.delete(new QueryWrapper<TUser>().lambda().eq(TUser::getUserId,"4"));
    }

    @Test
    public void Update() {
        TUser user = new TUser();
        user.setUserId("1");
        user.setUsername("asdf3");
        user.updateById();
        user.update(new UpdateWrapper<TUser>().lambda().eq(TUser::getUserId,2));

    }

    @Test
    public void Select() {
        TUser user = new TUser();
        user.setUserId("1");
        //setId
        user.selectById();
        //直接键入 Id
        user.selectById(2);
        //条件
        user.selectCount(new QueryWrapper<TUser>().lambda().eq(TUser::getUserId, 1));
        //查询所有
        user.selectAll();
        //查询总记录数
        user.selectList(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername, "asdf3"));
        //查询一个
        user.selectOne(new QueryWrapper());
        //分页
        user.selectPage(new Page<>(1, 2), new QueryWrapper<>());


    }
}
