package net.zhaoxuyang.pattern.future;

/**
 *
 * @author zhaoxuyang
 * @param <IN> 输入
 * @param <OUT> 输出
 */
@FunctionalInterface
public interface Task<IN, OUT> {
    OUT get(IN input);
}
