package net.zhaoxuyang.common.pattern.future;

public class FutureTask<T> implements Future {

    private T result;
    private boolean isDone = false;
    private final Object LOCK = new Object();
    
    @Override
    public Object get() throws InterruptedException {
        synchronized (LOCK){
            while(!isDone){
                LOCK.wait();
            }
            return result;
        }
    }

    @Override
    public boolean done() {
       return isDone;
    }
    
    protected void finish(T result){
         synchronized (LOCK){
            if(isDone){
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

}
