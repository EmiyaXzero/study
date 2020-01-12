package com.my.concurrency;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/12 21:23
 **/
class FooBar {
    private int n;
    private Object o = new Object();
    boolean isFoo =false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            synchronized (o){
                if(isFoo){
                    o.wait();
                }
                printFoo.run();
                isFoo = true;
                o.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            synchronized (o){
                if(!isFoo){
                    o.wait();
                }
                printBar.run();
                isFoo = false;
                o.notifyAll();
            }
        }
    }
}