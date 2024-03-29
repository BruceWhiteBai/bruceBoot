package com.bruce.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
* @file InterProcessLock.java
* @CopyRight (C)
* @brief
* @author bzj
* @email
* @date 2018/12/6
*/

/**
 * 通过InterProcessMutex创建锁，然后使用acquire()获取锁，使用release()释放锁
 * 只有等前一个获取锁的线程释放锁后，下一个线程才能获取锁
 */
public class InterProcessLock {

    public static void main(String[] args) {
        //创建zookeeper客户端
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.99.100:2181", new ExponentialBackoffRetry(1000, 3));
        client.start();

        //指定锁路径
        String lockPath = "/zkLockRoot/lock_1";
        //创建锁，为可重入锁，即是获锁后，还可以再次获取，本例以此为例
        InterProcessMutex lock = new InterProcessMutex(client, lockPath);
//        //创建锁，为不可重入锁，即是获锁后，不可以再次获取，这里不作例子，使用和重入锁类似
//        InterProcessSemaphoreMutex lock = new InterProcessSemaphoreMutex(client, lockPath);

        ExecutorService executor = Executors.newCachedThreadPool();
        Consumer<InterProcessMutex> consumer = (InterProcessMutex typeLock)->{
            try{
                List<Callable<String>> callList = new ArrayList<>();
                Callable<String> call = () -> {
                    try{
                        //获取锁
                        typeLock.acquire();
                        System.out.println(Thread.currentThread() + "  acquire read lock");
                    }catch (Exception e){
                    }finally {
                        //释放锁
                        typeLock.release();
                        System.out.println(Thread.currentThread() + "  release read lock");
                    }
                    return "true";
                };
                //5个并发线程
                for (int i = 0; i < 5; i++) {
                    callList.add(call);
                }
                List<Future<String>> futures = executor.invokeAll(callList);
            }catch (Exception e){

            }
        };

        //分布式锁测试
        consumer.accept(lock);

        executor.shutdown();
    }
}
