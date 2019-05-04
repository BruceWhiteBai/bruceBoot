package com.bruce.netty.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
        }
        //设置端口值（如果端口参数的格式不正确，则抛出一个NumberFormatException）
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //1.创建eventloopgroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //2.创建serverbootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)//3.指定所使用的NIO传输channel
                    .localAddress(new InetSocketAddress(port))//4.使用指定的端口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>(){//5.添加一个EchoServer-handler到子channel的channelpipeline
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(serverHandler);//EchoServerHandler 被标注为@Shareable，所以我们可以总是使用同样的实例
                        }
                    });
            //异步的绑定到服务器，调用同步方法直到绑定完成
            ChannelFuture f = b.bind().sync();
            //获取channel的closeFuture，并且阻塞当前线程直到完成
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭eventloopgroup，释放所有资源
            group.shutdownGracefully().sync();
        }

    }
}
