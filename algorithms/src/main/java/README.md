
> [数据结构][算法][面向对象][Java]
 
- <a href="#1-设计接口">1 设计接口</a>
	- <a href="#11-容器接口container">1.1 容器接口Container</a>
	- <a href="#12-背包接口bag">1.2 背包接口Bag</a>
	- <a href="#13-栈接口stack">1.3 栈接口Stack</a>
	- <a href="#14-队列接口queue">1.4 队列接口Queue</a>
	- <a href="#15-union-find算法接口uf">1.5 Union-Find算法接口UF</a>
- <a href="#2-实现接口">2 实现接口</a>
	- <a href="#21-结点类node">2.1 结点类Node</a>
	- <a href="#22-数组迭代器arrayiterator">2.2 数组迭代器ArrayIterator</a>
	- <a href="#23-链表迭代器listiterator">2.3 链表迭代器ListIterator</a>
	- <a href="#24-背包bag的实现">2.4 背包(Bag)的实现</a>
		- <a href="#241-能动态调整数组大小的bag">2.4.1 能动态调整数组大小的Bag</a>
		- <a href="#242-链式bag的实现">2.4.2 链式Bag的实现</a>
	- <a href="#25-栈stack的实现">2.5 栈(Stack)的实现</a>
		- <a href="#251-能动态调整数组大小的stack">2.5.1 能动态调整数组大小的Stack</a>
		- <a href="#252-链式stack的实现">2.5.2 链式Stack的实现</a>
	- <a href="#26-队列queue的实现">2.6 队列(Queue)的实现</a>
		- <a href="#261-能动态调整数组大小的queue">2.6.1 能动态调整数组大小的Queue</a>
		- <a href="#262-链式queue的实现">2.6.2 链式Queue的实现</a>
	- <a href="#27-union-find算法的实现">2.7 Union-Find算法的实现</a>
		- <a href="#271-defaultuf">2.7.1 DefaultUF</a>
		- <a href="#272-quickfinduf">2.7.2 QuickFindUF</a>
		- <a href="#273-quickunionuf">2.7.3 QuickUnionUF</a>
		- <a href="#274-weightedquickunionuf">2.7.4 WeightedQuickUnionUF</a>
	- <a href="#28-测试">2.8 测试</a>
		- <a href="#281-测试stack">2.8.1 测试Stack</a>
		- <a href="#282-测试union-find">2.8.2 测试Union-Find</a>
- <a href="#3-排序算法">3 排序算法</a>
	- <a href="#31-定义排序工具的类结构">3.1 定义排序工具的类结构</a>
	- <a href="#32-选择排序">3.2 选择排序</a>
	- <a href="#33-插入排序">3.3 插入排序</a>
	- <a href="#34-希尔排序">3.4 希尔排序</a>
	- <a href="#35-归并排序">3.5 归并排序</a>
		- <a href="#351-归并排序的合并方法">3.5.1 归并排序的合并方法</a>
		- <a href="#352-自顶向下的归并排序">3.5.2 自顶向下的归并排序</a>
		- <a href="#353-自底向上的归并排序">3.5.3 自底向上的归并排序</a>
	- <a href="#36-快速排序">3.6 快速排序</a>
		- <a href="#361-常规快速排序">3.6.1 常规快速排序</a>
		- <a href="#362-排序前先洗牌">3.6.2 排序前先洗牌</a>
		- <a href="#363-快速排序的改进方法-小数据量转成插入排序">3.6.3 快速排序的改进方法-小数据量转成插入排序</a>
		- <a href="#364-快速排序的改进方法-三向切分">3.6.4 快速排序的改进方法-三向切分</a>
	- <a href="#37-堆排序">3.7 堆排序</a>
	- <a href="#38-最终的排序工具">3.8 最终的排序工具</a>
- <a href="#4-搜索">4 搜索</a>
	- <a href="#41-二分搜索binarysearch">4.1 二分搜索(binarySearch)</a>
	- <a href="#42-优先队列maxpriorityqueue">4.2 优先队列(MaxPriorityQueue)</a>
	- <a href="#43-二叉查找树bst">4.3 二叉查找树(BST)</a>
	- <a href="#44-红黑二叉查找树redblackbst">4.4 红黑二叉查找树(RedBlackBST)</a>
	- <a href="#45-b-树btree">4.5 B-树(BTree)</a>
- <a href="#5-图">5 图</a>
	- <a href="#51-无向图graph">5.1 无向图(Graph)</a>
	- <a href="#52-有向图digraph">5.2 有向图(Digraph)</a>
- <a href="#6-贪心">6 贪心</a>
	- <a href="#61-dijkstra算法-单元最短路径">6.1 Dijkstra算法-单元最短路径</a>
		- <a href="#611-问题描述">6.1.1 问题描述</a>
		- <a href="#612-贪心策略">6.1.2 贪心策略</a>
		- <a href="#613-算法设计">6.1.3 算法设计</a>
		- <a href="#614-示例">6.1.4 示例</a>
- <a href="#7-动态规划">7 动态规划</a>
	- <a href="#71-最长公共子序列问题">7.1 最长公共子序列问题</a>
	- <a href="#72-0-1背包问题">7.2 0-1背包问题</a>
	- <a href="#73-加工顺序问题">7.3 加工顺序问题</a>
- <a href="#8-搜索法">8 搜索法</a>
	- <a href="#81-图的着色问题">8.1 图的着色问题</a>
	- <a href="#82-深度优先搜索">8.2 深度优先搜索</a>
	- <a href="#83-回溯法">8.3 回溯法</a>
		- <a href="#831-回溯法的算法框架">8.3.1 回溯法的算法框架</a>
		- <a href="#832-子集树">8.3.2 子集树</a>
		- <a href="#833-排列树">8.3.3 排列树</a>
		- <a href="#834-满m叉树组合树">8.3.4 满m叉树(组合树)</a>
	- <a href="#84-广度优先搜索">8.4 广度优先搜索</a>
	- <a href="#85-分支限界法">8.5 分支限界法</a>
- <a href="#9-随机化算法">9 随机化算法</a>
	- <a href="#91-数值随机化算法">9.1 数值随机化算法</a>
	- <a href="#92-蒙特卡罗算法">9.2 蒙特卡罗算法</a>
	- <a href="#93-拉斯维加斯算法">9.3 拉斯维加斯算法</a>
	- <a href="#94-舍伍德算法">9.4 舍伍德算法</a>
- <a href="#10-数论算法">10 数论算法</a>
	- <a href="#101-stein求最大公约数">10.1 Stein求最大公约数</a>
	- <a href="#102-矩阵求斐波那切数列">10.2 矩阵求斐波那切数列</a>


## 1 设计接口
### 1.1 容器接口Container
```java
package ds;
import java.util.NoSuchElementException;
public interface Container{
    int size();
    
    default boolean isEmpty(){
        return size() == 0;
    }
    default void notEmptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException("size == 0");
        }
    }
}
```

### 1.2 背包接口Bag
```java
package ds;

public interface Bag<T> extends Container {
    void add(T data);
}


```

### 1.3 栈接口Stack
```java
package ds;

public interface Stack<T>extends Container {
    void push(T data);
    T pop();
    T peek();
}
```


### 1.4 队列接口Queue
```java
package ds;

public interface Queue<T> extends Container {
    T peek();
    void enqueue(T data);
    T dequeue();
}
```

### 1.5 Union-Find算法接口UF
```java
package ds;

public interface UF {
    int size();
    int find(int p);
    boolean connected(int p, int q);
    void union(int p, int q);
    default void validate(int p, int n) {
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("p>=0 && p<n");
        }
    }
}
```

## 2 实现接口
> 为数组和链表定义了公共的结点和迭代器实现。

### 2.1 结点类Node
```java
package ds.util;

public class Node<T> {
   public T data;
   public Node<T> next;
}
```

### 2.2 数组迭代器ArrayIterator
```java
package ds.util;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private int i;
    private final int size;
    private final T[] array;
    public ArrayIterator(T[] array, int size) {
        this.array = array;
        this.size = size;
    }
    @Override
    public boolean hasNext() {
        return i < size;
    }
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[i++];
    }
}
```


### 2.3 链表迭代器ListIterator
```java
package ds.util;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {
    private Node<T> current;
    public ListIterator(Node<T> first) {
        current = first;
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T result = current.data;
        current = current.next;
        return result;
    }
}


```

### 2.4 背包(Bag)的实现
> 背包(Bag)是一种不支持从中删除元素的集合数据类型。


#### 2.4.1 能动态调整数组大小的Bag
```java
package ds.impl;
import ds.Bag;
import java.util.Iterator;
import ds.util.ArrayIterator;

public class ArrayBag<T> implements Iterable<T>,Bag<T> {
    private T[] array;
    private int size;
    public ArrayBag() {
        array = (T[]) new Object[2];
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void add(T data) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = data;
    }
    private void resize(int capacity) {
        assert capacity >= 0;
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, size);
        array = tmp;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(array,size);
    }
    
}
```

