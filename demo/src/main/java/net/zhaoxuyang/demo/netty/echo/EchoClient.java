package net.zhaoxuyang.demo.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;

/**
 * 客户端
 *
 * @author hadoop
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap boot = new Bootstrap();
            boot.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            ChannelFuture future = boot.connect().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 8080;
        new EchoClient(host,port).start();
    }

}
