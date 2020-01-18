package offer;

/**
 * 替换空格
 *
 * @author zhaoxuyang
 */
public class Exp05 {

    public static void main(String[] args) {
        System.out.println(replaceSpace("Hello World !"));
        System.out.println(replaceSpace("tab    tab"));
    }

    /**
     * 将空格替换为%20
     *
     * @param s 字符串
     * @return
     */
    private static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chs = s.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                spaceCount++;
            }
        }
        int size = spaceCount * 2 + chs.length;
        char[] result = new char[size];
        for (int i = chs.length - 1, j = size - 1; i >= 0; i--) {
            if (chs[i] == ' ') {
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            } else {
                result[j--] = chs[i];
            }
        }
        return new String(result);
    }
}
