package offer;

/**
 * 链表中倒数第K个节点
 *
 * @author zhaoxuyang
 */
public class Exp22 {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        System.out.println(tailKth(head, 3).value);
        //System.out.println(tailKth(head, -1).value);
        System.out.println(tailKth(head, 6).value);
    }

    private static Node tailKth(Node head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException();
        }
        Node cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        
        cur = head;//重新遍历
        int count = size - k;
        if (count <= 0) {
            return cur;
        }
        while (count-- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    private static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
