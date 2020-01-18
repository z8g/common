package offer;

/**
 * 对称的二叉树
 *
 * @author zhaoxuyang
 */
public class Exp28 {

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
        TreeNode tree2 = new TreeNode(8,
                new TreeNode(8, null, null),
                new TreeNode(8, null, null)
        );
        System.out.println(isReverse(tree));
        System.out.println(isReverse(tree2));
    }

    private static boolean isReverse(TreeNode tree) {
        if (tree == null) {
            return true;
        }
        if (tree.left == null && tree.right == null) {
            return true;
        }
        if (tree.left.value != tree.right.value) {
            return false;
        }
        return isReverse(tree.left) && isReverse(tree.right);
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
    }
}
