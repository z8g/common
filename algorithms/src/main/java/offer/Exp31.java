package offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author zhaoxuyang
 */
public class Exp31 {

    public static void main(String[] args) {
        int[] pushArr = new int[]{1, 2, 3, 4, 5};
        int[] popArr = new int[]{4, 5, 3, 2, 1};
        int[] errorPopArr = new int[]{4, 3, 5, 1, 2};
        System.out.println(isMatch(pushArr, popArr));
        System.out.println(isMatch(pushArr, errorPopArr));
    }

    private static boolean isMatch(int[] pushArr, int[] popArr) {
        if (pushArr == null || pushArr.length == 0
                || popArr == null || popArr.length == 0
                || pushArr.length != popArr.length) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> pushStack = new Stack<>();
        for (int i = pushArr.length - 1; i >= 0; i--) {
            pushStack.push(pushArr[i]);
        }
        //System.out.println(pushStack);
        Stack<Integer> popStack = new Stack<>();

        /**
         * 现在拥有两个栈，一个是数据栈pushStack，一个是专门用来出栈的栈popStack
         */
        for (int i = 0; i < popArr.length; i++) { //遍历 出栈序列

            int value = popArr[i];
            // 开始，如果popStack的top没有value，则将pushStack中的数据倒入popStack中
            // 如果pushStack中没有数据，则说明没有该序列
            boolean find = !popStack.isEmpty() && popStack.peek() == value;
            if (find) {
                popStack.pop();
                continue;
            }
            while (!pushStack.isEmpty()) {
                int v = pushStack.pop();
                if (v == value) {
                    find = true;
                    break;
                } else {
                    popStack.push(v);
                }
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }
}
