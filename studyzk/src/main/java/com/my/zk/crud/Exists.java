package com.my.zk.crud;

import com.my.zk.Executor;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 节点是否存在
 * @author shanghang
 */
public class Exists implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Logger log = LoggerFactory.getLogger(Exists.class);
    private static String zkServer;

    public static void main(String[] args) throws Exception {
        String zkPath = "/test";
        ZooKeeper zk = new ZooKeeper(zkServer,5000,new Exists());
        countDownLatch.await();
        //注册watcher
        Stat stat = zk.exists(zkPath,true);
        log.error("stat:"+stat.toString());
        //子节点删除不会检测到
        zk.delete(zkPath+"/v2",stat.getVersion());
        zk.delete(zkPath+"/v1",stat.getVersion());
        zk.delete(zkPath,stat.getVersion());
        Thread.sleep(Integer.MAX_VALUE);
    }


    static {
        Properties properties = new Properties();
        InputStream in = Executor.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            log.error("缺少配置文件");
        }
        zkServer = properties.getProperty("zkServer");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if(Event.EventType.None == watchedEvent.getType()){
                countDownLatch.countDown();
            }else if(Event.EventType.NodeCreated == watchedEvent.getType()){
                log.error("create");
            }else if(Event.EventType.NodeDeleted == watchedEvent.getType()){
                log.error("delete");
            }else if(Event.EventType.NodeDataChanged == watchedEvent.getType()){
                log.error("data changer");
            }
        }
    }
}
