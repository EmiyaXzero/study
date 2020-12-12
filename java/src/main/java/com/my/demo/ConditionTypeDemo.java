package com.my.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shanghang
 * @title: ConditionTypeDemo
 * @projectName study
 * @description: 条件变量
 * @date 2020.12.12-16:21
 */
public class ConditionTypeDemo {

    public static void main(String[] args) {
        //创建并发操作的账户
        MyAccount myAccount = new ConditionTypeDemo().new MyAccount("2333333333",100);
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = new ConditionTypeDemo().new GetThread("张三", myAccount, 2000);
        Thread t2 = new ConditionTypeDemo().new SaveThread("李四", myAccount, 3600);
        Thread t3 = new ConditionTypeDemo().new SaveThread("王五", myAccount, 2700);
        Thread t4 = new ConditionTypeDemo().new SaveThread("老张", myAccount, 600);
        Thread t5 = new ConditionTypeDemo().new GetThread("老牛", myAccount, 1300);
        Thread t6 = new ConditionTypeDemo().new GetThread("胖子", myAccount, 800);
        //执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        //关闭线程池
        pool.shutdown();
    }


    public class MyAccount {
        //账户编号
        private String aId;
        //余额
        private int cash;
        //账号锁
        private Lock lock = new ReentrantLock();
        //存条件
        private Condition saveCondition = lock.newCondition();
        //取条件
        private Condition getCondition = lock.newCondition();
        MyAccount(String aId , int cash){
            this.aId = aId;
            this.cash = cash;
        }


        /**
         * 存款
         * @param x
         * @param name
         */
        public void saveCash(int x ,String name){
            //获取锁
            lock.lock();
            try{
                if(x>0){
                    cash+=x;
                    System.out.println(name+"存款了"+x+"元，当前余额为:"+cash);
                }
                //唤醒取条件下面的线程
                getCondition.signalAll();;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

        public void getCash(int x , String name){
            lock.lock();
            try {
                if(cash-x<0){
                    //余额不够，阻塞取款操作
                    System.out.println(name+"余额不够，阻塞取款操作");
                    getCondition.await();
                    System.out.println(name+"被唤醒，取款操作");
                }
                cash -=x;
                System.out.println(name+"取款:"+x+"元，当前余额为:"+cash);
                saveCondition.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    public class SaveThread extends Thread{
        //人
        private String name;

        private MyAccount myAccount;

        private int x;
        SaveThread(String name , MyAccount myAccount,int x){
            this.myAccount = myAccount;
            this.name = name;
            this.x = x;
        }

        @Override
        public void run(){
            myAccount.saveCash(x,name);
        }
    }

    public class GetThread extends Thread{
        //人
        private String name;

        private MyAccount myAccount;

        private int x;
        GetThread(String name , MyAccount myAccount,int x){
            this.myAccount = myAccount;
            this.name = name;
            this.x = x;
        }

        @Override
        public void run(){
            myAccount.getCash(x,name);
        }
    }
}
