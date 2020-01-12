package com.my.concurrency;

/**
 * 按序打印
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/12 20:54
 **/
public class Foo {
    boolean first = true;
    boolean second = true;
    public Object o = new Object();
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(o){
            printFirst.run();
            first = false;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        synchronized(o){
            while(first){
                o.wait();
            }
            printSecond.run();
            second = false;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized(o){
            while(second){
                o.wait();
            }
            printThird.run();
        }
    }
}
