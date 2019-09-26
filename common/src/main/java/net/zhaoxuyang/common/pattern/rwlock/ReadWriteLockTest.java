package net.zhaoxuyang.common.pattern.rwlock;

import static java.lang.Thread.currentThread;

/**
 *
 * @author zhaoxuyang
 */
public class ReadWriteLockTest {
    private final static String TEXT = "ReadWriteLockTest";
    
    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);
        
        //写
        for(int i = 0; i< 2;i++){
            new Thread(()->{
                for(int index = 0;index<TEXT.length();index++){
                    try{
                        char c = TEXT.charAt(index);
                        shareData.write(index,c);
                        System.out.println(currentThread()+" write " + c);
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }
        
        //读
        for(int i = 0; i< 10;i++){
            new Thread(()->{
                while(true){
                     try{
                        System.out.println(currentThread()+" read " + new String(shareData.read()));
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }
    }
}
