package net.zhaoxuyang.concurrent.utilities.e1;

/**
 * 线程示例程序 - 忙循环
 * @author zhaoxuyang
 */
public class ThreadDemo2 {
    public static void main(String[] args){
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            int count = 0;
            while(!Thread.interrupted()){
                System.out.println(name + ": " + count++);
            }
        };
        
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        
        /**
         * 忙循环不是一个好主意
         */
        while(true){
            double n = Math.random();
            if(n>=0.49999999 && n <=0.50000001){
                break;
            }
        }
        t1.interrupt();
        t2.interrupt();
    }
}
