> [设计模式][多线程][面向对象][函数式][类加载][反射]

- <a href="#1-前言">1 前言</a>
- <a href="#2-工厂方法模式">2 工厂方法模式</a>
	- <a href="#21-抽象工厂类---abstractfactory">2.1 抽象工厂类 - AbstractFactory</a>
	- <a href="#22-抽象产品类---product">2.2 抽象产品类 - Product</a>
	- <a href="#23-产品类---bookproduct">2.3 产品类 - BookProduct</a>
	- <a href="#24-产品类---carproduct">2.4 产品类 - CarProduct</a>
	- <a href="#25-工厂类---factory">2.5 工厂类 - Factory</a>
	- <a href="#26-测试类---main">2.6 测试类 - Main</a>
- <a href="#3-动态代理模式">3 动态代理模式</a>
	- <a href="#31-被代理的接口---usermapper">3.1 被代理的接口 - UserMapper</a>
	- <a href="#32-接口的实现类---usermapperimpl">3.2 接口的实现类 - UserMapperImpl</a>
	- <a href="#33-代理类---myproxy">3.3 代理类 - MyProxy</a>
	- <a href="#34-测试---main">3.4 测试 - Main</a>
	- <a href="#35-封装代理类---universalproxy">3.5 封装代理类 - UniversalProxy</a>
	- <a href="#36-测试---main2">3.6 测试 - Main2</a>
- <a href="#4-模板方法模式">4 模板方法模式</a>
	- <a href="#41-抽象类---abstractclass">4.1 抽象类 - AbstractClass</a>
	- <a href="#42-子类---aclass">4.2 子类 - AClass</a>
	- <a href="#43-子类---bclass">4.3 子类 - BClass</a>
	- <a href="#44-测试---main">4.4 测试 - Main</a>
- <a href="#5-future模式">5 Future模式</a>
	- <a href="#51-future接口">5.1 Future接口</a>
	- <a href="#52-task接口">5.2 Task接口</a>
	- <a href="#53-callback接口">5.3 Callback接口</a>
	- <a href="#54-实现task接口---futuretask">5.4 实现Task接口 - FutureTask</a>
	- <a href="#55-futureservice接口">5.5 FutureService接口</a>
	- <a href="#56-实现futureservice接口---futureserviceimpl">5.6 实现FutureService接口 - FutureServiceImpl</a>
	- <a href="#57-测试---test">5.7 测试 - Test</a>
- <a href="#6-单例模式">6 单例模式</a>
	- <a href="#61-单例类---singleton">6.1 单例类 - Singleton</a>
	- <a href="#62-测试类---main">6.2 测试类 - Main</a>
- <a href="#7-single-thread-execution-模式">7 Single Thread Execution 模式</a>
	- <a href="#71-flightsecurity-实例">7.1 FlightSecurity 实例</a>
		- <a href="#711-flightsecurity">7.1.1 FlightSecurity</a>
		- <a href="#712-flightsecuritytest">7.1.2 FlightSecurityTest</a>
	- <a href="#72-哲学家就餐问题">7.2 哲学家就餐问题</a>
		- <a href="#721-eatnoodlethread">7.2.1 EatNoodleThread</a>
		- <a href="#722-eatnoodlethreadtest">7.2.2 EatNoodleThreadTest</a>
		- <a href="#723-eatnoodlethread2">7.2.3 EatNoodleThread2</a>
		- <a href="#724-eatnoodlethread2test">7.2.4 EatNoodleThread2Test</a>
 
## 1 前言
## 2 工厂方法模式
### 2.1 抽象工厂类 - AbstractFactory
```
package net.zhaoxuyang.common.pattern.factory_method;
public abstract class AbstractFactory {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
```
 
### 2.2 抽象产品类 - Product
```
package net.zhaoxuyang.common.pattern.factory_method;
public abstract class Product {
    public void method(){
        System.out.println("Product.method()");
    }
    public abstract void abstractMethod();
    
}
```
 
### 2.3 产品类 - BookProduct
```
package net.zhaoxuyang.common.pattern.factory_method;
public class BookProduct extends Product{
    @Override
    public void abstractMethod() {
        System.out.println(this.getClass().getName());
        System.out.println("abstractMethod()");
    }
}
```
 
