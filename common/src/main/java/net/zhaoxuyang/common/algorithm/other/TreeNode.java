package net.zhaoxuyang.common.algorithm.other;

/**
 *
 * @author zhaoxuyang
 */
public class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;
    
    public TreeNode(int data){
        this.data = data;
    }
    public TreeNode(TreeNode left,TreeNode right,int data){
        leftNode = left;
        rightNode = right;
        this.data = data;
    }
    
}
