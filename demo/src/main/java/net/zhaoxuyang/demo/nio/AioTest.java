package net.zhaoxuyang.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AioTest {

    /**
     * 异步I/O 将来式
     */
    public static void nioFuture() {
        //【1】 异步I/O 将来式
        // AsynchronousFileChannel会关联线程池，它的任务是接收I/O处理事件，
        // 并分发给负责处理通道中I/O操作结果的结果处理器
        try {
            Path bigFilePath = Paths.get("F:\\收藏\\dump.sql");//93464KB
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(bigFilePath);
            ByteBuffer buffer = ByteBuffer.allocate(100_000);//读取100000字节

            Future<Integer> result = channel.read(buffer, 0);//异步IO：将来式
            while (!result.isDone()) {
                System.out.println("在没有结束前做点别的事……");//在没有结束前做点别的事
            }
            Integer bytesRead = result.get();
            System.out.println(bytesRead);

        } catch (IOException | InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }

    /**
     *
     */
    public static void nioCallback() {
        //【2】 异步I/O 回调式
        try {
            Path bigFilePath = Paths.get("F:\\收藏\\dump.sql");//93464KB
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(bigFilePath);
            ByteBuffer buffer = ByteBuffer.allocate(100_000);//读取100000字节

            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("完成后会执行这个方法");
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

            });
        } catch (IOException ex) {
            Logger.getLogger(AioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        nioFuture();
        nioCallback();
    }
}
