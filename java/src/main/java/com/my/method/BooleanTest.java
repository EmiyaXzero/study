package com.my.method;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/25 21:44
 **/
public class BooleanTest {
    public static void main(String[] args) {
//        byte a = 1;
//        byte b = -1;
//        Integer integer = new Integer(16);
//        Integer integer1 = Integer.valueOf(16);
//        Integer integer2 = Integer.valueOf(16);
//        Integer integer3 = new Integer(16);
//        System.out.println((integer == integer1));
//        System.out.println((integer1 == integer2));
//        System.out.println((integer2 == integer3));
//        System.out.println((integer == integer3));
//        //拆箱操作等同于integer1.intValue();
//        int int1 = integer1;

        String stringA = new String("bbb");
        String stringB = stringA.intern();
        String stringC = "bbb";
        System.out.println((stringA == stringB));
        System.out.println((stringA == stringC));
        System.out.println((stringB == stringC));
    }
}
