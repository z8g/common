package offer;

/**
 * 合并两个排序的链表
 *
 * @author zhaoxuyang
 */
public class Exp25 {

    public static void main(String[] args) {
        Node node1 = new Node(0, new Node(3, new Node(5, new Node(8, null))));
        Node node2 = new Node(2, new Node(3, new Node(4, new Node(9, null))));
        Node result = merge(node1, node2);
        System.out.println(result);
    }

    private static Node merge(Node node1, Node node2) {
        if(node1 == null){
            return node2;
        } else if(node2 == null){
            return node1;
        }
        Node result;
        if(node1.value < node2.value){
            result = node1;
            result.next = merge(node1.next, node2);
        } else {
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
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
            for (Node i = this; i != null; i = i.next) {
                s.append(i.value).append(' ');
            }
            return s.toString();
        }
    }

}
