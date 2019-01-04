package com.bruce.ice.runtest;

import com.bruce.ice.Demo.HelloPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

public class Client {

    public static void main(String[] args) {
        int status = 0;
        // Communicator实例
        Communicator ic = null;
        try {
            // 调用Ice.Util.Initialize()初始化Ice run time
            ic = Util.initialize(args);

            // 获取远地打印机的代理
            ObjectPrx base = ic.stringToProxy("SimplePrinter:default -p 1000");

            // 将上面的代理向下转换成一个Printer接口的代理
            // todo .checkedCast(base);待验证
            HelloPrx helloWorld = HelloPrx.uncheckedCast(base);

            // 如果转换成功
            if (helloWorld == null) {
                throw new Error("Invalid proxy");
            }

            // 调用这个代理，将字符串传给它
            System.out.println("args = [" + helloWorld.SayHello("bar") + "]");

        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
        System.exit(status);
    }
}
