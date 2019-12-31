package com.my.concurrency;

/**
 * 死锁demo
 * @author shanghang
 */
public class DeadLockDemo {
    private static String A = "A";

    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    /**
     * t1锁住了A等待B，t2锁住了B等待A
     */
    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try{
                        Thread.sleep(2000L);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
