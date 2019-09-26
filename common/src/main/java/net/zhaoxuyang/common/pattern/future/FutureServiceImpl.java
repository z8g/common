package net.zhaoxuyang.common.pattern.future;

import java.util.concurrent.atomic.AtomicInteger;

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";
    private final AtomicInteger nextCounter = new AtomicInteger(0);
    private String getNextName(){
        return FUTURE_THREAD_PREFIX+nextCounter.getAndIncrement();
    }
    
    @Override
    public Future<?> submit(Runnable task) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
            task.run();
            future.finish(null);
        },getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
      final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT output = task.get(input);
            future.finish(output);
        },getNextName()).start();
        return future;  
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT output = task.get(input);
            future.finish(output);
            if(null != callback){
                callback.call(output);
            }
        },getNextName()).start();
        return future;
    }
    
}
