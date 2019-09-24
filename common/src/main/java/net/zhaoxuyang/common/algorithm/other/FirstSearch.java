package net.zhaoxuyang.common.algorithm.other;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author zhaoxuyang
 */
public class FirstSearch {
    public static void main(String[]args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        
        n1.rightNode = n3;
        n1.leftNode = n2;
        
        n2.leftNode = n4;
        n2.rightNode = n5;
        
        n3.leftNode = n6;
        n3.rightNode = n7;
        
        n4.leftNode = n8;
        n4.rightNode = n9;
        
        depthFirstSearch(n1);
    }
    
    public static void broadFirstSearch(TreeNode head){
        if(head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            visit(node);
            if(node.leftNode != null){
                queue.add(node.leftNode);
            }
            if(node.rightNode != null){
                queue.add(node.rightNode);
            }
        }
    }
    
    public static void depthFirstSearch(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            visit(node);
            if(node.rightNode != null){
                stack.push(node.rightNode);
            }
            if(node.leftNode != null){
                stack.push(node.leftNode);
            }
        }
    }

    private static void visit(TreeNode node) {
            System.out.printf("%d ",node.data);
    }
}
