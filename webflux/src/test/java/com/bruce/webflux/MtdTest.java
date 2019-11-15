package com.bruce.webflux;

import org.junit.Test;

public class MtdTest {

    private void testOut(){
        System.out.println("1---------------");
        return;
    }

    private void testException(){
        try{
            System.out.println(1/0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test01(){
        System.out.println("0----------------");
        testOut();
        System.out.println("2----------------");

    }

    @Test
    public void test02(){
        System.out.println("0----------------");
        testException();
        System.out.println("2----------------");

    }

}
