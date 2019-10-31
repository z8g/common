package net.zhaoxuyang.concurrent.demo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer示例-定时调度
 * @author zhaoxuyang
 */
public class TimerDemoTiming {
    public static void main(String[] args) {
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
    }
    
}