#### 2.4.2 链式Bag的实现

```java
package ds.impl;
import ds.util.Node;
import ds.Bag;
import java.util.Iterator;
import ds.util.ListIterator;

public class LinkedBag<T> implements Iterable<T>, Bag<T> {
    private Node<T> first;
    private int size;
    public LinkedBag() {
        first = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void add(T data) {
        Node<T> old = first;
        first = new Node<>();
        first.data = data;
        first.next = old;
        size++;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T data : this) {
            s.append(data).append(' ');
        }
        return s.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }
}
```

### 2.5 栈(Stack)的实现

> 栈(Stack)是一种先进后出的数据类型。

#### 2.5.1 能动态调整数组大小的Stack
```java
package ds.impl;
import ds.Stack;
import java.util.Iterator;
import ds.util.ArrayIterator;

public class ArrayStack<T> implements Iterable<T>,Stack<T> {
    private T[] array;
    private int size;
    
    public ArrayStack(){
        array = (T[]) new Object[2];
        size = 0;
    }
    
    
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(array,size);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void push(T data) {
        if(size == array.length){
            resize(2* array.length);
        }
        array[size++] = data;
    }
    private void resize(int capacity) {
        assert capacity >= size;
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(array, 0, tmp, 0, size);
        array = tmp;
    }
    
    @Override
    public T pop() {
        notEmptyCheck();
        T result = array[size-1];
        array[size-1] = null;
        size--;
        if(size>0 && size == array.length/4){
            resize(array.length/2);
        }
        return result;
    }
    
    @Override
    public T peek() {
        notEmptyCheck();
        return array[size-1];
    }
}
```

#### 2.5.2 链式Stack的实现
```java
package ds.impl;
import ds.util.Node;
import ds.Stack;
import java.util.Iterator;
import ds.util.ListIterator;

public class LinkedStack<T> implements Iterable<T>,Stack<T> {
    private Node<T> first;
    private int size;
    public LinkedStack() {
        first = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    /**
     * 向栈中推入一个新元素
     *
     * @param data 新元素
     */
    @Override
    public void push(T data) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.data = data;
        first.next = oldFirst;
        size++;
    }
    /**
     * 从栈中弹出栈首元素
     *
     * @return 栈首元素
     */
    @Override
    public T pop() {
        notEmptyCheck();
        T result = first.data;
        first = first.next;
        size--;
        return result;
    }
    /**
     * 查看栈首元素
     * @return 栈首元素
     */
    @Override
    public T peek() {
        notEmptyCheck();
        return first.data;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T data : this) {
            s.append(data).append(' ');
        }
        return s.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }
}
```

### 2.6 队列(Queue)的实现
> 队列(Queue)是一种先进先出的数据类型。

#### 2.6.1 能动态调整数组大小的Queue

```java
package ds.impl;
import ds.Queue;
import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T>,Queue<T> {
    private T[] array;
    private int size;
    private int first;
    private int last;
    public ArrayQueue() {
        array = (T[]) new Object[2];
        size = 0;
        first = 0;
        last = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void enqueue(T data) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[last++] = data;
        if (last == array.length) {
            last = 0;
        }
        size++;
    }
    @Override
    public T dequeue() {
        notEmptyCheck();
        T result = array[first];
        array[first] = null;
        size--;
        first++;
        if (first == array.length) {
            first = 0;
        }
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return result;
    }
    
    @Override
    public T peek(){
        notEmptyCheck();
        return array[first];
    }
    private void resize(int capacity) {
        assert capacity >= size;
        T[] tmp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[(first + i) % array.length];
        }
        array = tmp;
        first = 0;
        last = size;
    }
    @Override
    public Iterator<T> iterator() {
        return new ds.util.ArrayIterator(array,size);
    }
}
```

#### 2.6.2 链式Queue的实现
```java
package ds.impl;
import ds.util.Node;
import ds.Queue;
import java.util.Iterator;
import ds.util.ListIterator;

public class LinkedQueue<T> implements Iterable<T>, Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public T peek() {
        notEmptyCheck();
        return first.data;
    }
    @Override
    public void enqueue(T data) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.data = data;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }
    @Override
    public T dequeue() {
        notEmptyCheck();
        T result = first.data;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T data : this) {
            s.append(data).append(' ');
        }
        return s.toString();
    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }
}
```

### 2.7 Union-Find算法的实现
> 并查集（Union-Find）是解决动态连通性问题的一类非常高效的数据结构。

#### 2.7.1 DefaultUF
```java
package ds.impl;
import ds.UF;

public class DefaultUF implements UF {
    private int[] parent;
    private byte[] rank;
    private int size;
    public DefaultUF(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    @Override
    public int find(int p) {
        validate(p, parent.length);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootQ] > rank[rootP]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        size--;
    }
}
```

#### 2.7.2 QuickFindUF
```java
package ds.impl;
import ds.UF;

public class QuickFindUF implements UF {
    private final int[] id;
    private int size;
    public QuickFindUF(int n) {
        size = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int find(int p) {
        validate(p, id.length);
        return id[p];
    }
    @Override
    public boolean connected(int p, int q) {
        validate(p, id.length);
        validate(q, id.length);
        return id[p] == id[q];
    }
    @Override
    public void union(int p, int q) {
        validate(p, id.length);
        validate(q, id.length);
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        size--;
    }
}
```
#### 2.7.3 QuickUnionUF
```java
package ds.impl;
import ds.UF;
public class QuickUnionUF implements UF {
    private final int[] parent;
    private int size;
    public QuickUnionUF(int n) {
        parent = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int find(int p) {
        validate(p, parent.length);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        size--;
    }
}
```
#### 2.7.4 WeightedQuickUnionUF
> 加权 quick-union算法，是目前所有实现中最优的算法
```java
package ds.impl;
import ds.UF;

public class WeightedQuickUnionUF implements UF {
    private final int[] parent;
    private final int[] num;
    private int size;
    public WeightedQuickUnionUF(int n) {
        size = n;
        parent = new int[n];
        num = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            num[i] = 1;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public int find(int p) {
        validate(p, parent.length);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // make smaller root point to larger one
        if (num[rootP] < num[rootQ]) {
            parent[rootP] = rootQ;
            num[rootQ] += num[rootP];
        } else {
            parent[rootQ] = rootP;
            num[rootP] += num[rootQ];
        }
        size--;
    }
}
```

### 2.8 测试
#### 2.8.1 测试Stack
> Dijkstra的双栈算数表达式求值算法
```java
package test;
import java.util.Scanner;
import ds.impl.LinkedStack;

public class StackTest {
    public static void main(String[] args) {
        evaluate();
    }
    /**
     * Dijkstra的双栈算数表达式求值算法
     */
    public static void evaluate() {
        String str = "( 1 + ( ( 2.3 + 3 ) / ( sqrt ( 16 ) * ( 5 % 9 ) ) ) )";
        LinkedStack<String> opStack = new LinkedStack<>();
        LinkedStack<Double> valStack = new LinkedStack<>();
        Scanner scanner = new Scanner(str);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.print(s + ' ');
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "sqrt":
                    opStack.push(s);
                    break;
                case "(":
                    break;
                case ")":
                    String op = opStack.pop();
                    double v = valStack.pop();
                    switch (op) {
                        case "+":
                            v = valStack.pop() + v;
                            break;
                        case "-":
                            v = valStack.pop() - v;
                            break;
                        case "*":
                            v = valStack.pop() * v;
                            break;
                        case "/":
                            v = valStack.pop() / v;
                            break;
                        case "%":
                            v = valStack.pop() % v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                        default:
                            break;
                    }
                    valStack.push(v);
                    break;
                default:
                    valStack.push(Double.parseDouble(s));
                    break;
            }
        }
        System.out.printf("= %f\n", valStack.pop());
    }
}
```

#### 2.8.2 测试Union-Find
```java
package test;
import ds.UF;
import ds.impl.DefaultUF;
import ds.impl.QuickFindUF;
import ds.impl.QuickUnionUF;

public class UFTest {
    public static void main(String[] args) {
        UF uf;
        int findResult;
        uf = new QuickFindUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));
        uf = new DefaultUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));
        uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        findResult = uf.find(3);
        System.out.println(findResult);
        System.out.println(uf.size());
        System.out.println(uf.connected(4, 3));
        System.out.println(uf.connected(9, 3));
    }
}
```

## 3 排序算法

### 3.1 定义排序工具的类结构
> 需要实现排序器，以及通过静态方法调用。
```java
package util;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        String[] a = {
            "1", "2", "3", "a", "a1", "b2", "a0", "_"
        };
        //Sort.heapSort(a);
        //Sort.quickSort3way(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    
    /**
     * 根据数组的两个下标交换数组中的元素
     *
     * @param <T>
     * @param array
     * @param i
     * @param j
     */
    private static <T extends Comparable> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    /**
     * 判断a是否小于b
     *
     * @param <T>
     * @param a
     * @param b
     * @return
     */
    private static <T extends Comparable> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
    /**
     * 判断a是否等于b
     *
     * @param <T>
     * @param a
     * @param b
     * @return
     */
    private static <T extends Comparable> boolean eq(T a, T b) {
        return a.compareTo(b) == 0;
    }
    /**
     * 判断数组是否排序
     *
     * @param <T>
     * @param array
     * @return
     */
    public static <T extends Comparable> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * 打印数组
     *
     * @param <T>
     * @param array
     */
    public static <T extends Comparable> void print(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}


```
### 3.2 选择排序
> 时间复杂度O(n^2)，辅助空间O(1)，不稳定

