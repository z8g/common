package net.zhaoxuyang.common.nio.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 服务端的处理逻辑
 * 所有的Netty服务器都需要以下两部分：
 * - 至少一个 ChannelHandler ，业务逻辑
 * - 引导程序——配置服务器的启动代码，监听端口
 * @author hadoop
 */
@Sharable//标示一个ChannelHandler可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter{
    
    /**
     * 将接收到的消息写给发送者，而不冲刷出站消息
     * @param ctx
     * @param msg 
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
    }
    
    /**
     * 将 pending message 冲刷到远程节点，并且关闭Channel
     * @param ctx 
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        System.out.println(cause);
        ctx.close();
    }
}
