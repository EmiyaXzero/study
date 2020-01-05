package com.my.concurrency;


import org.apache.log4j.Logger;

/**
 * @author shanghang
 */
public class ThreadTest {
    private static Logger logger = Logger.getLogger(ThreadTest.class);
    /**
     *system.out.println是带锁的
     * @param args
     */
    public static void main(String[] args) {
        doStartTest();
        doStartRun();
    }

    /**
     * 用log就是t1,t2随机打印
     */
    private static void doStartRun() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //system.out.println是带锁的
                    logger.error("a");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    logger.error("t2");
                }
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * system.out.print先启动的先输出
     */
    private static void doStartTest() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2");
                }
            }
        });
        t1.run();
        t2.run();
    }
}
