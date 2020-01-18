package offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 二叉树的下一个节点
 *
 * @author zhaoxuyang
 */
public class Exp08 {

    public static void main(String[] args) {
        char[] centerOrder = new char[]{'d', 'b', 'h', 'e', 'i', 'a', 'f', 'c', 'g'};
        TreeNode tree = new TreeNode(
                'a',
                new TreeNode('b',
                        new TreeNode('d', null, null),
                        new TreeNode('e', 
                                new TreeNode('h', null, null), 
                                new TreeNode('i', null, null)
                        )
                ),
                new TreeNode('c',
                        new TreeNode('f',null,null),
                        new TreeNode('g',null,null)
                )
        );
        Stack<Character> stack = new Stack<>();
        store(tree, stack);
        System.out.println(Arrays.toString(stack.toArray()));
        char result = findNextNode(stack.toArray(), 'a');
        System.out.println(result);
    }
    

    private static void store(TreeNode node, Stack<Character> stack) {
        if (node == null) {
            return;
        }
        store(node.left, stack);
        stack.push(node.value);
        store(node.right, stack);
    }

    private static char findNextNode(Object[] chs, char value) {
        for(int i=0;i<chs.length-1;i++){
            if(chs[i].equals(value)){
                return (char)chs[i+1];
            }
        }
        return ' ';
    }

    static class TreeNode {
        char value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        TreeNode(char value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
