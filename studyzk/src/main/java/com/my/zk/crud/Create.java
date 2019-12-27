package com.my.zk.crud;

import com.my.zk.Executor;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 创建demo
 * @author shanghang
 */
public class Create implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Logger log = LoggerFactory.getLogger(Create.class);
    private static String zkServer;

    public static void main(String[] args) throws Exception {
        //同步创建
        //sync();
        //异步创建
        async();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            countDownLatch.countDown();
            log.error("second");
        }
    }

    public static void sync() throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(zkServer,5000,new Create());
        log.error("first");
        countDownLatch.await();
        log.error("third");
        String path1 = zooKeeper.create("/myNode","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        log.error("zkNode Create :"+path1);
        //如果创建临时顺序节点，会在之前的节点后缀上面增加数字
        String path2 = zooKeeper.create("/myNode","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
        log.error("zkNode create :"+path2);
    }

    public static void async() throws Exception{
        ZooKeeper zk = new ZooKeeper(zkServer,5000,new Create());
        countDownLatch.await();
        zk.create("/myNode","".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,new IStringCallBack(),"context");
        zk.create("/myNode","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL,new IStringCallBack(),"context");
        zk.create("/myNode","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL,new IStringCallBack(),"context");
        //主线程都结束了
        Thread.sleep(Integer.MAX_VALUE);
    }

    static class IStringCallBack implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int i, String s, Object o, String s1) {
            log.error("result is resultCode:"+i+",path:"+s+"context:"+o+"real path name :"+s1);
        }
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
}
