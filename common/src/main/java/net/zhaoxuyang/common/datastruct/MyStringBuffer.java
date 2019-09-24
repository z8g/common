package net.zhaoxuyang.common.datastruct;

public class MyStringBuffer {
    
    private char[] value;
    private int count;
    
    public MyStringBuffer(String str) {
        char[] charArray = str.toCharArray();
        this.value = charArray;
        count = charArray.length;
    }
    
    public char[] toCharArray() {
        return this.value;
    }
    
    public MyStringBuffer concat(MyStringBuffer stringBuffer) {
        int length = stringBuffer.length();
        if (length == 0) {
            return this;
        }
        expandCapacity(count + length);
        
        arrayCopy(stringBuffer.toCharArray(), 0, this.toCharArray(), this.length(), count + length);
        count += length;
        return this;
    }
    
    public void print() {
        for (int i = 0; i < this.count; i++) {
            System.out.print(value[i]);
        }
    }
    
    public int length() {
        return this.count;
    }
    
    private void expandCapacity(int newCapacity) {
        char[] newValue = new char[newCapacity];
        arrayCopy(value, 0, newValue, 0, count);
    }

    /**
     * 字符数组复制
     *
     * @param source 源串的字符数组
     * @param sourcePos 源串的起始下标
     * @param target 目标串的字符数组
     * @param targetPos 目标串的起始下标
     * @param newStringLength 新串的长度
     */
    static void arrayCopy(char[] source, int sourcePos, char[] target, int targetPos, int newStringLength) {
        if (source.length - sourcePos < newStringLength || target.length - targetPos < newStringLength) {
            throw new StringIndexOutOfBoundsException();
        }
        for (int i = 0; i < newStringLength; i++) {
            target[targetPos++] = source[sourcePos++];
        }
    }
}
