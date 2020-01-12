package com.my.concurrency;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/12 21:12
 **/
public class Foo2 {
    volatile int count = 1;
    public Foo2() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(count !=2){

        }
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(count != 3){

        }

        printThird.run();
    }
}
