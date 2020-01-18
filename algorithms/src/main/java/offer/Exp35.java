package offer;

/**
 * 二叉搜索树转双向链表
 *
 * @author zhaoxuyang
 */
public class Exp35 {

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
        System.out.println(tree.convert().right.value);
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

        TreeNode() {
        }

        TreeNode convert() {
            TreeNode lastNode = new TreeNode();
            convertNode(this, lastNode);
            TreeNode headNode = lastNode;
            while (headNode != null && headNode.left != null) {
                headNode = headNode.left;
            }
            return headNode;
        }

        private void convertNode(TreeNode node, TreeNode lastNode) {
            if (node == null) {
                return;
            }

            TreeNode curNode = node;
            if (curNode.left != null) {
                convertNode(curNode.left, lastNode);
            }
            curNode.left = lastNode;

            if (lastNode != null) {
                lastNode.right = curNode;
            }

            lastNode = curNode;
            if (curNode.right != null) {
                convertNode(curNode.right, lastNode);
            }
        }

    }
}
