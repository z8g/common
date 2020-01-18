package offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author zhaoxuyang
 */
public class Exp30 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(-2);
        System.out.println(stack.getMin());
    }

    static class MinStack {

        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        int getMin() {
            return minStack.peek();
        }

        void push(int value) {
            if (minStack.isEmpty() || value < minStack.peek()) {
                minStack.push(value);
            } else {
                minStack.push(minStack.peek());
            }
        }
        
        int pop(){
            if(dataStack.isEmpty()){
                throw new java.util.NoSuchElementException();
            }
            minStack.pop();
            return dataStack.pop();
        }
        
        int peek(){
            if(dataStack.isEmpty()){
                throw new java.util.NoSuchElementException();
            }
            return dataStack.peek();
        }
    }
}
