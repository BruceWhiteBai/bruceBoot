package com.bruce.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by BruceWhite on 2018/11/17.
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Value("${threadpool.corePoolSize}")
    private int corePoolSize  ;
    @Value("${threadpool.maxPoolSize}")
    private int maxPoolSize   ;
    @Value("${threadpool.queueCapacity}")
    private int queueCapacity ;
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