```java
    public static <T extends Comparable> void selectSort(T[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
```

### 3.3 插入排序
> 时间复杂度O(n^2)，辅助空间O(1)，稳定

```java
    public static <T extends Comparable> void insertSort(T[] a) {
        insertSort(a, 0, a.length);
    }
    public static <T extends Comparable> void insertSort(T[] a, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
```

### 3.4 希尔排序
> 时间复杂度O(n^1.25)，辅助空间O(1)，不稳定

```java
    public static <T extends Comparable> void shellSort(T[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        for (; h >= 1; h /= 3) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
        }
    }
```

### 3.5 归并排序
> 时间复杂度O(nlog(n))，辅助空间O(nlog(n))，稳定

#### 3.5.1 归并排序的合并方法
```java
    /**
     * 归并排序所需的辅助数组。不将其声明为方法内的局部变量，是为了避免重复创建数组
     */
    private static Comparable[] mergeAux;
    /**
     * 归并排序的合并方法
     * <pre>
     * 该方法先将所有元素复制到辅助数组中，再归并回数组a中。
     * 在归并时进行了4个条件判断：
     * - 左半边用尽（取右半边的元素）
     * - 右半边用尽（取左半边的元素）
     * - 右半边当前元素小于左半边的当前元素（取右半边的元素）
     * - 右半边当前元素大于等于左半边的当前元素（取左半边元素）
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param middle
     * @param high
     */
    private static <T extends Comparable>
            void merge(T[] a, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            mergeAux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                a[k] = (T) mergeAux[j++];
            } else if (j > high) {
                a[k] = (T) mergeAux[i++];
            } else if (less(mergeAux[j], mergeAux[i])) {
                a[k] = (T) mergeAux[j++];
            } else {
                a[k] = (T) mergeAux[i++];
            }
        }
    }

```


#### 3.5.2 自顶向下的归并排序
```java
    public static <T extends Comparable> void mergeSort(T[] a) {
        mergeAux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }
    public static <T extends Comparable>
            void mergeSort(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSort(a, low, middle);
        mergeSort(a, middle + 1, high);
        merge(a, low, middle, high);
    }
```


#### 3.5.3 自底向上的归并排序
> 自底向上的归并排序适用于链表组织的数据
```java
    public static <T extends Comparable> void mergeSort2(T[] a) {
        int N = a.length;
        mergeAux = new Comparable[a.length];
        for (int i = 1; i < N; i = i + i) {
            for (int low = 0; low < N - i; low += i + i) {
                merge(a, low, low + i - 1, Math.min(low + i + i - 1, N - 1));
            }
        }
    }
```


### 3.6 快速排序
> 时间复杂度O(nlog(n))，辅助空间O(nlog(n))，不稳定。非特殊场景下，最快的排序算法

#### 3.6.1 常规快速排序
```java
    /**
     * 常规快速排序的划分方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable>
            int partition(T[] a, int low, int high) {
        int i = low;
        int j = high;
        T p = a[low];
        while (i < j) {
            while (i < j && (less(p, a[j]) || eq(a[j], p))) {
                j--;
            }
            if (i < j) {
                swap(a, i++, j);
            }
            while (i < j && (less(a[i], p) || eq(a[i], p))) {
                i++;
            }
            if (i < j) {
                swap(a, i, j--);
            }
        }
        return j;
    }
    /**
     * 常规快速排序的排序方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort(T[] a, int low, int high) {
        int p;
        if (low < high) {
            p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }
 
 
```


#### 3.6.2 排序前先洗牌

```java
   /**
     * 快速排序:在排序前先洗牌（可以参考随机化算法-舍伍德算法）
     * <pre>
     * 快速排序的算法改进：
     * 【切换到插入排序】【三取样切分】【熵最优的排序，三向切分】
     * <pre>
     * 三取样切分
     * (1)使用子数组的一小部分元素的中位数来切分数组，这样能切分得更好，但是需要计算中位数
     * (2)人们发现将大小设为3并用大小居中的元素切分得效果最好
     * </pre>
     * </pre>
     *
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void quickSort(T[] a) {
        Shuffle.shuffle(a);
        quickSort(a, 0, a.length - 1);
//        quickSortInsert(a, 0, a.length - 1);
//        quickSort3way(a, 0, a.length - 1);
    }
```

> 以下是该洗牌算法的实现
```java
package util;
import java.util.Arrays;
/**
 * 设计一种公平的洗牌算法（算法导论）
 *
 * @author zhaoxuyang
 */
public class Shuffle {
    public static void main(String[] args) {
        Integer[] a = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        };
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }
    public static <T extends Comparable> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, rand(0, i));
        }
    }
    private static int rand(int begin, int end) {
        return (int) (begin + Math.random() * (end - begin + 1));
    }
    private static <T extends Comparable> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}


```


#### 3.6.3 快速排序的改进方法-小数据量转成插入排序
```java
    /**
     * 快速排序的改进方法-小数据量转成插入排序
     * <pre>
     * (1)对于小数组，快速排序比插入排序慢；
     * (2)因为递归，快速排序的sort方法会调用自己。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSortInsert(T[] a, int low, int high) {
        int m = 65535;
        if (high <= low + m) {
            insertSort(a, low, high);
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }
```

#### 3.6.4 快速排序的改进方法-三向切分
```java
    /**
     * 快速排序的改进方法-三向切分（可以参考荷兰国旗问题）
     * <pre>
     * 对于存在大量重复元素的数组，三向切分比常规快排高效得多。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort3way(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }
```

### 3.7 堆排序
> 时间复杂度O(nlog(n))，辅助空间O(nlog(n))，不稳定

```java
    public static <T extends Comparable> void heapSort(T[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            swap(a, 1 - 1, (n--) - 1);
            sink(a, 1, n);
        }
    }
    private static <T extends Comparable> void sink(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j - 1], pq[j])) {
                j++;
            }
            if (!less(pq[k - 1], pq[j - 1])) {
                break;
            }
            swap(pq, k - 1, j - 1);
            k = j;
        }
    }
```

 

