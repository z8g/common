package net.zhaoxuyang.concurrent.demo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer示例-延时调度
 * @author zhaoxuyang
 */
public class TimerDemoDelayed{
    public static void main(String[] args) {
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.exit(0);
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
    
}
