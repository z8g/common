package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class MyString {

    private char[] value;
    private int count;

    public MyString() {
        this.value = new char[0];
        count = 0;
    }

    public MyString(char[] value) {
        this.count = value.length;
        this.value = new char[this.count];
        arrayCopy(value, 0, this.value, 0, count);
    }

    public MyString(String str) {
        char[] charArray = str.toCharArray();
        this.count = charArray.length;
        this.value = charArray;
    }

    /**
     *
     * @param value 字符数组
     * @param offset 数组起始下标
     * @param count 从起始下标开始数几个字符
     */
    public MyString(char[] value, int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.count = value.length;
        this.value = new char[this.count];
        arrayCopy(value, offset, this.value, 0, count);

    }

    public char charAt(int index) {
        if ((index < 0) || (index >= count)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    public int length() {
        return count;
    }

    public char[] toCharArray() {
        return this.value;
    }

    public int compareTo(MyString anotherString) {
        int len1 = count;
        int len2 = anotherString.length();
        char[] v1 = value;
        char[] v2 = anotherString.toCharArray();

        int lim = Math.min(len1, len2);
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

    public MyString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }

        if (endIndex > this.count) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }

        if (beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
        }

        if (beginIndex == 0 && endIndex == this.count) {
            return this;
        } else {
            return new MyString(this.value, beginIndex, endIndex - beginIndex);
        }
    }

    public MyString substring(int beginIndex) {
        return substring(beginIndex, this.count);
    }

    public MyString concat(MyString str) {
        int strLength = str.length();
        if (strLength == 0) {
            return this;
        }
        char[] strArray = str.toCharArray();
        char[] buff = new char[this.count + strLength];
        arrayCopy(this.value, 0, buff, 0, this.count);
        arrayCopy(strArray, 0, buff, 0, strLength);
        return new MyString(buff);
    }
    
    public MyString insert(MyString str, int pos){
        if(pos <0 || pos> count){
            throw new StringIndexOutOfBoundsException(pos);
        }
        if(pos==0){
            return str.concat(this);
        } else {
            MyString before = this.substring(0,pos);
            MyString after = this.substring(pos);
            return before.concat(str).concat(after);
        }
        
    }
    public void print(){
        for(int i=0;i<this.count;i++){
            System.out.print(value[i]);
        }
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
