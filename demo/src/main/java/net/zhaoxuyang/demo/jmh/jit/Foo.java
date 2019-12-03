package net.zhaoxuyang.demo.jmh.jit;

/**
 *
 * @author zhaoxuyang
 */
public class Foo {
    
    public static void main(String[] args){
        Foo foo = new Bar();
        foo.echo();
    }

    int echo(int x) {
        return x + 1;
    }

    int echo() {
        return 0;
    }
}

class Bar extends Foo {

    int say(int x) {
        return x + 2;
    }
}
