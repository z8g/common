package offer;

/**
 * 树的子结构
 *
 * @author zhaoxuyang
 */
public class Exp26 {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(8,
                new TreeNode(8,
                        new TreeNode(9, null, null),
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(7, null, null)
                        )
                ),
                new TreeNode(7, null, null)
        );
        TreeNode child = new TreeNode(8,
                new TreeNode(9, null, null),
                new TreeNode(2, null, null)
        );
        System.out.println(contains(parent, child));
    }

    static boolean contains(TreeNode parent, TreeNode child) {
        if (parent == null) {
            return child == null;
        }
        if (child == null) {
            return true;
        }
        
        boolean result = false;
        if (eq(parent.value, child.value)) {
            result = cmp(parent, child);
        }
        if (!result) {
            result = cmp(parent.left, child);
        }
        if (!result) {
            result = cmp(parent.right, child);
        }
        return result;
    }

    private static boolean cmp(TreeNode parent, TreeNode child) {
        if (child == null) {
            return true;
        }
        if (parent == null) {
            return false;
        }
        if (!eq(parent.value, child.value)) {
            return false;
        }
        return cmp(parent.left, child.left) && cmp(parent.right, child.right);
    }

    private static boolean eq(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.000001;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        double value;

        TreeNode(double value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
