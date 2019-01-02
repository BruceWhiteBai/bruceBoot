package com.bruce.thrift.server.impl;

import com.bruce.thrift.server.Hello;
import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {


    @Override
    public String helloString(String param) throws TException {
        return "hello: " + param;
    }
}
