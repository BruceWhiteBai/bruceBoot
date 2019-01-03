package com.bruce.grpc.server;

import com.bruce.grpc.lib.device.DeviceFixServiceGrpc;
import com.bruce.grpc.lib.device.booleanReply;
import com.bruce.grpc.lib.device.deviceFix;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Slf4j
@GrpcService(DeviceFixServiceGrpc.class)
public class deviceGrpcService extends DeviceFixServiceGrpc.DeviceFixServiceImplBase {

//    @Autowired
//    private IDevicesFixService deviceService;

    @Override
    public void insertDeviceFix(deviceFix request, StreamObserver<booleanReply> responseObserver) {
        /*DevicesFix deviceFix = DevicesFix.builder().id(request.getId())
                .serialNum(request.getSerialNum())
                .address(request.getAddress())
                .createtime(new Date())
                .updatetime(new Date())
                .userNum(request.getUserNum())
                .status(request.getStatus())
                .type(request.getType())
                .build();*/

        deviceFix deviceFix = com.bruce.grpc.lib.device.deviceFix.newBuilder()
                .setId(request.getId())
                .setSerialNum(request.getSerialNum())
                .setAddress(request.getAddress())
                .setCreatetime(new Date().toString())
                .setUpdatetime(new Date().toString())
                .setUserNum(request.getUserNum())
                .setStatus(request.getStatus())
                .setType(request.getType())
                .build();
        log.info(deviceFix.toString());
//        boolean replyTag = deviceService.insert(deviceFix);
        boolean replyTag = true;
        booleanReply reply = booleanReply.newBuilder().setReply(replyTag).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}