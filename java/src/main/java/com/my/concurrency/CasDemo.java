package com.my.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shanghang
 */
public class CasDemo {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final CasDemo cas = new CasDemo();
        List<Thread> ts = new ArrayList<Thread>(600);
        long start = System.currentTimeMillis();
        for (int j =0 ; j<100 ;j++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ;i<10000 ;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(thread);
        }
        for(Thread t : ts){
            t.start();
        }

        for(Thread t : ts){
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("cas.i:"+cas.i);
        System.out.println("cas.atomicInteger:"+cas.atomicInteger);
        System.out.println("cost:"+ (System.currentTimeMillis()-start));

    }

    /**
     * 线程安全计数器
     */
    private void safeCount() {
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }

    /**
     * 非线程安全
     */
    private void count() {
        i++;
    }
}
