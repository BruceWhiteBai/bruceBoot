package com.bruce.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReflect {

    public static void target(int i) {
        //new Exception("#" + i).printStackTrace();
    }

    @Test
    public void test01() throws Exception {
        Class<?> klass = Class.forName("com.bruce.webflux.TestReflect");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }

    @Test
    public void test02() throws Exception {
        System.out.println("1---"+System.getProperty("sun.reflect.noInflation"));
        System.out.println("2---"+System.getProperty("sun.reflect.inflationThreshold"));
        Class<?> klass = Class.forName("com.bruce.webflux.TestReflect");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20 ; i++) {
            method.invoke(null, i);
        }
    }

    @Test
    public void test03() throws Exception {
        System.out.println("1---"+System.getProperty("sun.reflect.noInflation"));
        System.out.println("2---"+System.getProperty("sun.reflect.inflationThreshold"));
        Class<?> klass = Class.forName("com.bruce.webflux.TestReflect");
        Method method = klass.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
    }


    @Test
    public void test04() throws Exception {
        System.out.println("1---"+System.getProperty("sun.reflect.noInflation"));
        System.out.println("2---"+System.getProperty("sun.reflect.inflationThreshold"));
        Class<?> klass = Class.forName("com.bruce.webflux.TestReflect");
        Method method = klass.getMethod("target", int.class);
        // 在循环外构造参数数组
        Object[] arg = new Object[1];
        arg[0] = 128;
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, arg);
        }
    }

}

