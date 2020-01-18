package offer;

/**
 * 链表中环的入口节点
 *
 * @author zhaoxuyang
 */
public class Exp23 {

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

        // 环
        node8.next = node3;
        Node door = findDoor(head);
        System.out.println(door.value);
    }

    private static Node findDoor(Node head) {
        if (head == null || !check(head)) {
            throw new IllegalArgumentException();
        }

        int s1 = 0; //第一次相遇时的步数
        int s2 = 0; //第二次相遇时的步数

        int count = 0;
        int step = 0;// 要求相遇两次
        Node fast = head;
        Node slow = head;
        while (step <= 1) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
            if (fast.value == slow.value) {
                if (step == 0) {
                    s1 = count;
                } else if (step == 1) {
                    s2 = count;
                }
                step++;
            }
        }
        int size = s2 - s1; // 环的长度
        //两个指针以相同速度走，p1先走size步，必定在入口相遇
        Node p1 = head;
        Node p2 = head;
        while (size-- > 0) {
            p1 = p1.next;//p1先走size步
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        throw new java.util.NoSuchElementException();
    }

    private static boolean check(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && slow != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast.value == slow.value) {
                    return true;
                }
            }
        }
        return false;
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
