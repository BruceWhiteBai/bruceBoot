package com.bruce.multipledatasource.service.impl;

import com.bruce.multipledatasource.config.datasource.TargetDataSource;
import com.bruce.multipledatasource.dao.domain.UserLongin;
import com.bruce.multipledatasource.dao.mapper.DataSourceMapper;
import com.bruce.multipledatasource.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceDao;

    @Override
    public List<UserLongin> selectById(Long id) {
        List<UserLongin> list = dataSourceDao.selectById(id);
        return list;
    }

    @Override
    @TargetDataSource(name = "ds1")
    public List<UserLongin> selectAllDs1() {
        List<UserLongin> list = dataSourceDao.selectAllDs1();
        return list;
    }

    @Override
    @TargetDataSource(name = "ds2")
    public List<UserLongin> selectAllDs2() {
        List<UserLongin> list = dataSourceDao.selectAllDs2();
        return list;
    }

    @Override
    @Async("asyncServiceExecutor")
    public List<UserLongin> selectAllDs2a() {
        List<UserLongin> list = dataSourceDao.selectAllDs2a();
        return list;
    }
}
