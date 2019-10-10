package net.zhaoxuyang.demo.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 客户端的处理逻辑
 *
 * 客户端将会： （1） 连接到服务器 （2） 发送一个或者多个消息 （3） 对于每条消息，等待并接收从服务器发回的相同的消息 （4） 关闭连接
 *
 * @author hadoop
 */
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

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
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty 连接", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(cause);
        ctx.close();
    }

}
