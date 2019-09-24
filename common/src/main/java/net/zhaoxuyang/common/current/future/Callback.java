package net.zhaoxuyang.common.current.future;

/**
 *
 * @author zhaoxuyang
 * @param <F> 函数
 */
@FunctionalInterface
public interface Callback<F> {
    void call(F t);
}
