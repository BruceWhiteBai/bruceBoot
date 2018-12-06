package com.bruce.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
* @file ZookeeperDistributedBarrierMain.java
* @CopyRight (C) http://www.sunlands.com/
* @brief
* @author bzj
* @email baizhoujun@sunlands.com
* @date 2018/12/6
*/

/**
 * 分布式栅栏DistributedBarrier用于在分布式环境下，阻塞指定数量线程（不一定在同一台机器），当这些线程达到某一点时，
 *
 * 再放开阻塞。和多线程编程中的CyclicBarrier类似。
 *
 * barrier.waitOnBarrier()方法用于阻塞，当所有线程都调用了该方法后，阻塞解除。
 */
public class ZookeeperDistributedBarrierMain {

    public static void main(String[] args) throws Exception {
        //创建zookeeper客户端
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.99.100:2181", new ExponentialBackoffRetry(1000, 3));
        client.start();

        //指定锁路径
        String lockPath = "/zkLockRoot/lock_barrier";
        //创建分布式栅栏
        DistributedBarrier distributedBarrier = new DistributedBarrier(client, lockPath);
        distributedBarrier.setBarrier();

        //生成线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Consumer<DistributedBarrier> consumer = (DistributedBarrier barrier)->{
            try{
                Callable<Boolean> call = () -> {
                    try{
                        System.out.println(Thread.currentThread() + "  rearch barrier, waiting");
                        barrier.waitOnBarrier();
                        System.out.println(Thread.currentThread() + "  do next");
                    }catch (Exception e){
                    }
                    return true;
                };
                //5个并发线程
                for (int i = 0; i < 5; i++) {
                    executor.submit(call);
                }
            }catch (Exception e){
            }
        };

        //栅栏测试(多个线程栅栏测试)
        System.out.println("5个并发线程,栅栏测试");
        consumer.accept(distributedBarrier);

        distributedBarrier.removeBarrier();
        executor.shutdown();
        client.close();
    }

}
