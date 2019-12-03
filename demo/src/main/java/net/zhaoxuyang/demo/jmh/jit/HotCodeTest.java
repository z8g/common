package net.zhaoxuyang.demo.jmh.jit;

public class HotCodeTest {

    public static void main(String[] args) {
        HotCodeTest test = new HotCodeTest();
        for (int i = 0; i < 20000; i++) {
            test.echo();
        }
    }

    public void echo() {
        String msg = getMsg();
        String output = "Hello" + msg;
    }

    private synchronized String getMsg() {
        return "World " + '!';
    }
}


