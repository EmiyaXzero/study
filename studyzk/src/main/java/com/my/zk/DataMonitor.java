package com.my.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

/**
 * 监视ZooKeeper树中的数据
 * @author shang
 */
public class DataMonitor implements Watcher, AsyncCallback.StatCallback {
    private ZooKeeper zk;
    private String zNode;
    private Watcher watcher;
    //简单地将这些事件转发到DataMonitor来决定如何处理它们
    private DataMonitorListener listener;
    private byte[] prevData;
    public boolean dead;
    public DataMonitor(ZooKeeper zk, String zNode, Watcher watcher, DataMonitorListener listener) {
        this.zk = zk;
        this.zNode = zNode;
        this.watcher = watcher;
        this.listener = listener;
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
        }else{
            try {
                //CreateMode.PERSISTENT持久化节点
                zk.create(this.zNode,"this is zNode".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean isTrue = ((b == null && b!= prevData) || (b!=null && !Arrays.equals(prevData,b)));
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
