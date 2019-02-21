package com.bruce.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebfluxApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void test() {
        func(2,0);
    }

    public void func(int r,int c){
        r--;
        c++;
        if(r>0 && c<3){
            func(r,c);
        } else {
            System.out.println("r = [" + r + "], c = [" + c + "]");
        }
    }

    @Test
    public void test1(){
        B b = new B();
    }
}

class A{
    static{
        System.out.println("----S-A---");
    }
    public A() {
        System.out.println("-----A-----");

    }
}

class B extends A{
    static{
        System.out.println("----S-B---");
    }
    public B() {
        System.out.println("----B---");
    }
}


