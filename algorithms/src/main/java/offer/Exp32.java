package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 从上到下打印二叉树
 *
 * @author zhaoxuyang
 */
public class Exp32 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8,
                new TreeNode(8,
                        new TreeNode(9, null, null),
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(7, null, null)
                        )
                ),
                new TreeNode(7, null, null)
        );
        //tree.print();
        //tree.println();
        tree.printZ();
    }

    static class TreeNode {

        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // 不分层
        public void print() {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 分层打印
        public void println() {
            TreeNode last = this; // 当前行最后一个节点
            TreeNode nextLast = null; // 下一行最后一个节点

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    nextLast = node.right;
                } else if (node.left != null) {
                    nextLast = node.left;
                }
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node == last) {
                    System.out.println();
                    last = nextLast;
                }
            }
        }

        //之字打印
        void printZ() {
            TreeNode root = this;
            int height = 1;

            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                if (height % 2 == 1) { // 奇数层，Stack1从左放到右
                    TreeNode cur = stack1.pop();
                    System.out.print(cur.value + " ");
                    if (cur.left != null)  stack2.push(cur.left);
                    if (cur.right != null) stack2.push(cur.right);
                    if (stack1.isEmpty()) {
                        System.out.println();
                        height++;
                    }
                } else { // 偶数层，Stack2从右放到左
                    TreeNode cur = stack2.pop();
                    System.out.print(cur.value + " ");
                    if (cur.right != null) stack1.push(cur.right);
                    if (cur.left != null)  stack1.push(cur.left);
                    if (stack2.isEmpty()) {
                        System.out.println();
                        height++;
                    }
                }
            }

        }
    }
}
