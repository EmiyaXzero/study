package com.my.zk.crud;

import com.my.zk.Executor;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 获取zk节点
 * @author shanghang
 */
public class Get implements Watcher {
    private static Logger log = LoggerFactory.getLogger(Get.class);
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static String zkServer ;
    private static ZooKeeper zk;
    private static Stat stat = new Stat();
    public static void main(String[] args) throws Exception {
        //同步获取
        //sync();
        //异步获取
        //async();
        DataSync();
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if(Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()){
                //连接成功恢复主线程
                countDownLatch.countDown();
            }else if(Event.EventType.NodeChildrenChanged == watchedEvent.getType()){
                //监听Node下面的节点变化，zk数据改变则会通知过来
                try {
                    log.error("child change" + zk.getChildren(watchedEvent.getPath(),true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(Event.EventType.NodeDataChanged == watchedEvent.getType()){
                //数据改变
                try {
                    log.error("data change" + zk.getData(watchedEvent.getPath(),true,stat));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void sync() throws Exception {
        String path="/test";
        zk = new ZooKeeper(zkServer,5000,new Get());
        countDownLatch.await();
        /**
         * PERSISTENT持久化
         * EPHEMERAL临时
         */
        zk.create(path,"test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(path+"/v1","v1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        List<String> childPath = zk.getChildren(path,true);
        zk.create(path+"/v2","v2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        Thread.sleep(Integer.MAX_VALUE);
    }

    public static void async() throws Exception{
        String path="/test";
        zk = new ZooKeeper(zkServer,5000,new Get());
        countDownLatch.await();
        /**
         * PERSISTENT持久化
         * EPHEMERAL临时
         */
        zk.getChildren(path,true,new IChildren2Callback(),null);
        Thread.sleep(Integer.MAX_VALUE);
    }


    public static void DataSync() throws Exception{
        String path="/data";
        zk = new ZooKeeper(zkServer,5000,new Get());
        countDownLatch.await();
        //zk.create(path,"test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        log.error("data:"+zk.getData(path,true,stat));
        //Version= -1的时候不会进行版本校验
        zk.setData(path,"test111".getBytes(),-1);
        Thread.sleep(Integer.MAX_VALUE);
    }

    static class IChildren2Callback implements AsyncCallback.Children2Callback{

        @Override
        public void processResult(int i, String s, Object o, List<String> list, Stat stat) {
            log.error("getZkNode result code :" + i +" path :"+s+" ctx :"+o+" childs: "+list.toString()+" stat :"+stat);
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
