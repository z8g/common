package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author zhaoxuyang
 */
public class Exp34 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8,
                new TreeNode(6,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null)
                ),
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(11, null, null)
                )
        );
        tree.matchSum(8 + 6 + 5);
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

        private void matchSum(int sum) {
            if (sum < 0) {
                throw new IllegalArgumentException();
            }
            List<Integer> path = new ArrayList<>();
            int count = 0;
            order(this, sum, count, path);
        }

        private void order(TreeNode tree, int sum, int count, List<Integer> path) {
            if (tree == null) {
                return;
            }
            path.add(tree.value);

            if (isLeaf(tree) && (tree.value + count == sum)) {
                System.out.println(path);
                return;
            }
            order(tree.left, sum, count + tree.value, path);
            path.remove(path.size() - 1);
            order(tree.right, sum, count + tree.value, path);
        }

        private boolean isLeaf(TreeNode tree) {
            return tree.left == null && tree.right == null;
        }

    }

}
