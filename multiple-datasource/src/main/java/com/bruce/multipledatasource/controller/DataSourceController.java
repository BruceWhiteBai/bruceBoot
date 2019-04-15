package com.bruce.multipledatasource.controller;


import com.bruce.multipledatasource.dao.domain.UserLongin;
import com.bruce.multipledatasource.service.DataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;


@RestController
public class DataSourceController {

    private Logger logger = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping("/default/{id}")
    public List<UserLongin> useDefaultDataSource(@PathVariable("id") Long id) {
        logger.info("使用默认数据源");
        List<UserLongin> list = dataSourceService.selectById(id);
        return list;
    }

    @GetMapping("/ds1")
    public List<UserLongin> useDS1DataSource() {
        logger.info("使用ds1数据源");
        List<UserLongin> list = dataSourceService.selectAllDs1();
        return list;
    }

    @GetMapping("/ds2")
    public List<UserLongin> useDS2DataSource() {
        logger.info("使用ds2数据源");
        StringBuilder stringBuilder = new StringBuilder();
        List<UserLongin> list = dataSourceService.selectAllDs2();
        return list;
    }

    @GetMapping("/ds2a")
    public List<UserLongin> useDS2aDataSource() {
        logger.info("使用ds2数据源a");
        StringBuilder stringBuilder = new StringBuilder();
        List<UserLongin> list = dataSourceService.selectAllDs2a();
        return list;
    }
}
