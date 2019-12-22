package com.my;

public class Foo {

    public Foo() {
        Runnable first = new Runnable() {
            @Override
            public void run() {
                System.out.print("one");
            }
        };

        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.print("two");
            }
        };

        Runnable third = new Runnable() {
            @Override
            public void run() {
                System.out.print("three");
            }
        };
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
