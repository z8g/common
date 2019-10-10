package net.zhaoxuyang.demo.netty.fileupload;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 服务端的处理逻辑 所有的Netty服务器都需要以下两部分： - 至少一个 ChannelHandler ，业务逻辑 -
 * 引导程序——配置服务器的启动代码，监听端口
 *
 * @author hadoop
 */
@Sharable//标示一个ChannelHandler可以被多个Channel安全地共享
public class FileServerHandler extends ChannelInboundHandlerAdapter {

    private final File file;
    private final FileOutputStream fos;
    private long readedSize = 0;

    public FileServerHandler() throws FileNotFoundException {
        this.file = new File("/home/hadoop/Desktop/" + System.nanoTime());
        fos = new FileOutputStream(this.file);
    }

    /**
     * 将接收到的消息写给发送者，而不冲刷出站消息
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        ByteBuf buf = (ByteBuf) msg;

        readedSize += buf.readableBytes();

        try {
            if (buf.isReadable()) {
                byte[] bytes = new byte[buf.readableBytes()];
                buf.readBytes(bytes);
                fos.write(bytes);
            }
//            if (readedSize >= 1024 * 1024 * 1024 * 100) {
//                ctx.pipeline().remove(this);
//                fos.close();
//            }
        } catch (IOException e) {
            System.out.println(e);
        }

        buf.release();
    }

    /**
     * 将 pending message 冲刷到远程节点，并且关闭Channel
     *
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(cause);
        ctx.close();
    }
}