### 3.8 最终的排序工具
```java
package util;
import java.util.Arrays;
/**
 * 排序
 *
 * @author zhaoxuyang
 */
public class Sort {
    public static void main(String[] args) {
        String[] a = {
            "1", "2", "3", "a", "a1", "b2", "a0", "_"
        };
        //Sort.heapSort(a);
        //Sort.quickSort3way(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    /**
     * 堆排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void heapSort(T[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            swap(a, 1 - 1, (n--) - 1);
            sink(a, 1, n);
        }
    }
    private static <T extends Comparable> void sink(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq[j - 1], pq[j])) {
                j++;
            }
            if (!less(pq[k - 1], pq[j - 1])) {
                break;
            }
            swap(pq, k - 1, j - 1);
            k = j;
        }
    }
    /**
     * 快速排序:在排序前先洗牌（可以参考随机化算法-舍伍德算法）
     * <pre>
     * 快速排序的算法改进：
     * 【切换到插入排序】【三取样切分】【熵最优的排序，三向切分】
     * <pre>
     * 三取样切分
     * (1)使用子数组的一小部分元素的中位数来切分数组，这样能切分得更好，但是需要计算中位数
     * (2)人们发现将大小设为3并用大小居中的元素切分得效果最好
     * </pre>
     * </pre>
     *
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void quickSort(T[] a) {
        Shuffle.shuffle(a);
        quickSort(a, 0, a.length - 1);
//        quickSortInsert(a, 0, a.length - 1);
//        quickSort3way(a, 0, a.length - 1);
    }
    /**
     * 快速排序的改进方法-小数据量转成插入排序
     * <pre>
     * (1)对于小数组，快速排序比插入排序慢；
     * (2)因为递归，快速排序的sort方法会调用自己。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSortInsert(T[] a, int low, int high) {
        int m = 65535;
        if (high <= low + m) {
            insertSort(a, low, high);
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }
    /**
     * 快速排序的改进方法-三向切分（可以参考荷兰国旗问题）
     * <pre>
     * 对于存在大量重复元素的数组，三向切分比常规快排高效得多。
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort3way(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low;
        int i = low + 1;
        int gt = high;
        T v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                swap(a, lt++, i++);
            } else if (cmp > 0) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }
    /**
     * 常规快速排序的排序方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void quickSort(T[] a, int low, int high) {
        int p;
        if (low < high) {
            p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }
    /**
     * 常规快速排序的划分方法
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static <T extends Comparable>
            int partition(T[] a, int low, int high) {
        int i = low;
        int j = high;
        T p = a[low];
        while (i < j) {
            while (i < j && (less(p, a[j]) || eq(a[j], p))) {
                j--;
            }
            if (i < j) {
                swap(a, i++, j);
            }
            while (i < j && (less(a[i], p) || eq(a[i], p))) {
                i++;
            }
            if (i < j) {
                swap(a, i, j--);
            }
        }
        return j;
    }
    /**
     * 归并排序所需的辅助数组。不将其声明为方法内的局部变量，是为了避免重复创建数组
     */
    private static Comparable[] mergeAux;
    /**
     * 自底向上的归并排序（适用于链表组织的数据）
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void mergeSort2(T[] a) {
        int N = a.length;
        mergeAux = new Comparable[a.length];
        for (int i = 1; i < N; i = i + i) {
            for (int low = 0; low < N - i; low += i + i) {
                merge(a, low, low + i - 1, Math.min(low + i + i - 1, N - 1));
            }
        }
    }
    /**
     * 自顶向下的归并排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void mergeSort(T[] a) {
        mergeAux = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }
    /**
     * 自顶向下的归并排序
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable>
            void mergeSort(T[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSort(a, low, middle);
        mergeSort(a, middle + 1, high);
        merge(a, low, middle, high);
    }
    /**
     * 归并排序的合并方法
     * <pre>
     * 该方法先将所有元素复制到辅助数组中，再归并回数组a中。
     * 在归并时进行了4个条件判断：
     * - 左半边用尽（取右半边的元素）
     * - 右半边用尽（取左半边的元素）
     * - 右半边当前元素小于左半边的当前元素（取右半边的元素）
     * - 右半边当前元素大于等于左半边的当前元素（取左半边元素）
     * </pre>
     *
     * @param <T>
     * @param a
     * @param low
     * @param middle
     * @param high
     */
    private static <T extends Comparable>
            void merge(T[] a, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        for (int k = low; k <= high; k++) {
            mergeAux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > middle) {
                a[k] = (T) mergeAux[j++];
            } else if (j > high) {
                a[k] = (T) mergeAux[i++];
            } else if (less(mergeAux[j], mergeAux[i])) {
                a[k] = (T) mergeAux[j++];
            } else {
                a[k] = (T) mergeAux[i++];
            }
        }
    }
    /**
     * 希尔排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void shellSort(T[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        for (; h >= 1; h /= 3) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
        }
    }
    /**
     * 插入排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void insertSort(T[] a) {
        insertSort(a, 0, a.length);
    }
    /**
     * 插入排序
     *
     * @param <T>
     * @param a
     * @param low
     * @param high
     */
    public static <T extends Comparable> void insertSort(T[] a, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
    }
    /**
     * 选择排序
     *
     * @param <T>
     * @param a
     */
    public static <T extends Comparable> void selectSort(T[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
    /**
     * 根据数组的两个下标交换数组中的元素
     *
     * @param <T>
     * @param array
     * @param i
     * @param j
     */
    private static <T extends Comparable> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    /**
     * 判断a是否小于b
     *
     * @param <T>
     * @param a
     * @param b
     * @return
     */
    private static <T extends Comparable> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
    /**
     * 判断a是否等于b
     *
     * @param <T>
     * @param a
     * @param b
     * @return
     */
    private static <T extends Comparable> boolean eq(T a, T b) {
        return a.compareTo(b) == 0;
    }
    /**
     * 判断数组是否排序
     *
     * @param <T>
     * @param array
     * @return
     */
    public static <T extends Comparable> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * 打印数组
     *
     * @param <T>
     * @param array
     */
    public static <T extends Comparable> void print(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}


```

> 洗牌算法(Shuffle)
```java
package util;
import java.util.Arrays;
/**
 * 设计一种公平的洗牌算法（算法导论）
 *
 * @author zhaoxuyang
 */
public class Shuffle {
    public static void main(String[] args) {
        Integer[] a = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
        };
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }
    public static <T extends Comparable> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, rand(0, i));
        }
    }
    private static int rand(int begin, int end) {
        return (int) (begin + Math.random() * (end - begin + 1));
    }
    private static <T extends Comparable> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
```

## 4 搜索
### 4.1 二分搜索(binarySearch)
```Java
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
```

### 4.2 优先队列(MaxPriorityQueue)
```java
package ds.impl;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPriorityQueue<T> implements Iterable<T> {
    private T[] pq;
    private int size;
    private Comparator<T> comparator;
    public MaxPriorityQueue(int capacity, Comparator comparator) {
        pq = (T[]) new Object[capacity + 1];
        size = 0;
        this.comparator = comparator;
    }
    public MaxPriorityQueue(int capacity) {
        this(capacity, null);
    }
    public MaxPriorityQueue(Comparator comparator) {
        this(1, comparator);
    }
    public MaxPriorityQueue() {
        this(1);
    }
    public MaxPriorityQueue(T[] keys) {
        size = keys.length;
        pq = (T[]) new Object[size + 1];
        System.arraycopy(keys, 0, pq, 1, size);
        for (int k = size / 2; k >= 1; k--) {
            sink(k);
        }
    }
    public void insert(T key) {
        if (size == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++size] = key;
        swim(size);
    }
    public T max() {
        notEmptyCheck();
        return pq[1];
    }
    public T deleteMax() {
        notEmptyCheck();
        T result = pq[1];
        swap(1, size--);
        sink(1);
        pq[size + 1] = null;
        if ((size > 0) && (size == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return result;
    }
    private void notEmptyCheck() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new HeapIterator();
    }
    private class HeapIterator implements Iterator<T> {
        private MaxPriorityQueue<T> copy;
        public HeapIterator() {
            if (comparator == null) {
                copy = new MaxPriorityQueue<>(size());
            } else {
                copy = new MaxPriorityQueue<>(size(), comparator);
            }
            for (int i = 1; i <= size; i++) {
                copy.insert(pq[i]);
            }
        }
        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.deleteMax();
        }
    }
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    private boolean less(int a, int b) {
        if (comparator == null) {
            return ((Comparable<T>) pq[a]).compareTo(pq[b]) < 0;
        } else {
            return comparator.compare(pq[a], pq[b]) < 0;
        }
    }
    private void swap(int a, int b) {
        T tmp = pq[a];
        pq[a] = pq[b];
        pq[b] = tmp;
    }
    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
    private boolean isEmpty() {
        return size() == 0;
    }
    private int size() {
        return size;
    }
}


```

### 4.3 二叉查找树(BST)
```java
package ds.impl;
import ds.Queue;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;
        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        return x == null ? 0 : x.size;
    }
    public V get(K key) {
        return get(root, key);
    }
    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
    public void put(K key, V value) {
        root = put(root, key, value);
    }
    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public K minKey() {
        return minKey(root).key;
    }
    private Node minKey(Node x) {
        return x.left == null ? x : minKey(x.left);
    }
    public K maxKey() {
        return maxKey(root).key;
    }
    private Node maxKey(Node x) {
        return x.right == null ? x : maxKey(x.right);
    }
    public K floorKey(K key) {
        Node x = floorKey(root, key);
        return x == null ? null : x.key;
    }
    private Node floorKey(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floorKey(x, key);
        }
        Node t = floorKey(x.right, key);
        return t != null ? t : x;
    }
    public K ceilKey(K key) {
        Node x = ceilKey(root, key);
        return x == null ? null : x.key;
    }
    private Node ceilKey(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceilKey(x, key);
        }
        Node t = ceilKey(x.left, key);
        return t != null ? t : x;
    }
    public K selectKey(int k) {
        return selectKey(root, k).key;
    }
    private Node selectKey(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return selectKey(x.left, k);
        } else if (t < k) {
            return selectKey(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    public int rankKey(K key) {
        return rankKey(root, key);
    }
    private int rankKey(Node x, K key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rankKey(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rankKey(x.right, key);
        } else {
            return size(x.left);
        }
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(K key) {
        root = delete(root, key);
    }
    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = minKey(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Iterable<K> keys() {
        return keys(minKey(), maxKey());
    }
    private Iterable<K> keys(K lowKey, K highKey) {
        LinkedQueue<K> queue = new LinkedQueue<>();
        keys(root, queue, lowKey, highKey);
        return queue;
    }
    private void keys(Node x, Queue<K> queue, K lowKey, K highKey) {
        if (x == null) {
            return;
        }
        
        int cmpLow = lowKey.compareTo(x.key);
        int cmpHigh = highKey.compareTo(x.key);
        
        if (cmpLow < 0) {
            keys(x.left, queue, lowKey, highKey);
        }
        if (cmpLow <= 0 && cmpHigh >= 0) {
            queue.enqueue(x.key);
        }
        if (cmpHigh > 0) {
            keys(x.right, queue, lowKey, highKey);
        }
    }
}


```


