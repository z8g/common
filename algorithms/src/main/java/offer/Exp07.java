package offer;

import java.util.Arrays;

/**
 * 重建二叉树
 *
 * @author zhaoxuyang
 */
public class Exp07 {

    public static void main(String[] args) {
        int[] beforeArr = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] centerArr = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = createBinaryTree(beforeArr, centerArr);
        System.out.println(tree);
    }

    /**
     * 重建二叉树
     * <pre>
     * 根据beforeArr找出根节点
     * 根据根节点在centerArr确定根节点位置，划分出左右子树
     * </pre>
     *
     * @param beforeArr 前序遍历序列，第一个数字总是树的根节点
     * @param centerArr 中序遍历序列，根节点在中间，左边是左子树节点，右边是右子树节点
     * @return
     */
    private static TreeNode createBinaryTree(int[] beforeArr, int[] centerArr) {
        if (beforeArr == null || beforeArr.length == 0
                || centerArr == null || centerArr.length == 0) {
            return null;
        }
        return create(beforeArr, centerArr);
    }

    private static TreeNode create(int[] bArr, int[] cArr) {
        int rootValue = bArr[0];
        int rootValueIndexInCenterArr = find(cArr, rootValue);

        TreeNode rootNode = new TreeNode(rootValue, null, null);

        int leftTreeLen = rootValueIndexInCenterArr;
        if(leftTreeLen > 0){
            int[] leftBeforeArr = newArr(bArr, 1, leftTreeLen);
            int[] leftCenterArr = newArr(cArr, 0, leftTreeLen);
            if (leftBeforeArr != null && leftBeforeArr.length > 0
                    && leftCenterArr != null && leftCenterArr.length > 0) {
                rootNode.left = create(leftBeforeArr, leftCenterArr);
            }
        }
        int rightTreeLen = cArr.length - 1 - rootValueIndexInCenterArr;
        if(rightTreeLen > 0){
            int[] rightBeforeArr = newArr(bArr, 1 + leftTreeLen, rightTreeLen);
            int[] rightCenterArr = newArr(cArr, rootValueIndexInCenterArr, rightTreeLen);

            if (rightBeforeArr != null && rightBeforeArr.length > 0
                    && rightCenterArr != null && rightCenterArr.length > 0) {
                rootNode.right = create(rightBeforeArr, rightCenterArr);
            }
        }
        
        return rootNode;
    }

    private static int[] newArr(int[] arr, int startIndex, int len) {
        int[] newArr = new int[len];
        System.arraycopy(arr, startIndex, newArr, 0, len);
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }

    private static int find(int[] cArr, int rootValue) {
        for (int i = 0; i < cArr.length; i++) {
            if (rootValue == cArr[i]) {
                System.out.println("i>> " +i);
                return i;
            }
        }
        throw new IllegalArgumentException("中序遍历序列中找不到根节点位置:"+rootValue);
    }

    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            s.append(value);
            if(left != null){
                s.append(left.toString());
            }
            if(right != null){
                s.append(right.toString());
            }
            return s.toString();
        }
    }

}
