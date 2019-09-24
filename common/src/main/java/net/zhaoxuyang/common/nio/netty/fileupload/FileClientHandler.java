package net.zhaoxuyang.common.nio.netty.fileupload;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 客户端的处理逻辑
 *
 * 客户端将会： （1） 连接到服务器 （2） 发送一个或者多个消息 （3） 对于每条消息，等待并接收从服务器发回的相同的消息 （4） 关闭连接
 *
 * @author hadoop
 */
@Sharable
public class FileClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 需要实现的方法，记录已收到的消息的转储
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("客户端收到：" + msg.toString(CharsetUtil.UTF_8));
    }

    /**
     * 当被通知Channel是活跃的时候，发送一条消息
     *
     * @param ctx
     * @throws java.io.FileNotFoundException
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws FileNotFoundException {
        File file = new File("/home/hadoop/Desktop/SsmExample/dist/SsmExample.war");
        FileInputStream in = new FileInputStream(file);
        FileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length());
        ctx.writeAndFlush(region).addListener((ChannelFuture future) -> {
            if (!future.isSuccess()) {
                Throwable cause = future.cause();
                System.out.println(cause);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(cause);
        ctx.close();
    }

}
