package com.my.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shanghang
 * @title: LockDemo
 * @projectName study
 * @description: 锁学习
 * @date 2020.12.06-14:56
 */
public class WriteReadLockDemo {

    public static void main(String[] args) {
        //创建一个多线程共享变量，账户
        Account account = new WriteReadLockDemo().new Account("2333",100);
        //创建一个锁
        ReadWriteLock lock = new ReentrantReadWriteLock();
        //创建一个线程池
        ExecutorService pools = Executors.newCachedThreadPool();
        //创建多个用户
        User u1 = new WriteReadLockDemo().new User("张三",account,-5,lock,false);
        User u2 = new WriteReadLockDemo().new User("张三爸爸",account,10,lock,false);
        User u3 = new WriteReadLockDemo().new User("张三弟弟",account,-20,lock,false);
        User u4 = new WriteReadLockDemo().new User("张三妈妈",account,30,lock,false);
        User u5 = new WriteReadLockDemo().new User("张三妈妈",account,0,lock,true);
        pools.execute(u1);
        pools.execute(u2);
        pools.execute(u3);
        pools.execute(u4);
        pools.execute(u5);
        pools.shutdown();
    }

    class User implements Runnable{
        private String name;
        private Account myCount;
        //操作的金额
        private int ioMoney;
        private ReadWriteLock myLock;
        private boolean isRead;

        User(String name ,Account myCount , int ioMoney,ReadWriteLock myLock,boolean isRead){
            this.name = name;
            this.myCount = myCount;
            this.ioMoney = ioMoney;
            this.myLock = myLock;
            this.isRead = isRead;
        }

        @Override
        public void run() {
            //---------------获取锁,锁【myLock.lock】必须紧跟try代码块，且unlock要放到finally第一行。
            if(isRead){
                myLock.readLock().lock();
                try {
                    System.out.println("读" + name + "正在查询" + myCount + "账户，金额为" + myCount.getMoney());
                }catch (Exception e){

                }finally {
                    myLock.readLock().unlock();
                }

            }else {
                myLock.writeLock().lock();
                try{
                    //处理业务
                    System.out.println(name + "正在操作" + myCount.acctId + "账户" + "金额为" + ioMoney + ",当前金额为:" + myCount.getMoney());
                    myCount.setMoney(myCount.getMoney()+ioMoney);
                    System.out.println(name + "操作" + myCount.acctId + "账户成功，操作的" + "金额为" + ioMoney + ",当前金额为:" + myCount.getMoney());

                }catch (Exception e){

                }finally {
                    myLock.writeLock().unlock();
                }
            }


        }
    }


    class Account{
        private String acctId;
        private int money;

        Account(String acctId,int money){
            this.acctId = acctId;
            this.money = money;
        }

        public String getAcctId() {
            return acctId;
        }

        public void setAcctId(String acctId) {
            this.acctId = acctId;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }
}
