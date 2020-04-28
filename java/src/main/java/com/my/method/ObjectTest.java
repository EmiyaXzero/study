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
    class Jojo{

    }

    static class Pojo{
        int a;
        static int b;
        Pojo(int a){
            this.a = a;
        }
    }


    public static void main(String[] args) {
        ObjectTest objectTest = new ObjectTest();
        final Pojo p = new Pojo(1);
        Jojo jojo = objectTest.new Jojo();
    }
}
