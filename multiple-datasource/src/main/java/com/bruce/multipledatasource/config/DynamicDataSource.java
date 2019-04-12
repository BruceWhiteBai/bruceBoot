package com.bruce.multipledatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
* @file DynamicDataSource.java
* @brief
* @author bzj
* @date 2019/4/9
 * AbstractRoutingDataSource(每执行一次数据库，动态获取DataSource)
*/
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
