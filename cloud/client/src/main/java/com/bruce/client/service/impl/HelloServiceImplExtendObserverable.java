package com.bruce.client.service.impl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observables.AsyncOnSubscribe;

public class HelloServiceImplExtendObserverable extends HystrixObservableCommand<String> {

    RestTemplate restTemplate;

    protected HelloServiceImplExtendObserverable(HystrixCommandGroupKey group,RestTemplate restTemplate) {
        super(group);
        this.restTemplate = restTemplate;
    }

    protected HelloServiceImplExtendObserverable(Setter setter,RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }


    @Override
    protected Observable<String> construct() {

        //todo 异步实现
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String result = restTemplate.getForEntity("http://PROVIDER/index", String.class).getBody();
                subscriber.onNext(result);
                subscriber.onCompleted();
            }
        });
    }
}
