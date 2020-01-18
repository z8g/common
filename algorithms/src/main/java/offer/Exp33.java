package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author zhaoxuyang
 */
public class Exp33 {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(8,
                new TreeNode(6,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null)
                ),
                new TreeNode(10,
                        new TreeNode(9, null, null),
                        new TreeNode(11, null, null)
                )
        );

        System.out.println(tree.rightOrder());
        int[] rightArr = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] errorArr = new int[]{5, 7, 9, 6, 11, 10, 8};
        System.out.println(cmp(tree, rightArr));
        System.out.println(cmp(tree, errorArr));

    }

    private static boolean cmp(TreeNode tree, int[] arr) {
        if (tree == null || arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = tree.rightOrder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)) {
                return false;
            }
        }
        return true;
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

        List<Integer> rightOrder() {
            List<Integer> list = new ArrayList<>();
            rightOrder(this, list);
            return list;
        }

        private void rightOrder(TreeNode tree, List<Integer> list) {
            if (tree == null) {
                return;
            }
            rightOrder(tree.left, list);
            rightOrder(tree.right, list);
            list.add(tree.value);
        }

    }
}
