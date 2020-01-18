package offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author zhaoxuyang
 */
public class Exp06 {

    public static void main(String[] args) {
        Node list = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        printByStack(list);
        printBySelf(list);
    }

    private static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static void printByStack(Node head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
    }

    private static void printBySelf(Node head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        print(head);
    }

    private static void print(Node head) {
        if (head == null) {
            return;
        }
        int value = head.value;
        print(head.next);
        System.out.print(value + " ");
    }
}
