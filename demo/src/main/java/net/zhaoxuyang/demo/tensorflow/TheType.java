package net.zhaoxuyang.demo.tensorflow;

/**
 *
 * @author zhaoxuyang
 * @param <T>
 */
public class TheType<T> {
    public static void main(String[] args) {
        TheType<String> theType = new TheType<>();
        theType.type("a");
        /*输出
        java.lang.Object
        java.lang.String
        */
    }
    public void type(T data){
        System.out.println(data.getClass().getGenericSuperclass().getTypeName());//父类类型
        System.out.println(data.getClass().getName());//本身类型
    }
    public void show(T o){
        if(o instanceof Boolean){
            System.out.println("Boolean");
        }
    }
    
}
