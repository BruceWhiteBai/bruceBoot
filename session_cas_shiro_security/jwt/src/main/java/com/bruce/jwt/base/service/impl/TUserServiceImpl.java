package com.bruce.jwt.base.service.impl;

import com.bruce.jwt.base.entity.TUser;
import com.bruce.jwt.base.mapper.TUserMapper;
import com.bruce.jwt.base.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bruce
 * @since 2019-04-22
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