### 4.4 红黑二叉查找树(RedBlackBST)
```java
package ds.impl;
import java.util.NoSuchElementException;

public class RedBlackBST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private boolean isRed;
        private int size;
        public Node(K key, V value, boolean isRed, int size) {
            this.isRed = isRed;
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    private boolean isRed(Node x) {
        return x == null ? false : x.isRed;
    }
    private int size(Node x) {
        return x == null ? 0 : x.size;
    }
    public int size() {
        return size(root);
    }
    public boolean isEmpty() {
        return root == null;
    }
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }
    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
//        while (x != null) {
//            int cmp = key.compareTo(x.key);
//            if (cmp < 0) {
//                x = x.left;
//            } else if (cmp > 0) {
//                x = x.right;
//            } else {
//                return x.value;
//            }
//        }
//        return null;
    }
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    private void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (!containsKey(key)) {
            return;
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.isRed = true;
        }
        root = delete(root, key);
        if (!isEmpty()) {
            root.isRed = false;
        }
    }
    private Node delete(Node x, K key) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            if (!isRed(x.left) && !isRed(x.left.left)) {
                x = moveRedLeft(x);
            }
            x.left = delete(x.left, key);
        } else {
            if (isRed(x.left)) {
                x = rotateRight(x);
            }
            if (key.compareTo(x.key) == 0 && x.right == null) {
                return null;
            }
            if (!isRed(x.right) && !isRed(x.right.left)) {
                x = moveRedRight(x);
            }
            if (key.compareTo(x.key) == 0) {
                Node rightMinNode = min();
                x.key = rightMinNode.key;
                x.value = rightMinNode.value;
                x.right = deleteMin(x.right);
            } else {
                x.right = delete(x.right, key);
            }
        }
        return balance(x);
    }
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        root.isRed = false;
    }
    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, true, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        } else if (isRed(x.left) && !isRed(x.right)) {
            x = rotateRight(x);
        } else if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node rotateLeft(Node x) {
        Node result = x.right;
        x.right = result.left;
        result.left = x;
        result.isRed = result.left.isRed;
        result.left.isRed = true;
        result.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return result;
    }
    private Node rotateRight(Node x) {
        Node result = x.left;
        x.left = result.right;
        result.right = x;
        result.isRed = result.right.isRed;
        result.right.isRed = true;
        result.size = x.size;
        x.size = size(x.left) + size(x.right) + 1;
        return result;
    }
    private void flipColors(Node x) {
        x.isRed = !x.isRed;
        x.left.isRed = !x.left.isRed;
        x.right.isRed = !x.right.isRed;
    }
    private Node moveRedLeft(Node x) {
        flipColors(x);
        if (isRed(x.right.left)) {
            x.right = rotateRight(x.right);
            x = rotateLeft(x);
            flipColors(x);
        }
        return x;
    }
    private Node moveRedRight(Node x) {
        flipColors(x);
        if (isRed(x.left.left)) {
            x = rotateRight(x);
            flipColors(x);
        }
        return x;
    }
    private Node min() {
        throw new UnsupportedOperationException();
    }
    private Node deleteMin(Node right) {
        throw new UnsupportedOperationException(); 
    }
    private Node balance(Node x) {
        if (isRed(x.right)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + mathMax(height(x.left), height(x.right));
    }
    private int mathMax(int a, int b) {
        return a > b ? a : b;
    }
    public K minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return minKey(root).key;
    }
    private Node minKey(Node x) {
        return x.left == null ? x : minKey(x.left);
    }
    public K maxKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return maxKey(root).key;
    }
    private Node maxKey(Node x) {
        return x.right == null ? x : maxKey(x.right);
    }
    public Iterable<K> keys() {
        if (isEmpty()) {
            return new LinkedQueue<K>();
        }
        return keys(minKey(), maxKey());
    }
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null) {
            throw new IllegalArgumentException("first argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("second argument to keys() is null");
        }
        LinkedQueue<K> queue = new LinkedQueue<>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }
    private void keys(Node x, LinkedQueue<K> queue, K lo, K hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }
    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<>();
        for (int i = 0; i < 100000; i++) {
            String key = "key" + i;
            Integer value = (int) (Math.random() * 10000);
            st.put(key, value);
        }
        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println();
    }
}


```

### 4.5 B-树(BTree)
```java
package ds.impl;
import ds.Container;

public class BTree<K extends Comparable<K>, V> implements Container {
    private static final int M = 4;
    private Node root;
    private int height;
    private int size;
    private static class Node {
        private int m;
        private final Entry[] children = new Entry[M];
        public Node(int k) {
            m = k;
        }
    }
    private static class Entry {
        private Comparable key;
        private final Object value;
        private Node next;
        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public BTree() {
        root = new Node(0);
    }
    @Override
    public int size() {
        return size;
    }
    public int height() {
        return height;
    }
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return search(root, key, height);
    }
    private V search(Node node, K key, int height) {
        Entry[] children = node.children;
        if (height == 0) {
            for (int i = 0; i < node.m; i++) {
                if (eq(key, children[i].key)) {
                    return (V) children[i].value;
                }
            }
        } else {
            for (int i = 0; i < node.m; i++) {
                if (i + 1 == node.m || less(key, children[i + 1].key)) {
                    return search(children[i].next, key, height - 1);
                }
            }
        }
        return null;
    }
    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node u = insert(root, key, value, this.height);
        size++;
        if (u == null) {
            return;
        }
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }
    private Node insert(Node node, K key, V value, int height) {
        int i;
        Entry entry = new Entry(key, value, null);
        if (height == 0) {
            for (i = 0; i < node.m; i++) {
                if (less(key, node.children[i].key)) {
                    break;
                }
            }
        } else {
            for (i = 0; i < node.m; i++) {
                if ((i + 1 == node.m) || less(key, node.children[i + 1].key)) {
                    Node next = node.children[i++].next;
                    Node u = insert(next, key, value, height - 1);
                    if (u == null) {
                        return null;
                    }
                    entry.key = u.children[0].key;
                    entry.next = u;
                    break;
                }
            }
        }
        for (int j = node.m; j > i; j--) {
            node.children[j] = node.children[j - 1];
        }
        node.children[i] = entry;
        node.m++;
        if (node.m < M) {
            return null;
        } else {
            return split(node);
        }
    }
    private Node split(Node node) {
        int m = M / 2;
        Node result = new Node(m);
        node.m = m;
        for (int j = 0; j < m; j++) {
            result.children[j] = node.children[m + j];
        }
        return result;
    }
    @Override
    public String toString() {
        return toString(root, height, "") + "\n";
    }
    private String toString(Node node, int height, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = node.children;
        if (height == 0) {
            for (int j = 0; j < node.m; j++) {
                s.append(indent)
                        .append(children[j].key)
                        .append('=')
                        .append(children[j].value)
                        .append('\n');
            }
        } else {
            for (int j = 0; j < node.m; j++) {
                if (j > 0) {
                    s.append(indent)
                            .append('(')
                            .append(children[j].key)
                            .append(')')
                            .append('\n');
                }
                s.append(toString(children[j].next, height - 1, indent + "#"));
            }
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        BTree<String, String> st = new BTree<>();
        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");
        System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
        System.out.println("apple.com:         " + st.get("www.apple.com"));
        System.out.println("ebay.com:          " + st.get("www.ebay.com"));
        System.out.println("dell.com:          " + st.get("www.dell.com"));
        System.out.println();
        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }
}


```

## 5 图

### 5.1 无向图(Graph)
```java
package ds.impl;

public class Graph {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedBag<Integer>[] adj;
    public Graph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException();
        }
        this.V = V;
        this.E = 0;
        adj = (LinkedBag<Integer>[]) new LinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedBag<>();
        }
    }
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++) {
            LinkedStack<Integer> reverse = new LinkedStack<>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException();
        }
    }
    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        E++;
        adj[v1].add(v2);
        adj[v2].add(v1);
    }
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("V=").append(V).append(", E=").append(E).append(NEW_LINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEW_LINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
    }
}


```

### 5.2 有向图(Digraph)
```java
package ds.impl;

public class Digraph {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private LinkedBag<Integer>[] adj;
    private int[] indegree;
    public Digraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException();
        }
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedBag<Integer>[]) new LinkedBag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedBag<>();
        }
    }
    public Digraph(Digraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < V; v++) {
            this.indegree[v] = G.indegree[v];
        }
        for (int v = 0; v < G.V(); v++) {
            LinkedStack<Integer> reverse = new LinkedStack<>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException();
        }
    }
    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        adj[v1].add(v2);
        indegree[v2]++;
        E++;
    }
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    public Digraph reverse() {
        Digraph result = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                result.addEdge(w, v);
            }
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("V=").append(V).append(", E=").append(E).append(NEW_LINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEW_LINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Digraph g = new Digraph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
    }
}


```

 

