package com.my.method;

import lombok.SneakyThrows;

/**
 * @Author: shanghang
 * @Project:study
 * @description:ThreadDemo
 * @Date: 2020.11.29 21:18
 **/
public class ThreadDemo {

    public  class ThreadA extends Thread{
       String name = "";
       public ThreadA(){

       }

       public ThreadA(String name){
           this.name = name;
       }

        @SneakyThrows
        @Override
        public void run() {
           int i = 0;
           while (true){
               Thread.sleep(1000);
               System.out.println(name+ ++i);
           }
        }
    }

    public class ThreadB implements Runnable{
        String name = "";
        public ThreadB(){

        }
        public ThreadB(String name){
            this.name = name;
        }
        @SneakyThrows
        @Override
        public void run() {
            int i = 0;
            while (true){
                Thread.sleep(1000);
                System.out.println(name+ ++i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadB a1 =  new ThreadDemo().new ThreadB("张三");
        ThreadB a2 =  new ThreadDemo().new ThreadB("李四");
        Thread thread1 = new Thread(a1);
        Thread thread2 = new Thread(a2);
        thread1.start();
        thread2.start();
    }
}
