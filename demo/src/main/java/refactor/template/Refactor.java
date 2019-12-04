package refactor.template;

import java.util.function.Consumer;

/**
 * 重构模板方法模式
 */
public class Refactor {
    public void refactorMethod(int id, Consumer<String> consumer){
        String helloStr = "id: " + id;
        consumer.accept(helloStr);
    }
    public static void main(String[] args) {
        new Refactor().refactorMethod(12, s-> {
            System.out.println("Hello "+s);
        });
    }
}
