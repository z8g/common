package offer;

/**
 * 二叉树的序列化和反序列化
 *
 * @author zhaoxuyang
 */
public class Exp36 {
    
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null
                ),
                new TreeNode(3,
                        new TreeNode(5, null, null),
                        new TreeNode(6, null, null)
                )
        );
        StringBuilder result = new StringBuilder();
        write(tree, result, ',', '#');
        System.out.println(result);
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
    
    private static void write(TreeNode node, StringBuilder s, char splitChar, char nullChar) {
        if (node == null) {
            s.append(nullChar).append(splitChar);
            return;
        }
        s.append(node.value).append(splitChar);
        write(node.left, s, splitChar, nullChar);
        write(node.right, s, splitChar, nullChar);
    }
}
