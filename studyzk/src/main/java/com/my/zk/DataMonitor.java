package com.my.zk;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

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

    public interface DataMonitorListener {
        void exists(byte data[]);

        void closing(int rc);
    }
}
