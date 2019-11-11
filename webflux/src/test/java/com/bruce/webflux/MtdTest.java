package com.bruce.webflux;

import org.junit.Test;

public class MtdTest {

    private void testOut(){
        System.out.println("1---------------");
        return;
    }

    @Test
    public void test01(){
        System.out.println("0----------------");
        testOut();
        System.out.println("2----------------");

    }

}
