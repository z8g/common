package net.zhaoxuyang.common.datastruct;


/**
 *
 * @author Administrator
 */
public class TestHuiWen {

    public static void main(String[] args) {
        System.out.println(huiwen("123321"));
        System.out.println(huiwen("1234321"));
        System.out.println(huiwen("12345321"));
    }

    public static boolean huiwen(String str) {
        try {
            int n = str.length();
            SeqStack stack = new SeqStack(n);
            SeqQueue queue = new SeqQueue(n);
            for (int i = 0; i < n; i++) {
                queue.append(str.substring(i, i + 1));
                stack.push(str.substring(i, i + 1));
            }
            while (queue.notEmpty() && stack.notEmpty()) {
                if (!queue.delete().equals(stack.pop())) {
                    return false;
                }
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
