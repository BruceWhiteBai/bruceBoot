package com.bruce.repo.userRepo;

import com.bruce.entity.dto.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserRepository extends Mapper<User> {
}