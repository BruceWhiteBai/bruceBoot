package com.bruce.client.service.impl;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

public class HelloServiceImplExtend extends HystrixCommand<String> {

    RestTemplate restTemplate;


    @Override
    protected String run() throws Exception {
        return restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
    }

    public HelloServiceImplExtend(RestTemplate restTemplate) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandGroupKey"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));

        this.restTemplate = restTemplate;
    }



    @Override
    protected String getFallback() {
        //xxx 自定义失败回调处理
        return super.getFallback();
    }

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

    //todo 设置缓存1 通过重写 getCacheKey ()方法来开启请求缓存,原有的是默认返回null,所以要开启缓存
    //todo 设置换成2 使用注解开启缓存 @CacheResult   @CacheRemove移除缓存 @CacheRemove 注解的 commandKey 属性是必须要指定的， 它用来指明需要使用请求缓存的请求命令， 因为只有通过该属性的配置， Hystrix 才能找到正确的请求命令缓存位置。
    @Override
    protected String getCacheKey() {
        return "";
    }

    public static void flushCache(Long id) {
        //刷新缓存，根据id进行清理
        HystrixRequestCache.getInstance(GETTER_KEY,HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }


}
