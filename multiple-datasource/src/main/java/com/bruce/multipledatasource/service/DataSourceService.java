package com.bruce.multipledatasource.service;



import com.bruce.multipledatasource.config.datasource.TargetDataSource;
import com.bruce.multipledatasource.dao.domain.UserLongin;

import java.util.List;

public interface DataSourceService {

    List<UserLongin> selectById(Long id);

    List<UserLongin> selectAllDs1();

    List<UserLongin> selectAllDs2();

    @TargetDataSource(name = "ds2")
    List<UserLongin> selectAllDs2a();
}
