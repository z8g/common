package net.zhaoxuyang.common.current.utilities.e4;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author zhaoxuyang
 */
public class TimerDemo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
    }
    
}
