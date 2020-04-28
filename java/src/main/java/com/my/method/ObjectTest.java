package com.my.method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shang
 * @title: ObjectTest
 * @projectName study
 * @description: 运算
 * @date 2020/4/27-20:27
 */
public class ObjectTest {
    static class Jojo implements Cloneable{
        int[] arr;
        public Jojo(int size , int key){
            arr = new int[size];
            arr[0] = key;
        }

        @Override
        public Jojo clone() throws CloneNotSupportedException {
            return (Jojo) super.clone();
        }
    }

    static class JojoForDeepCopy implements Cloneable{
        int[] arr;
        public JojoForDeepCopy(int size , int key){
            arr = new int[size];
            arr[0] = key;
        }

        public JojoForDeepCopy(JojoForDeepCopy origin){
            this.arr = new int[origin.arr.length];
            for (int i = 0 ;i< origin.arr.length;i++){
                this.arr[i] = origin.arr[i];
            }
        }

        @Override
        public JojoForDeepCopy clone() throws CloneNotSupportedException {
            JojoForDeepCopy jojoForDeepCopy = (JojoForDeepCopy) super.clone();
            jojoForDeepCopy.arr = new int[arr.length];
            for (int i = 0 ;i < arr.length ;i++){
                jojoForDeepCopy.arr[i] = arr[i];
            }
            return jojoForDeepCopy;
        }
    }

    static class Pojo implements Cloneable{
        int a;
        static int b;
        Pojo(int a){
            this.a = a;
        }

        @Override
        public Pojo clone() throws CloneNotSupportedException {
            return (Pojo) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectTest objectTest = new ObjectTest();
        Pojo p = new Pojo(1);
        Pojo c = p.clone();
        System.out.println((c == p));
        c.a = 2;
        System.out.println(p.a);

        Jojo jojo = new Jojo(2,1);
        System.out.println("克隆前的值:"+jojo.arr[0]);
        Jojo jojo1 = jojo.clone();
        System.out.println((jojo == jojo1));
        jojo1.arr[0] = 3;
        System.out.println("克隆后的值:"+jojo.arr[0]);

        JojoForDeepCopy jojoForDeepCopy = new JojoForDeepCopy(2,1);
        System.out.println("克隆前的值:"+jojoForDeepCopy.arr[0]);
        JojoForDeepCopy jojoForDeepCopy1 = jojoForDeepCopy.clone();
        jojo1.arr[0] = 3;
        System.out.println("克隆后的值:"+jojoForDeepCopy.arr[0]);
    }
}
