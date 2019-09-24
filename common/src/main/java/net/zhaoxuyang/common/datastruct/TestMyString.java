package net.zhaoxuyang.common.datastruct;


public class TestMyString {
    public static void main(String[] args){
        MyString str = new MyString("123456");
        MyString str2 = str.concat(str);
        str2.print();
        MyStringBuffer stringBuffer1 = new MyStringBuffer("123");
        stringBuffer1.print();
    }
}