## 6 贪心
### 6.1 Dijkstra算法-单元最短路径
#### 6.1.1 问题描述
> 给定一个有向带权图 `G=(V，E)`，其中每条边的权是一个非负实数。另外，给定 `V` 中的一个顶点，称为源点。现在要计算从源点到所有其它各个顶点的最短路径长度，这里的路径长度是指路径上经过的所有边上的权值之和。
#### 6.1.2 贪心策略
**Dijkstra算法思想:** 按各个顶点与源点之间路径长度的递增次序，生成源点到各个顶点的最短路径的方法，即先求出长度最短的一条路径，再参照它求出长度次短的一条路径，依此类推，直到从源点到其它各个顶点的最短路径全部求出为止。
#### 6.1.3 算法设计
- 源点u 。集合S中的顶点到源点的最短路径的长度已经确定，集合V-S中所包含的顶点到源点的最短路径的长度待定。
- 特殊路径：从源点出发只经过S中的点到达V-S中的点的路径。 
- 贪心策略：选择特殊路径长度最短的路径，将其相连的V-S中的顶点加入到集合S中。
**求解步骤:**
- 步骤1：设计合适的数据结构。带权邻接矩阵C，即如果< u, x >E，令 `C[u][x]=<u, x >` 的权值，否则，`C[u][x]=无穷`；采用数组dist来记录从源点到其它顶点的最短路径长度；采用数组p来记录最短路径；
- 步骤2：初始化。令集合S={u}，对于集合V-S中的所有顶点x，设置`dist[x]=C[u][x]` ；如果顶点i与源点相邻，设置 `p[i]=u` ，否则 `p[i]=-1`；
- 步骤3：在集合V-S中依照贪心策略来寻找使得dist[x]具有最小值的顶点t，t就是集合V-S中距离源点u最近的顶点。
- 步骤4：将顶点t加入集合S中，同时更新集合V-S；
- 步骤5：如果集合V-S为空，算法结束；否则，转步骤6；
- 步骤6：对集合V-S中的所有与顶点t相邻的顶点x，如果`dist[x]>dist[t]+C[t][x]`，则`dist[x]=dist[t]+C[t][x]`并设置`p[x]=t`。转步骤3。
#### 6.1.4 示例
```java
public class Dijkstra {
    private static final int N = Integer.MAX_VALUE;
    private static final int[][] Graph = {
        {0, 1, 5, N, N, N, N, N, N},
        {1, 0, 3, 7, 5, N, N, N, N},
        {5, 3, 0, N, 1, 7, N, N, N},
        {N, 7, N, 0, 2, N, 3, N, N},
        {N, 5, 1, 2, 0, 3, 6, 9, N},
        {N, N, 7, N, 3, 0, N, 5, N},
        {N, N, N, 3, 6, N, 0, 2, 7},
        {N, N, N, N, 9, 5, 2, 0, 4},
        {N, N, N, N, N, N, 7, 4, 0}};
    public static void main(String[] args) {
        dijkstra(0, Graph);
    }
    /**
     * Dijkstra最短路径。 即图中"节点vs"到其它各个节点的最短路径。
     *
     * @param vs 起始节点
     * @param Graph 图
     */
    public static void dijkstra(int vs, int[][] Graph) {
        int NUM = Graph[0].length;
        // 前驱节点数组
        int[] prenode = new int[NUM];
        // 最短距离数组
        int[] mindist = new int[NUM];
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
        int vnear = 0;
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = i;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
        find[vs] = true;
        for (int v = 1; v < Graph.length; v++) {
            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;
            // 根据vnear修正vs到其他所有节点的前驱节点及距离
            for (int k = 0; k < Graph.length; k++) {
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) {
                    prenode[k] = vnear;
                    mindist[k] = min + Graph[vnear][k];
                }
            }
        }
        for (int i = 0; i < NUM; i++) {
            System.out.println("v" + vs + "...v" + prenode[i] + "->v" + i + ", s=" + mindist[i]);
        }
    }
    
}
```

## 7 动态规划
### 7.1 最长公共子序列问题
```java
package net.zhaoxuyang.common.algorithm.dp;
/**
 * 最长公共子序列
 *
 * @author zhaoxuyang
 */
public class LastestCommonSequence {
    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        int m = x.length();
        int n = y.length();
        int[][] c = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];
        lscLength(x.toCharArray(), y.toCharArray(), c, b);
//        for (int i = 0; i <= x.length(); i++) {
//            for (int j = 0; j <= y.length(); j++) {
//                System.out.print(b[i][j]+" ");
//            }
//            System.out.println();
//        }
        lcs(x.length(), y.length(), x.toCharArray(), b);
    }
    /**
     * <pre>
     * ------------------------------------------------------------
     *          = 0                             i=0 || j=0
     * c[i][j]  = c[i-1][j-1]+1                 i,j>0 && x[i]=y[j]
     *          = max(c[i][j-1],c[i-1][j])      i,j>0 && x[i]!=y[j]
     *
     * b[i][j]=1 表示c[i][j]由c[i-1][j-1]+1 得到
     * b[i][j]=2 表示c[i][j]由c[i][j-1]     得到
     * b[i][j]=3 表示c[i][j]由c[i-1][j]     得到
     * ------------------------------------------------------------
     * i行j列，初始时c[i][0]=0,c[0][j]=0
     *     B D C A B A
     *   0 0 0 0 0 0 0
     * A 0
     * B 0
     * C 0
     * B 0
     * D 0
     * A 0
     * B 0
     * ------------------------------------------------------------
     * </pre>
     *
     * @param x X序列
     * @param y Y序列
     * @param c 存入最优值
     * @param b 存入最优值的来源
     */
    private static void lscLength(char[] x, char[] y, int[][] c, int[][] b) {
        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 3;
                }
            }
        }
    }
    /**
     * 根据记录下的信息构造最优解
     */
    private static void lcs(int i, int j, char[] x, int[][] b) {
        if (i == 0 || j == 0) {
            return;
        }
        switch (b[i][j]) {
            case 1:
                lcs(i - 1, j - 1, x, b);
                visit(x[i - 1]);
                break;
            case 2:
                lcs(i, j - 1, x, b);
                break;
            default:
                lcs(i - 1, j, x, b);
                break;
        }
    }
    /**
     * 如何处理最优解，例如打印，或者添加到StringBuilder中
     * @param c 
     */
    private static void visit(char c) {
        System.out.print(c);
    }
}


```

### 7.2 0-1背包问题
```java
package net.zhaoxuyang.common.algorithm.dp;
import java.util.Arrays;
/**
 * 0-1 背包问题
 *
 * <pre>
 * n个物品和1个背包，对物品i，价值为v[i]，重量为w[i]，背包容量为W，如何装入使得总价值最大:
 * - w[i]x[i]小于等于W
 * - x[i]∈{0,1}
 * - 目标函数为max(v[i]x[i])
 * - 其中i∈[1,n]
 *
 * 假如(x[1], x[2], x[3], ..., x[n])是最优解，
 * 那么(x[2], x[3], ..., x[n])则是以下问题的一个最优解：
 * - w[i]x[i] 小于等于 W - w[1]x[1]
 * - x[i]∈{0,1}
 * - 目标函数为max(v[i]x[i])
 * - 其中i∈[2,n]
 *
 * </pre>
 *
 * 时间复杂度为O(nW)
 * 缺点：要求w数组中的元素为整数；当W>2^n时，时间复杂度为O(n2^n)
 * @author zhaoxuyang
 */
public class KnapSack {
    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int W = 10;
        byte[] result = fun(w, v, W);
        System.out.println(Arrays.toString(result));
    }
    /**
     *
     * <pre>
     * 数组c[w.length+1][W+1]存放每次迭代的执行结果
     * 数组x[w.length]存放所装入的背包的物品状态
     * @初始化 c[0][j] = c[i][0] = 0
     * 
     * @递归式 c[i][j]  = c[i-1][j] j 小于 w[i] 
     *                  = max{c[i-1][j],c[i-1][j-w[i]]+v[i]} j大于等于w[i]
     * </pre>
     * @param w 重量
     * @param v 价值
     * @param W 容量
     * @return 最优解
     */
    private static byte[] fun(int[] w, int[] v, int W) {
        int row = w.length;
        int col = W;
        byte[] x = new byte[row];
        int[][] c = new int[row + 1][col + 1];
        //存放各个子问题的最优值
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (j < w[i - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    int tmp = c[i - 1][j - w[i - 1]] + v[i - 1];
                    c[i][j] = Math.max(c[i - 1][j], tmp);
                }
            }
        }
        
        //构造最优解
        for (int i = row, j = col; i > 0; i--) {
            if (c[i][j] > c[i - 1][j]) {
                x[i - 1] = 1;
                j -= w[i - 1];
            }
        }
        return x;
    }
}


```

