package com.my.demo;

import java.util.concurrent.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:带返回值的线程
 * @Date: 2020.12.05 21:59
 **/
public class CallableDemo {
    class MyCallable implements Callable{

        private String oid;

        MyCallable(String oid){
            this.oid = oid;
        }

        @Override
        public Object call() throws Exception {
            return Thread.currentThread().getName()+this.oid;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(12);
        MyCallable c1 = new CallableDemo().new MyCallable("a1");
        MyCallable c2 = new CallableDemo().new MyCallable("a2");

        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);

        System.out.println(f1.get().toString());
        System.out.println(f2.get().toString());

        pool.shutdown();
    }
}
