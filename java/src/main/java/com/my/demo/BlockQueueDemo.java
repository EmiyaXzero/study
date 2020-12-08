package com.my.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: shanghang
 * @Project:study
 * @description:阻塞队列
 * @Date: 2020.12.08 23:31
 **/
public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(20);
        for (int i = 0 ; i<30 ;i++){
            //如果没有添加进去将会等待
            blockingQueue.put(i);
            System.out.println("向阻塞队列中添加了元素:" + i);
        }
        System.out.println("end");
    }
}
