package offer;

/**
 * 实现Singleton模式
 *
 * @author zhaoxuyang
 */
public class Exp02 {

    private Exp02() {
    }

    private static class S {
        static Exp02 instance = new Exp02();
    }

    public static Exp02 newInstance() {
        return S.instance;
    }
}
