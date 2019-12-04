package parallel;

/**
 * @author zhaoxuyang
 */
public class Setting {
    public static void main(String[] args) {

        /**
         * 处理器核数
         */
        int processNumber = Runtime.getRuntime().availableProcessors();
        System.out.println(processNumber);

        /**
         * 并行流线程池大小
         */
        String key = "java.util.concurrent.ForkJoinPool.common.parallelism";
        System.setProperty(key,String.valueOf(processNumber));

//
//        String systemProcessNumber = System.getProperty("java.util.concurrent" +
//                ".ForkJoinPool.common.parallelism");
//        System.out.println(systemProcessNumber);

    }
}
