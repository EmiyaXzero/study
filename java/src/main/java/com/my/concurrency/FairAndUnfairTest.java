package com.my.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/15 22:42
 **/
@Slf4j
public class FairAndUnfairTest {
    /**
     * 公平锁
     */
    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    /**
     * 默认非公平锁
     */
    private static ReentrantLock2 unfairLock = new ReentrantLock2();
    @Test
    public void fair(){
        testLock(fairLock);
    }

    @Test
    public void unfair(){
        testLock(unfairLock);
    }

    private void testLock(ReentrantLock2 lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            Thread thread = new Thread(job);
            thread.setName(""+i);
            thread.start();
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
    }

    private static class Job extends Thread{
        private ReentrantLock2 lock;
        public Job(ReentrantLock2 lock){
            this.lock = lock;
        }
        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    Collection<Thread> threads = lock.getQueuedThreads();
                    StringBuffer sb = new StringBuffer();
                    sb.append("waitThread");
                    for (Thread thread : threads) {
                        sb.append(thread.getName());
                        sb.append(" ");
                    }
                    log.error("currentThread:" + Thread.currentThread().getName() + " " + sb.toString() + " waits");
                    Thread.sleep(100);

                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(){
            super();
        }
        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }


}
