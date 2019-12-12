package com.my.zk;

import org.apache.zookeeper.ZooKeeper;

/**
 * 注册
 * @author shang
 */
public class Regist {
    private static volatile ZooKeeper zooKeeper ;
    private static Object INSTANCE_LOCKER = new Object();
    private static String hostPort;
    private Regist(){

    }

    public static ZooKeeper getInstance(){
        if(zooKeeper == null){
            synchronized (INSTANCE_LOCKER){
                if(zooKeeper == null){
                  //  zooKeeper = new ZooKeeper();
                }
            }
        }
        return zooKeeper;
    }

    static{
        //获取zkServer配置

    }
}
