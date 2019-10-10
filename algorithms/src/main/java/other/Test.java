package other;

/**
 *
 * @author zhaoxuyang
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.test());
    }

    public String test() {
        try {
            System.out.println(B.hello);
            System.out.println(B.word);
            return m1();
        } finally {
            System.out.println("2");
        }
    }

    private String m1() {
        System.out.println("4");
        return "5";
    }
}

class A {

    final static String hello = "hello";

    static {
        System.out.println("A");
    }
}

class B extends A {

    final static String word = "6";

    static {
        System.out.println("B");
    }
}

