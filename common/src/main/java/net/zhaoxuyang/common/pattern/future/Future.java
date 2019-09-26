package net.zhaoxuyang.common.pattern.future;

/**
 *
 * @author zhaoxuyang
 * @param <R> 返回值
 */
public interface Future <R>{
    R get() throws InterruptedException;
    boolean done();
}
