package offer;

/**
 * 反转链表
 * @author zhaoxuyang
 */
public class Exp24 {

    // 反转
    private static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    private static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for(Node i = this; i != null; i = i.next){
                s.append(i.value).append(' ');
            }
            return s.toString();
        }
    }
    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node7 = new Node(7, null);
        Node node8 = new Node(8, null);
        node7.next = node8;
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        
        
        System.out.println(head);
        System.out.println(reverse(head));
    }
}
