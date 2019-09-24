package net.zhaoxuyang.common.current.future;

/**
 *
 * @author zhaoxuyang
 * @param <IN> 输入
 * @param <OUT> 输出
 */
public interface FutureService<IN,OUT> {
    Future<?> submit(Runnable task);
    Future<OUT> submit(Task<IN,OUT> task,IN input);
    static<T,R>FutureService<T,R> newService(){
        return new FutureServiceImpl();
    }
    Future<OUT> submit(Task<IN,OUT> task,IN input,Callback<OUT> callback);
}
