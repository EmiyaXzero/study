package com.my.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author shang
 */
public class DataMonitor {
    private ZooKeeper zk;
    private String zNode;
    private Watcher watcher;
    private Executor executor;
    public boolean dead =false;
    public DataMonitor(ZooKeeper zk, String zNode, Watcher watcher, Executor executor) {
        this.zk = zk;
        this.zNode = zNode;
        this.watcher = watcher;
        this.executor = executor;
    }

    public void process(WatchedEvent watchedEvent) {
    }

    public interface DataMonitorListener {
        /**
         * zNode在zookeeper存在时候
         * @param data
         */
        void exists(byte data[]);

        /**
         * zookeeper连接关闭的时候
         * @param rc
         */
        void closing(int rc);
    }
}
