package com.bruce.jwt.base.mapper;

import com.bruce.jwt.base.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bruce
 * @since 2019-04-22
 */
public interface TUserMapper extends BaseMapper<TUser> {

    @Select({"select * from t_user"})
    List<TUser> selectAll();

}
