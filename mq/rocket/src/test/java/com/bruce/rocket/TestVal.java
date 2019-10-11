package com.bruce.rocket;

public class TestVal {

    public int a;
}

class Testa {
    public static void main(String[] args) {
        TestVal testVal = new TestVal();
        testVal.a = 1;
        System.out.println("args = [" + testVal.a + "]");

    }
}
