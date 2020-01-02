package com.my.concurrency;

/**
 * count = 1000
 * Concurrency : 1ms,b=-1000
 * serial : 0ms,b=-1000a=5000
 * 并行反而比串行慢
 *
 * count = 100000
 * Concurrency : 2ms,b=-100000
 * serial : 2ms,b=-100000a=500000
 *
 * count = 1000000
 * Concurrency : 5ms,b=-1000000
 * serial : 5ms,b=-1000000a=5000000
 *
 * count = 10000000
 * Concurrency : 8ms,b=-10000000
 * serial : 12ms,b=-10000000a=50000000
 *
 * 当数量庞大的时候并行是比串行快的
 * @author shanghang
 */
public class ConcurrencyTest {
    private static final long count = 10000000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i =0 ;i<count;i++){
            a+=5;
        }
        int b = 0;
        for (long i =0 ;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms,b=" + b +"a="+a);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i =0 ;i<count;i++){
                    a+=5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i<count; i++){
                b--;
        }
        long time = System.currentTimeMillis() - start;
        //主线程需要等待子线程执行完成之后再结束
        thread.join();
        System.out.println("Concurrency : " + time + "ms,b=" + b);
    }



}
