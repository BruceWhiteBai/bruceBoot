package com.bruce.multipledatasource.dao.mapper;

import com.bruce.multipledatasource.dao.domain.UserLongin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataSourceMapper {
    @ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM user_login WHERE  id = #{id}")
    List<UserLongin> selectById(Long id);

    @ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM user_login")
    List<UserLongin> selectAllDs1();

    @ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM user_login")
    List<UserLongin> selectAllDs2();

    List<UserLongin> selectAllDs2a();

    @Insert("insert into user_login ('user_name','pass_word') values (#{userName},#{password})")
    int insertOne(UserLongin userLongin);
}