### 7.3 加工顺序问题
```java
package net.zhaoxuyang.common.algorithm.dp;
import java.util.ArrayList;
import java.util.List;
/**
 * 加工顺序
 * 先a后b的加工顺序，给定a和b各工件的耗时，求加工耗时最短的序列。
 * 解法：
 * 1. 求a中小于b的位置组g1：1,4,6；a中大于等于a的位置组g2：2,3,5,7
 * 2. 对g1非减序排序，对g2非增序排序
 * 3. 将g1连接上g2
 * @author zhaoxuyang
 */
public class ProcessingSquence {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,6,9,15};
        int[] b = {7,2,6,18,3,10,4};
        
         List<Integer> result = flowShop(a,b);
         System.out.println(result);
    }
    private static List<Integer> flowShop(int[] a, int[] b) {
        int len = a.length;
        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(a[i]<b[i]){
                g1.add(a[i]);
            }else{
                g2.add(b[i]);
            }
        }
        g1.sort((left,right)->{
            return left-right;
        });
        g2.sort((left,right)->{
            return right-left;
        });
        g1.addAll(g2);
        return g1;
    }
}


```

## 8 搜索法

### 8.1 图的着色问题
```java
package net.zhaoxuyang.common.algorithm.search;
/**
 * 图的m着色问题
 * @author zhaoxuyang
 */
public class MColoring {
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] a = {
            {-1, -1, -1, -1, -1, -1},
            {-1, 0, 1, 1, 1, 0},
            {-1, 1, 0, 1, 1, 1},
            {-1, 1, 1, 0, 1, 0},
            {-1, 1, 1, 1, 0, 1},
            {-1, 0, 1, 0, 1, 0}
        };
        MColoring c = new MColoring();
        long sum = c.coloring(m, n, a);
        System.out.println(sum);
    }
    int n; // 图的顶点数
    int m; // 可用的颜色数
    int[][] a;//图的邻接矩阵
    int[] x;//当前解
    long sum;//当前已找到的可m着色方案数
    public long coloring(int m, int n, int[][] a) {
        this.n = n;
        this.a = a;
        x = new int[n + 1];
        this.m = m;
        sum = 0;
        backtrack(1);
        return sum;
    }
    private void backtrack(int t) {
        if (t > n) {
            sum++;
            for (int i = 1; i <= n; i++) {
                visit(x[i]);
            }
            System.out.println();
        } else {
            for (int i = 1; i <= m; i++) {
                x[t] = i;
                if (ok(t)) {
                    backtrack(t + 1);
                }
                x[t] = 0;
            }
        }
    }
    private void visit(int item) {
        System.out.printf("%d ", item);
    }
    private boolean ok(int k) {
        for (int j = 1; j <= n; j++) {
            if (a[k][j] == 1 && x[j] == x[k]) {
                return false;
            }
        }
        return true;
    }
}


```

### 8.2 深度优先搜索

```c++
bool Visited[n + 1];
for(int i = 1; i <= n; i++){
    Visited[i] = 0;
}
//从顶点k出发进行深度优先搜索
void Dfsk(int k){
    Visited[k] = 1;
    for(int j = 1; j <= n; j++){
        if(c[k][j] == 1 && Visited[j] == 0){
            Dfsk(j);
        }
    }
}
//深度优先搜索整个图
void Dfs(){
    for(int i = 1; i <= n; i++){
        if(Visited[i] == 0){
            Dfsk(i);
        }
    }
}
```
### 8.3 回溯法
#### 8.3.1 回溯法的算法框架
为定义搜索范围，应明确以下几个方面：
1. 问题解的形式：表示成一个n元组的形式`(x[0],x[1],...,x[n-1])`
2. 显约束：对分量`x[i]`的取值范围限定。
3. 隐约束：为满足问题的解而对不同分量之间施加的约束。
4. 解空间：对于问题的一个实例，解向量满足显约束的所有n元组构成了该实例的一个解空间。
----
在搜索的过程中，应了解几个名词：
1. 扩展结点：一个正在生成孩子的结点。
2. 活结点：一个自身已生成但其孩子还没有全部生成的结点。
3. 死结点：一个所有孩子已生成的结点。
----
求解过程：
1. 定义问题的解空间。
2. 确定空间的组织结构。
3. 搜索解空间：
    - 确定约束条件
    - 确定限界条件
    - 搜索过程
----

算法描述：
> (1)递归形式
```c++
// t为扩展节点在树中所处的层次
void Backtrack(int t){
    if(t > n){
        //搜索层次大于解空间的树的深度，说明找到了叶子结点，即找到了问题的一个解
        output(x);
    } else {
        for (int i = s(n, t); i <= e(n, t); i++){
            x[t] = d(i);
            if(constraint(t) && bound(t)){
                Backtrack(t + 1);
            }
        }
    }
}
```
> (2)非递归形式
```c++
void NBacktrack(){
    int t = 1;
    while(t > 0){
        if(s(n,t) <= e(n, t)){
            for(int i = s(n, t); i <= e(n,t); i++){
                x[t] = d(i);
                if(constraint(t) && bound(t)){
                    if(t > n){
                        output(x);
                    } else {
                        t++;
                    }
                }
            }
        } else {
            t--;
        }
    }
}
```
#### 8.3.2 子集树
> 当所给问题是从n个元素组成的集合S中找出满足某一性质的一个子集时，相应的解空间树称为子集树。
- 0-1 背包问题
- 子集和问题
- 装载问题
- 最大团问题
算法描述：
```c++
//x用来存放当前解，constraint()为约束函数，bound()为限界函数
void Backtrack(int t){
    if(t > n){
        output(x);
    }
    //判断能否沿着扩展结点的左分支进行扩展
    if(constraint(t)){
        //做相关标识
        Backtrack(t + 1);
        //做相关标识的反操作
    }
    //判断能否沿着扩展结点的右分支进行扩展
    if(bount(t)){
        //做相关标识
        Backstrack(t + 1);
        //做相关标识的反操作
    }
}
```
#### 8.3.3 排列树

> 当所给的问题是从n个元素的排列中找出满足某种性质的一个排列时，相应的解空间称为排列树。
- n皇后问题
- 旅行商问题
- 批处理作业调度问题
- 圆排列问题
- 电路板排序问题
算法描述：
```c++
void Backtrack(int t){
    if(t > n){
        output(x);
    } else {
        for(int i = t; i <= n; i++){
            swap(x[t], x[i]);
            if(constraint(t) && bound(t)){
                Backtrack(t + 1);
            }
            swap(x[t], x[i]);
        }
    }
}
```
#### 8.3.4 满m叉树(组合树)
> 当所给问题的n个元素中每一个元素均有m种选择，要求确定其中的一种选择，
> 使得对这n个元素的选择结果组成的向量满足某种性质，即寻找满足某种特性的n个元素取值的一个组合。
> 这类问题的解空间称为满m叉树。
- n皇后问题
- 图的m着色问题
- 最小机器设计问题
算法描述：
```c++
void Backtrack(int t){
    if(t > n) {
        output(x);
    } else {
        for (int i = 1; i <= m; i++) {
            if (constraint(t) && bound(t)) {
                x[t] = i;
                //做其他相关标识
                Backtrack(t + 1);
                //做其他相关标识的反操作，退出相关标识
            }
        }
    }
}
```
### 8.4 广度优先搜索

算法描述：
```c++
bool Visited[n + 1];
for(int i = 1; i <= n; i++){
    Visited[i] = 0;
}
void BFSVO(int v0){
    int w;
    visit(v0);
    Visited[v0] = 1;
    InitQueue(&Q);
    InsertQueue(&Q, v0);
    while(!Empty(Q)){
        DeleteQueue(&Q, &v);
        for(int i = 1; i <= n; i++) {
            if(g[v][i] != 0){
                w = i;
            }
            if(!Visited(w)){
                visit(w);
                Visited[w] = 1;
                InsertQueue(&Q, w);
            }
        }
    }
}
BFS(){
    for(int i = 1; i <= n; i++) {
        if(Visited[i] = 0){
            BFSVO(i);
        }
    }
}
 
```
### 8.5 分支限界法

> 分支限界发先将根结点加入活结点表，接着从活结点表中取出根结点，使其成为当前扩展结点，
> 一次性生成所有孩子结点，判断孩子结点是舍弃还是保留，舍弃那些导致可行解或者导致非最优解的孩子结点，
> 其余的被保留在活结点表中。
> 再从活结点表中取出一个活结点，重复上述过程。
> 解题步骤：
1. 定义问题的解空间
2. 确定问题的解空间组织结构(树或图)
3. 搜索解空间。搜索要定义判断标准(约束函数或限界函数)，如果选用优先队列，需确定优先级。


## 9 随机化算法
> 随机化算法分类：
- 数值随机化算法：在原理上可能就不存在精确解，或者无法在可行时间内求得，因此用该算法得到相当满意的解。
- 蒙特卡罗算法：能求得问题的一个解，但这个解未必是正确的。
- 拉斯维加斯算法：绝不返回错误的解，但有时可能找不到解。
- 舍伍德算法：当一个确定性算法在最坏与平均情况时间复杂度相差较大时，引入随机性来降低最坏情况出现的概率，不会改变结果。


### 9.1 数值随机化算法

