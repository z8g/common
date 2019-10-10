package net.zhaoxuyang.concurrent.utilities.e4;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author zhaoxuyang
 */
public class TimerDemo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("alarm going off");
                System.exit(0);
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
    
}
