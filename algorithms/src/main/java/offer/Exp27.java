package offer;

/**
 * 二叉树的镜像
 * @author zhaoxuyang
 */
public class Exp27 {
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
        reverse(tree);
        System.out.print(tree.right.left.right.value);
        
    }

    private static void reverse(TreeNode tree) {
        if(tree == null){
            return;
        }
        if(tree.left == null && tree.right == null){
            return;
        }
        TreeNode tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
        
        reverse(tree.left);
        reverse(tree.right);
    }
    
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        TreeNode (int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