```java
package net.zhaoxuyang.common.algorithm.random;
/**
 * 数值随机化算法
 *
 * @author zhaoxuyang
 */
public class Numerical {
    public static void main(String[] args) {
        System.out.println(calculatePI(1));
        System.out.println(calculatePI(10));
        System.out.println(calculatePI(100));
        System.out.println(calculatePI(1000));
        System.out.println(calculatePI(100000));
        System.out.println(calculatePI(1000000));
        System.out.println(calculatePI(10000000));
        System.out.println(calculatePI(100000000));
        
        
        System.out.println(calculateDefiniteIntegral(100000000));
    }
    /**
     * 计算π的值
     * @param n
     * @return 
     */
    static double calculatePI(int n) {
        double x;
        double y;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x * x + y * y) <= 1) {
                k++;
            }
        }
        return 4.0 * k / n;
    }
    /**
     * 计算定积分(y=x^2)
     * @param n
     * @return 
     */
    static double calculateDefiniteIntegral(int n) {
        int k = 0;
        double x;
        double y;
        for (int i = 0; i <= n; i++) {
            x = Math.random();
            y = Math.random();
            double fx = 2 * x;
            if (y <= fx) {
                k++;
            }
        }
        return 1.0 * k / n;
    }
}


```

### 9.2 蒙特卡罗算法
```java
package net.zhaoxuyang.common.algorithm.random;
/**
 * 
 * 蒙特卡罗算法
 * <pre>
 * 设p是一个实数，且 0.5 小于 p 小于 1， 
 * 如果蒙特卡罗算法对于问题的任一实例得到的正确解的概率不小于p，则称该算法是正确的。
 * </pre>
 * @author zhaoxuyang
 */
public class MonteCarlo {
    public static void main(String[] args) {
        //int[] array = {1, 2, 1};
//                System.out.println(majority(array, array.length, 0.99));
//        System.out.println(majority(array, array.length, 0.99));
        System.out.println(checkPrimeByWilson(5));
        System.out.println(checkPrimeByWilson(6));
        while(true){
            System.out.println(checkPrimeByMoteCarlo(97));
}
        
    }
    /**
     * 判断一个数组是否存在主元素 一个含有n个元素的数组，当存在一个元素占比大于n/2时，称该元素是数组的主元素。
     */
    static boolean majority(int[] array, double n, double p) {
        int k = (int) Math.ceil(Math.log(n) / Math.log(1 - 0.9));
        for (int i = 1; i <= k; i++) {
            if (checkMajority(array, n)) {
                System.out.println(array[i]);
                return true;
            }
        }
        return false;
    }
    static boolean checkMajority(int[] array, double n) {
        int randomIndex = (int) (Math.random() * n);
        int item = array[randomIndex];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (item == array[i]) {
                k++;
            }
        }
        return (k > 1.0 * n / 2);
    }
    /**
     * 常规的判断一个数是否为素数
     *
     * @param n
     * @return
     */
    boolean checkPrime(long n) {
        int m = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 
     * <pre>
     * Wilson定理有很高的理论价值，定义为：对于给定的正整数n，判定n是素数的充要条件是：
     * (n-1)! === -1(mod n)
     * 例如n = 5,6,7
     * (5-1)!=24,       24 mod 5    = -1(mod 5)，故5是素数
     * (6-1)!=120,      120 mod 6   = 0(mod 6)，故6不是素数
     * (7-1)!=720,      720 mod 7   = -1(mod 7)，故6不是素数
     * 
     * </pre>
     * @param n
     * @return 
     */
    static boolean checkPrimeByWilson(long n) {
        return fan(n - 1) % n == n - 1;
    }
    static long fan(long n) {
        return n == 0 ? 1 : n * fan(n - 1);
    }
    
    static boolean checkPrimeByMoteCarlo(int n){
        int m = (int) Math.floor(Math.sqrt(n));
       
        int min = 2;
        int max = m - 1;
        int i = (int)(Math.random()*(max-min+1)+min);
        System.out.println(i);
        return n % i != 0;
    }
}
```

### 9.3 拉斯维加斯算法
```java
package net.zhaoxuyang.common.algorithm.random;
/**
 *
 * 拉斯维加斯算法
 *
 * <pre>
 * void RLV(Type x, Type &y){
 *     bool success = fasle;
 *     while(!success){
 *         success = RLV(x, y);
 *     }
 * }
 * </pre>
 *
 * @author zhaoxuyang
 */
public class LasVegas {
    public static void main(String[] args) {
        split(182);
    }
    
    static void pollard(int n) {
        int i = 1;
        int x = (int) (Math.random() * n +1);
        int y = x;
        int k = 2;
        while (true) {
            i++;
            x = (x * x - 1) % n;
            int d = gcd(y - x, n);
            if ((d > 1) && (d < n)) {
                System.out.print(d + " ");
            }
            if (i == k) {
                y = x;
                k *= 2;
            }
        }
    }
    /**
     * 整数因子分解
     */
    static void split(int n) {
        int k = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
```

### 9.4 舍伍德算法

```java
package net.zhaoxuyang.common.algorithm.random;
import java.util.Arrays;
import net.zhaoxuyang.common.algorithm.other.QuickSort;
import net.zhaoxuyang.common.algorithm.other.Shuffle;
/**
 *
 * 舍伍德算法
 * @author zhaoxuyang
 */
public class Sherwood {
    
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,7,6};
        randomQuickSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 打乱顺序，再排序
     * @param array 
     */
    static void randomQuickSort(int[] array){
        Shuffle.shuffle(array);
        QuickSort.quickSort(array);
    }
}


```

## 10 数论算法

### 10.1 Stein求最大公约数

```java
package net.zhaoxuyang.common.algorithm.math;
/**
 *
 * @author zhaoxuyang
 */
public class Stein {
    public static void main(String[] args) {
        System.out.println(gcd(2412122241212121212L, 2131424432543544656L));
    }
    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a % 2 == 0 && b % 2 == 0) {
            return 2 * gcd(a >> 1, b >> 1);
        } else if (a % 2 == 0) {
            return gcd(a >> 1, b);
        } else if (b % 2 == 0) {
            return gcd(a, b >> 1);
        } else {
            return gcd(Math.abs(a - b), Math.min(a, b));
        }
    }
}


```

### 10.2 矩阵求斐波那切数列
```java
package net.zhaoxuyang.common.algorithm.other;
/**
 * 暴力递归，记忆搜索，矩阵求法，流处理求斐波那契数列
 * 结论：
 * （1）流处理并没有想象中的快
 * （2）暴力递归效率及其低下，N稍微大点（40左右）就已经算不出结果
 * （3）矩阵求法并没有记忆搜索快，但是在计算量较大的【别的程序】中却是最快的
 */
import java.util.stream.Stream;
/**
 *
 * @author zhaoxuyang
 */
public class Fibonacci {
    public static void main(String[] args) throws InterruptedException {
        int n = 50;
        int res;
        long start;
//        start = System.nanoTime();
//        res = f1(n);
//        System.out.println(res);
//        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        res = f2(n);
        System.out.println(res);
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        res = f3(n);
        System.out.println(res);
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        res = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .skip(n)
                .map(t -> t[0])
                .findFirst()
                .get();
        System.out.println(res);
        System.out.println(System.nanoTime() - start);
        /*
        n=20时，输出
6765
705588
6765
21391
6765
38888
6765
72026229
        
        n=100时，注释掉O(2^N)的第一段因为要很久时间，所以后三个的输出
 -980107325
166519
-980107325
43165
-980107325
72650035
         */
    }
    /**
     * O(2^N)
     *
     * @param n
     * @return
     */
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return f1(n - 1) + f1(n - 2);
        }
    }
    /**
     * 记忆搜索 O(N)
     *
     * @param n
     * @return
     */
    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    /**
     * 矩阵求法 O(logN)
     * <pre>
     * 如果递归式严格遵循F(N)=F(N-1)+F(N-2)，
     * 对于求第N项值，有矩阵乘法的方式可以将时间复杂度降至O(ogN)
     * 二阶递推数列，状态矩阵为2*2的矩阵：
     *
     * (F(n),F(n-1)) = (F(n-1),F(n-2)) * | a b |
     *                                   | c d |
     * 斐波那契数列的前4项代入求出状态矩阵：
     * | a b |     | 1 1 |
     * | c d |  =  | 1 0 |
     *
     * (F(n),F(n-1)) = (F(n-1), F(n-2)) * | 1 1 | = (1,1) * | 1 1 |^(n-2)
     *                                         | 1 0 |           | 1 0 |
     * 问题变成求矩阵N次方
     * 以整数10的75次方为例：
     * 75的二进制为1001011，则10的75次方=10^64 * 10^8 * 10^2 * 10^1
     * 把累乘的值相乘即可
     *
     * 对于矩阵，求矩阵m的p次方请参看matrixPower方法，其中muliMatrix是两个矩阵相乘的具体实现
     * </pre>
     *
     * @param n
     * @return
     */
    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }
    /**
     * @param m
     * @param p
     * @return
     */
    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }
    private static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}


```
 
