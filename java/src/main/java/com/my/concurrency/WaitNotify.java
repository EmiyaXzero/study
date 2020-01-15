package com.my.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shanghang
 */
@Slf4j
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        SleepUtils.second(1);
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }
    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while(flag){
                    try{
                        log.error(Thread.currentThread() + " flag is true. wait @  "
                                +new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        //wait是指在一个已经进入了同步锁的线程内,让自己暂时让出同步锁
                        lock.wait();
                    }catch (Exception e){

                    }
                }
                log.error(Thread.currentThread() + " flag is false. running @  "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                log.error(Thread.currentThread() + " hold lock. notify @  "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()));
                //notify并不释放锁,只是告诉调用过wait方法的线程可以去参与获得锁的竞争了,但不是马上得到锁,因为锁还在别人手里,别人还没释放
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            SleepUtils.second(5);
            synchronized (lock){
                log.error(Thread.currentThread() + " hold again. notify @  "
                        +new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(10);
            }

        }
    }

    static class SleepUtils {
        public static final void second(long seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
