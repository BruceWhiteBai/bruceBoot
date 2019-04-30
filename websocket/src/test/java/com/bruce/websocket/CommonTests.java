package com.bruce.websocket;

import org.junit.Test;


public class CommonTests {

    @Test
    public void contextLoads() {
        testSwitch(4);

    }


    private void testSwitch(int i){
        switch(i){
            case 1:
                System.out.println("i = [" + i + "--paid 分配"+"]");
                break;
            case 2:
            case 3:
                System.out.println("i = [" + i + "--取消 分配"+"]");
            case 4:
            case 5:
                System.out.println("i = [" + i + "--状态变更操作"+"]");
                break;
            default:
                System.out.println("i = [" + i + "]");

        }
    }
}

