package com.my.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: ObjectTest
 * @projectName study
 * @description: 运算
 * @date 2020/4/27-20:27
 */
public class ObjectTest {

    public static void main(String[] args) {
        List<Integer> arryas = new ArrayList<>();
        arryas.add(1);
        arryas.add(2);
        System.out.println(arryas.hashCode());
        doArray(arryas);
        System.out.println(arryas.get(1));
        System.out.println(arryas.get(2));
        float ff = 1.1f;
    }

    public static void doArray(List<Integer> a){
       a  = new ArrayList<>();
       a.add(1);
        System.out.println(a.hashCode());
    }

}