### 2.4 产品类 - CarProduct
```
package net.zhaoxuyang.common.pattern.factory_method;
public class CarProduct extends Product{
    @Override
    public void abstractMethod() {
        System.out.println(this.getClass().getName());
        System.out.println("abstractMethod()");
    }
}
```
 
### 2.5 工厂类 - Factory
```java
package net.zhaoxuyang.common.pattern.factory_method;
public class Factory extends AbstractFactory{
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product result = null;
        try {
            result = (T) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (T)result;
    }
}
```
 
### 2.6 测试类 - Main
```
package net.zhaoxuyang.common.pattern.factory_method;
public class Main {
    public static void main(String[] args){
        AbstractFactory productFactory = new Factory();
        
        Product book = productFactory.createProduct(BookProduct.class);
        book.method();
        book.abstractMethod();
        
        Product car = productFactory.createProduct(CarProduct.class);
        car.method();
        car.abstractMethod();
    }
}
```

## 3 动态代理模式
### 3.1 被代理的接口 - UserMapper
```java
package net.zhaoxuyang.common.pattern.proxy;
public interface UserMapper {
    public void insert();
    public void delete();
    public void update();
    public void select();
}
```
 
### 3.2 接口的实现类 - UserMapperImpl
```java
package net.zhaoxuyang.common.pattern.proxy;
public class UserMapperImpl implements UserMapper{
    @Override
    public void insert() {
        System.out.println("insert");
    }
    @Override
    public void delete() {
        System.out.println("delete");
    }
    @Override
    public void update() {
        System.out.println("update");
    }
    @Override
    public void select() {
        System.out.println("select");
    }
    
}
```
 
 
### 3.3 代理类 - MyProxy
```java
package net.zhaoxuyang.common.pattern.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class MyProxy implements InvocationHandler{
    Class clazz = null;
    Object object = null;
    
    public MyProxy(Object object){
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.object, args);
        after();
        return result;
    }
    
    private void before(){
        System.out.println("before");
    }
    
    private void after(){
        System.out.println("after\n");
    }
    
}
```
 
### 3.4 测试 - Main
```java
package net.zhaoxuyang.common.pattern.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
public class Main {
    public static void main(String[] args){
        UserMapper object = new UserMapperImpl();
        
        InvocationHandler invocationHandler = new MyProxy(object);
        ClassLoader classLoader = object.getClass().getClassLoader();
        UserMapper proxy = (UserMapper) Proxy.newProxyInstance(classLoader, new Class[]{UserMapper.class}, invocationHandler);
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
```
 
### 3.5 封装代理类 - UniversalProxy
> 封装代理类，改成通用的。
 
```java
package net.zhaoxuyang.common.pattern.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
public class UniversalProxy extends MyProxy {
    public UniversalProxy(Object object) {
        super(object);
    }
    public static <T> T createProxy(Object object) {
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] classes = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = new MyProxy(object);
        return (T) Proxy.newProxyInstance(classLoader, classes, invocationHandler);
    }
}
```
 
### 3.6 测试 - Main2
```java
package net.zhaoxuyang.common.pattern.proxy;
public class Main2 {
    public static void main(String[] args){
        UserMapper object = new UserMapperImpl();
        UserMapper proxy = (UserMapper) UniversalProxy.createProxy(object);
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
```

## 4 模板方法模式
### 4.1 抽象类 - AbstractClass
```java
package net.zhaoxuyang.common.pattern.template_method;
public abstract class AbstractClass {
     protected abstract void start();
     protected abstract void stop();
     public final void publicMethod(){
         System.out.println("公共方法");
     } 
}
```
 
### 4.2 子类 - AClass
```java
package net.zhaoxuyang.common.pattern.template_method;
public class AClass extends AbstractClass{
    @Override
    public void start() {
        System.out.println("A.start()");
    }
    @Override
    public void stop() {
        System.out.println("A.stop()");
    } 
}
```
 
### 4.3 子类 - BClass
```java
package net.zhaoxuyang.common.pattern.template_method;
public class BClass extends AbstractClass{
    @Override
    public void start() {
        System.out.println("B.start()");
    }
    @Override
    public void stop() {
        System.out.println("B.stop()");
    }
}
```
 
