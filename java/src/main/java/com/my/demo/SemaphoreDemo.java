package com.my.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: shanghang
 * @Project:study
 * @description:信号量
 * @Date: 2020.12.08 23:19
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        MyPool myPool = new SemaphoreDemo() .new MyPool(20);
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyThread t1 = new SemaphoreDemo() .new MyThread("任务A", myPool, 3);
        MyThread t2 = new SemaphoreDemo() .new MyThread("任务B", myPool, 12);
        MyThread t3 = new SemaphoreDemo() .new MyThread("任务C", myPool, 7);
        service.submit(t1);
        service.submit(t2);
        service.submit(t3);
        service.shutdown();

    }

    class MyPool{
        //信号量
        private Semaphore sp;

        MyPool(int sp){
            this.sp = new Semaphore(sp);
        }

        public Semaphore getSp() {
            return sp;
        }

        public void setSp(Semaphore sp) {
            this.sp = sp;
        }
    }

    class MyThread extends Thread{
        //线程名称
        private String threadName;

        private MyPool pool;

        private int x;

        MyThread(String threadName,MyPool pool , int x){
            this.threadName = threadName;
            this.pool = pool;
            this.x = x;
        }

        @Override
        public void run() {
            try {
                //从信号量获取许可
                pool.getSp().acquire(x);
                System.out.println(threadName + "成功获取了" + x + "个许可！");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //释放信号
                pool.getSp().release(x);
                System.out.println(threadName + "释放了" + x + "个许可！");
            }
        }
    }
}
