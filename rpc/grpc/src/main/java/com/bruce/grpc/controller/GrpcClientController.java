package com.bruce.grpc.controller;


import com.bruce.grpc.client.DeviceGrpcServiceAPP;
import com.bruce.grpc.client.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name) {
        return grpcClientService.sendMessage(name);
    }
    @Autowired
    private DeviceGrpcServiceAPP deviceGrpcServiceAPP;


    @RequestMapping("/testInsertDeviceFix")
    public String printMessage3(@RequestParam(defaultValue = "Hmemb") String name) {
        return deviceGrpcServiceAPP.insertDeviceFix();
    }

}
