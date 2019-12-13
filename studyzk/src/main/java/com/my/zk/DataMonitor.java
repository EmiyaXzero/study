package com.my.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

/**
 * @author shang
 */
public class DataMonitor implements Watcher, AsyncCallback.StatCallback {
    private ZooKeeper zk;
    private String zNode;
    private Watcher watcher;
    private Executor executor;
    DataMonitorListener listener;
    private byte[] prevData;
    public boolean dead;
    public DataMonitor(ZooKeeper zk, String zNode, Watcher watcher, Executor executor) {
        this.zk = zk;
        this.zNode = zNode;
        this.watcher = watcher;
        this.executor = executor;
        zk.exists(zNode,true,this,null);
    }

    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        if(watchedEvent.getType() == Watcher.Event.EventType.None){
            switch (watchedEvent.getState()){
                case SyncConnected:
                    // In this particular example we don't need to do anything
                    // here - watches are automatically re-registered with
                    // server and any watches triggered while the client was
                    // disconnected will be delivered (in order of course)
                    return;
                case Expired:
                    dead = true;
                    listener.closing(KeeperException.Code.SessionExpired);
                    break;
                default:
                    break;
            }
        }else{
            if(path != null && path.equals(zNode)){
                zk.exists(zNode,true,this,null);
            }
        }
        if(watcher != null){
            watcher.process(watchedEvent);
        }
    }

    public void processResult(int i, String s, Object o, Stat stat) {
        boolean exists;
        switch (i){
            case KeeperException.Code
                    .Ok:
                exists = true;
                break;
            case KeeperException.Code
                        .NoNode:
                exists=false;
                break;
            case KeeperException.Code.SessionExpired:
            case KeeperException.Code.NoAuth:
                dead = true;
                listener.closing(i);
                return;
            default:
                zk.exists(zNode,true,this,null);
                return;
        }
        byte[] b = null;
        if(exists){
            try {
                b = zk.getData(zNode, false, null);
            } catch (KeeperException e) {
                // We don't need to worry about recovering now. The watch
                // callbacks will kick off any exception handling
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }
        boolean isTrue = (b == null && b!= prevData) || (b!=null && !Arrays.equals(prevData,b));
        if(isTrue){
            listener.exists(b);
            prevData = b;
        }
    }

    public interface DataMonitorListener {
        /**
         * zNode在zookeeper存在时候
         * @param data
         */
        void exists(byte[] data);

        /**
         * zookeeper连接关闭的时候
         * @param rc
         */
        void closing(int rc);
    }
}