### 4.4 测试 - Main
```java
package net.zhaoxuyang.common.pattern.template_method;
public class Main {
    public static void main(String[] args){
        AbstractClass a = new AClass();
        a.publicMethod();
        a.start();
        a.stop();
        
        AbstractClass b = new BClass();
        b.publicMethod();
        b.start();
        b.stop();
    }
}
```
 
## 5 Future模式
### 5.1 Future接口
```java
package net.zhaoxuyang.common.pattern.future;

public interface Future <R>{
    R get() throws InterruptedException;
    boolean done();
}
```
 
### 5.2 Task接口
```java
package net.zhaoxuyang.common.pattern.future;

@FunctionalInterface
public interface Task<IN, OUT> {
    OUT get(IN input);
}
```
 
### 5.3 Callback接口
```java
package net.zhaoxuyang.common.pattern.future;

@FunctionalInterface
public interface Callback<F> {
    void call(F t);
}
```

### 5.4 实现Task接口 - FutureTask
```java
package net.zhaoxuyang.common.pattern.future;
public class FutureTask<T> implements Future {
    private T result;
    private boolean isDone = false;
    private final Object LOCK = new Object();
    
    @Override
    public Object get() throws InterruptedException {
        synchronized (LOCK){
            while(!isDone){
                LOCK.wait();
            }
            return result;
        }
    }
    @Override
    public boolean done() {
       return isDone;
    }
    
    protected void finish(T result){
         synchronized (LOCK){
            if(isDone){
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }
}

```

### 5.5 FutureService接口
```java
package net.zhaoxuyang.common.pattern.future;

public interface FutureService<IN,OUT> {
    Future<?> submit(Runnable task);
    Future<OUT> submit(Task<IN,OUT> task,IN input);
    static<T,R>FutureService<T,R> newService(){
        return new FutureServiceImpl();
    }
    Future<OUT> submit(Task<IN,OUT> task,IN input,Callback<OUT> callback);
}
```
 
 
### 5.6 实现FutureService接口 - FutureServiceImpl
```java
package net.zhaoxuyang.common.pattern.future;
import java.util.concurrent.atomic.AtomicInteger;
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";
    private final AtomicInteger nextCounter = new AtomicInteger(0);
    private String getNextName(){
        return FUTURE_THREAD_PREFIX+nextCounter.getAndIncrement();
    }
    
    @Override
    public Future<?> submit(Runnable task) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
            task.run();
            future.finish(null);
        },getNextName()).start();
        return future;
    }
    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
      final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT output = task.get(input);
            future.finish(output);
        },getNextName()).start();
        return future;  
    }
    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT output = task.get(input);
            future.finish(output);
            if(null != callback){
                callback.call(output);
            }
        },getNextName()).start();
        return future;
    }
    
}
```
 
### 5.7 测试 - Test
```java
/**
 * 在future1完成前可以做其他事
 * future1完成
 * 在future1完成后可以做其他事
 * 在future2完成前可以做其他事
 * future2完成
 * 5
 * 在future2完成后可以做其他事
 * 在future3完成前可以做其他事情
 * future3完成
 * 5
 */
package net.zhaoxuyang.common.pattern.future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zhaoxuyang
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        FutureService<Void, Void> service = FutureService.newService();
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future1完成");
        });
        System.out.println("在future1完成前可以做其他事");
        future.get();
        System.out.println("在future1完成后可以做其他事");
        FutureService<String, Integer> service2 = FutureService.newService();
        Future<Integer> future2 = service2.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future2完成");
            return input.length();
        }, "Hello");
        System.out.println("在future2完成前可以做其他事");
        System.out.println(future2.get());
        System.out.println("在future2完成后可以做其他事");
        FutureService<String, Integer> service3 = FutureService.newService();
        service3.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("future3完成");
            return input.length();
        }, "Hello", System.out::println);
        System.out.println("在future3完成前可以做其他事情");
    }
}
```
 
## 6 单例模式
### 6.1 单例类 - Singleton
```java
/**
 * 单例模式（Sinleton Pattern）定义：
 * 确保一个类只有一个实例，而且自行实例化并向系统提供这个实例）
 */
package net.zhaoxuyang.common.pattern.singleton;
public class Singleton {    
    
    private static class SingletonInstance{
        static Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }
    public void method(){
        System.out.println("执行单例模式的一个公共方法");
    }
}
```
 
