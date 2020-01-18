package offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * @author zhaoxuyang
 */
public class Exp09 {
    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
    static class TwoStackQueue {
        Stack pushStack = new Stack();
        Stack popStack = new Stack();
        public void enqueue(Object data){
            while(!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
            pushStack.push(data);
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        public Object dequeue(){
            return popStack.pop();
        }
        public Object peek(){
            return popStack.peek();
        }
        public boolean isEmpty(){
            return size() == 0;
        }

        private int size() {
            return popStack.size();
        }
    }
}
