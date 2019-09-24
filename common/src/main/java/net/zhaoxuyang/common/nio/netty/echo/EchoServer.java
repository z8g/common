package net.zhaoxuyang.common.nio.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;

/**
 * 服务端
 * @author hadoop
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        int port = 8080;
        new EchoServer(port).start();
    }

    public void start()  {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap boot = new ServerBootstrap();
            
            boot.group(group) //创建EventLoopGroup
                    
                    // 指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    
                    //指定套接字端口
                    .localAddress(new InetSocketAddress(port))
                    
                    //添加一个Handler到子Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture future = boot.bind().sync();//异步地绑定服务器，阻塞直到绑定完成
            future.channel().closeFuture().sync();//获取Channel的CloseFuture，并阻塞当前线程直到结束
            
        } catch (InterruptedException e) {
            System.out.println(e);
        }finally{
            try {
                group.shutdownGracefully().sync();//释放所有资源
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } 
    }
}
