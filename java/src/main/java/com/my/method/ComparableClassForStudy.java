package com.my.method;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/5 21:59
 **/
public class ComparableClassForStudy{


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = HashMap.class;
        Method method = clazz.getDeclaredMethod("comparableClassFor", Object.class);
        method.setAccessible(true);
        System.out.println(method.invoke(null, new A()) +"--"+A.class);
        System.out.println(method.invoke(null, new B())+"--"+B.class);
        System.out.println(method.invoke(null,new C())+"--"+C.class);
    }







    public static class A implements Comparable<Integer>{
        @Override
        public int compareTo(Integer o) {
            return 0;
        }
    }

    public static class B implements Comparable<B>{
        @Override
        public int compareTo(B o) {
            return 0;
        }
    }

    public static class C implements Serializable ,Comparable<C>,Cloneable {
        @Override
        public int compareTo(C o) {
            return 0;
        }
    }
}
