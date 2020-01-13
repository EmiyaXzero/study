package com.my.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author shang
 * @title: Mutex
 * @projectName study
 * @description: 自定义同步组件，在同一时刻只允许一个线程占有锁。
 * @date 2020/1/13-23:01
 */
public class Mutex implements Lock {
    private final Sync sync = new Sync();

    /**
     * 静态内部类，自定义同步器并且实现了独占式获取和释放同步状态。
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        //是否是占用状态
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        //当状态为0的时候获取到锁
        //return STATE.compareAndSet(this, expect, update);
        @Override
        public boolean tryAcquire(int acquires){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //释放锁，将状态设置为0
        @Override
        protected boolean tryRelease(int releases){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        //返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }
}
