package com.bruce.webflux.jvm;

import org.junit.Test;

public class SafepointTest {

    // time java SafepointTestp
// 你还可以使用如下几个选项
    // -XX:+PrintGC
// -XX:+PrintGCApplicationStoppedTime
// -XX:+PrintSafepointStatistics
// -XX:+UseCountedLoopSafepoints
    static double sum = 0;

    public static void foo() {
        for (int i = 0; i < 0x77777777; i++) {
            sum += Math.sqrt(i);
        }
    }

    public static void bar() {
        for (int i = 0; i < 50_000_000; i++) {
            new Object().hashCode();
        }
    }

    @Test
    public void test01() {
        new Thread(SafepointTest::foo).start();
        new Thread(SafepointTest::bar).start();
    }
}


// Run with java -XX:+PrintGC -Xmn100M -XX:PretenureSizeThreshold=10000 LifetimeTest
// You may also try with -XX:+PrintHeapAtGC，-XX:-UsePSAdaptiveSurvivorSizePolicy or -XX:SurvivorRatio=N
 class LifetimeTest {
    private static final int K = 1024;
    private static final int M = K * K;
    private static final int G = K * M;

    private static final int ALIVE_OBJECT_SIZE = 32 * M;

    public static void main(String[] args) {
        int length = ALIVE_OBJECT_SIZE / 64;
        ObjectOf64Bytes[] array = new ObjectOf64Bytes[length];
        for (long i = 0; i < G; i++) {
            array[(int) (i % length)] = new ObjectOf64Bytes();
        }
    }
}

class ObjectOf64Bytes {
    long placeholder0;
    long placeholder1;
    long placeholder2;
    long placeholder3;
    long placeholder4;
    long placeholder5;
}
