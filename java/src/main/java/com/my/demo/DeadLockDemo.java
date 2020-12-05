package com.my.demo;

/**
 * @Author: shanghang
 * @Project:study
 * @description:死锁
 * @Date: 2020.12.03 22:43
 **/
public class DeadLockDemo {
    public static void main(String[] args){
        DeadLockTest deadLockTest = new DeadLockDemo().new  DeadLockTest();
        MyThread a = new DeadLockDemo().new MyThread(deadLockTest,1,2);
        MyThread b = new DeadLockDemo().new MyThread(deadLockTest,2,3);
        MyThread c = new DeadLockDemo().new MyThread(deadLockTest,4,5);
        MyThread d = new DeadLockDemo().new MyThread(deadLockTest,6,7);
        a.start();
        b.start();
        c.start();
        d.start();
    }



    class MyThread extends Thread{
        private DeadLockTest deadLockTest;
        private int a;
        private int b;

        MyThread(DeadLockTest deadLockTest,int a, int b){
            this.deadLockTest = deadLockTest;
            this.a = a;
            this.b = b;
        }

        @Override
        public void run(){
            deadLockTest.read();
            deadLockTest.write(this.a,this.b);
        }
    }


    class DeadLockTest{
        private class Pojo{
            public int value;
        }


        private Pojo pojoA = new Pojo();
        private Pojo pojoB = new Pojo();

        public int read(){
            synchronized (pojoA){
                System.out.println("read ：线程"+Thread.currentThread().getName()+"获取了pojoA的锁");
                synchronized (pojoB){
                    System.out.println("read ：线程"+Thread.currentThread().getName()+"获取了pojoB的锁");
                    return pojoB.value+pojoA.value;
                }
            }
        }

        public void write(int a,int b){
            synchronized (pojoB){
                System.out.println("read ：线程"+Thread.currentThread().getName()+"获取了pojoB的锁");
                synchronized (pojoA){
                    System.out.println("read ：线程"+Thread.currentThread().getName()+"获取了pojoA的锁");
                    pojoA.value = a;
                    pojoB.value = b;
                }
            }
        }
    }
}