### 6.2 测试类 - Main
```java
package net.zhaoxuyang.common.pattern.singleton;
public class Main {
    public static void main(String[] args){
        Singleton instance = Singleton.getInstance();
        instance.method();
        //不能使用Singleton instance = new Singleton();
    }
}
```
 
 
 
## 7 Single Thread Execution 模式

### 7.1 FlightSecurity 实例
>- 采用排他式的操作保证在同一时刻只能有一个线程取访问共享资源。
>- 在 `pass` 方法上加 `synchronized` 是实现该模式的核心。
 
#### 7.1.1 FlightSecurity
```java
package net.zhaoxuyang.common.pattern.ste;

public class FlightSecurity {
    private int count = 0;
    private String boardingPass = null;
    private String idCard = "null";
    /**
     * 加synchronized关键字是实现该模式的核心
     *
     * @param boardingPass
     * @param idCard
     */
    public synchronized void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        checkPass();
        
        System.out.println(this);
    }
    private void checkPass() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("Exception:" + toString());
        }
    }
    @Override
    public String toString() {
        return "count:" + count
                + ", boardingPass:" + boardingPass
                + ",idCard:" + idCard;
    }
}
```
 
#### 7.1.2 FlightSecurityTest
```java
package net.zhaoxuyang.common.pattern.ste;

public class FlightSecurityTest {
    static class Passengers extends Thread {
        private final FlightSecurity flightSecurity;
        private final String idCard;
        private final String boardingPass;
        public Passengers(FlightSecurity flightSecurity,
                String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }
  
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }
    public static void main(String[] args) {
        final FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity, "A123", "AF12345").start();
        new Passengers(flightSecurity, "B123", "BF12345").start();
        new Passengers(flightSecurity, "C123", "CF12345").start();
    }
}
```

### 7.2 哲学家就餐问题
 
#### 7.2.1 EatNoodleThread
```
package net.zhaoxuyang.common.pattern.ste;
import static java.lang.System.out;

public class EatNoodleThread extends Thread {
    private final String name;
    private final Tableware leftTool;
    private final Tableware rightTool;
    public EatNoodleThread(String name, Tableware leftTool, Tableware rightTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }
    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }
    private void eat() {
        synchronized (leftTool) {
            out.println("name:" + name + ",left satrt:" + leftTool);
            synchronized (rightTool) {
                out.println("name:" + name + ",right start:" + rightTool);
                out.println("name:" + name + "eat");
                out.println("name:" + name + ",right end:" + rightTool);
            }
            out.println("name:" + name + ",left end:" + leftTool);
        }
    }
}
```
#### 7.2.2 EatNoodleThreadTest
> `EatNoodleThreadTest` 中引发交叉锁。
```java
package net.zhaoxuyang.common.pattern.ste;

public class EatNoodleThreadTest {
    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        
        new EatNoodleThread("A", fork, knife).start();
        new EatNoodleThread("B", knife, fork).start();
    }
}
```
 
#### 7.2.3 EatNoodleThread2
> 解决办法：新增`TablewarePair` ，避免 `synchronized` 重入锁，
```
package net.zhaoxuyang.common.pattern.ste;
import static java.lang.System.out;

public class EatNoodleThread2 extends Thread {
    private final String name;
    private final TablewarePair pair;
    public EatNoodleThread2(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.pair = tablewarePair;
    }
    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }
    private void eat() {
        synchronized (pair) {
            out.println("name:" + name + ",left satrt:" + pair.getLeftTool());
            out.println("name:" + name + ",right start:" + pair.getRightTool());
            out.println("name:" + name + "eat");
            out.println("name:" + name + ",right end:" + pair.getRightTool());
            out.println("name:" + name + ",left end:" + pair.getLeftTool());
        }
    }
}
```
#### 7.2.4 EatNoodleThread2Test
```java
package net.zhaoxuyang.common.pattern.ste;

public class EatNoodleThread2Test {
    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        
        TablewarePair pair = new TablewarePair(fork, knife);
        new EatNoodleThread2("A", pair).start();
        new EatNoodleThread2("B", pair).start();
    }
}
```

 
