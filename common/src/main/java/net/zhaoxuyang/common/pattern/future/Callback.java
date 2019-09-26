package net.zhaoxuyang.common.pattern.future;

/**
 *
 * @author zhaoxuyang
 * @param <F> 函数
 */
@FunctionalInterface
public interface Callback<F> {
    void call(F t);
}
