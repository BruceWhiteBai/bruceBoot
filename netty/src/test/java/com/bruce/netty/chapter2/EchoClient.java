package com.bruce.netty.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {

    private final String host;
    private final int port;
    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        ///创建 Bootstrap
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group) ///指定 EventLoopGroup 以处理客户端事件；需要适用于 NIO 的实现
                    .channel(NioSocketChannel.class)//适用于 NIO 传输的 Channel 类型
                    .remoteAddress(new InetSocketAddress(host, port))//设置服务器的InetSocketAddress
                    .handler(new ChannelInitializer<SocketChannel>() {
//              在创建Channel时，向ChannelPipeline中添加一个 EchoClientHandler 实例
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ///连接到远程节点， 阻塞等待直到连接完成
            ChannelFuture f = b.connect().sync();
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture)
                        throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("Connection established");
                    } else {
                        System.err.println("Connection attempt failed");
                        channelFuture.cause().printStackTrace();
                    }
                }
            });
            //阻塞， 直到Channel 关闭
            f.channel().closeFuture().sync();
        } finally {
            //关闭线程池并且释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println(
                    "Usage: " + EchoClient.class.getSimpleName() +
                            " <host> <port>");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EchoClient(host, port).start();
    }

}
