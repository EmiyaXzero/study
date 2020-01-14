package com.my.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/14 22:00
 **/
@Slf4j
public class TwinsLockTest {
    static final Lock lock = new TwinsLock();

    public static void main(String[] args) {
        for (int i = 0 ;i<10;i++){
            Worker worker = new Worker("Thread"+i);
            worker.setDaemon(true);
            worker.start();
        }
        for (int i = 0 ;i<10;i++){
            WaitNotify.SleepUtils.second(10);
            log.error("-----------------------");
        }
    }

    static class Worker extends Thread{
        Worker(String name){
            this.setName(name);
        }
        @Override
        public void run(){
            while (true){
                lock.lock();
                try {
                    WaitNotify.SleepUtils.second(10);
                    log.error(Thread.currentThread().getName());
                    WaitNotify.SleepUtils.second(10);
                }catch (Exception e){
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
