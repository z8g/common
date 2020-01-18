package offer;

/**
 * 删除链表的节点(要求O(1)时间复杂度)
 *
 * @author zhaoxuyang
 */
public class Exp18 {

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node head = new Node(0, null);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        head.next = node1;
        System.out.println(head);

        delete(head, node2);
        
        System.out.println(head);
    }

    private static boolean delete(Node head, Node node) {
        if (head == null || node == null) {
            return false;
        }
        if (node.next == null) {//尾节点
            node = null;
        } else {
            Node nextNode = node.next;
            node.value = nextNode.value;
            node.next = nextNode.next;
            nextNode = null;
        }

        return true;
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
            if (next == null) {
                return "";
            }
            return new StringBuilder().append(value).append(' ')
                    .append(next.toString()).toString();
        }
    }

}
