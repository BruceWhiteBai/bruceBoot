package com.bruce.webflux;

public class EscapeAnalysis {

    public static void main(String[] args) {
        AA a = new AA();
        a.instancePassPointerEscape();
    }
}

class AA {
    public static BB b;
    public void globalVariablePointerEscape() { // 给全局变量赋值，发生逃逸
        b = new BB();
    }

    public BB methodPointerEscape() { // 方法返回值，发生逃逸
        return new BB();
    }

    public void instancePassPointerEscape() {
        methodPointerEscape().printClassName(this); // 实例引用传递，发生逃逸
    }
}

class BB {
    public void printClassName(AA aa) {
        System.out.println(aa.getClass().getName());
    }
}