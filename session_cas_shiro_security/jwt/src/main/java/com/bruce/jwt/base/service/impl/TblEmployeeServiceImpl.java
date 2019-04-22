package com.bruce.jwt.base.service.impl;

import com.bruce.jwt.base.entity.TblEmployee;
import com.bruce.jwt.base.mapper.TblEmployeeMapper;
import com.bruce.jwt.base.service.ITblEmployeeService;
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
public class TblEmployeeServiceImpl extends ServiceImpl<TblEmployeeMapper, TblEmployee> implements ITblEmployeeService {

}
