package com.my.method;

/**
 * @author shanghang
 * @title: ConstructorTest
 * @projectName study
 * @description: 构造器学习
 * @date 2020.11.16-19:59
 */

public class ConstructorTest {
    public class A{
        A(){

        }

        A(String a){
            this.a = a;
        }


        private  String a;
        @Override
        public String toString() {
            return super.toString();
        }
    }

    /**
     * 如果父类A有一个带参数的构造函数，没有声明空的构造函数，将提示子类需要实现调用父类A带参数的构造函数
     */
    public class B extends A{
        private String b;

        /**
         * 调用父类的构造函数
         * @param a
         */
        B(String a) {
            super(a);
        }
    }


}
