package refactor.observer;

/**
 * 重构观察者模式
 */
public class Refactor {
    public static void main(String[] args) {
        JavaSubject subject = new JavaSubject();
        subject.register(new Student());
        subject.register(new Teacher());
        subject.register(new Admin());
        subject.notify("我发布了一份Java教学资料，大家可以下载学习");

        /**
         * 使用Lambda消除僵化代码
         */
        System.out.println("重构：");
        subject.register((text -> {
            if(text != null && text.contains("资料")){
                System.out.println("与资料相关+1");
            }
        }));
        subject.notify("我发布了一份Java教学资料，大家可以下载学习");
    }
}
