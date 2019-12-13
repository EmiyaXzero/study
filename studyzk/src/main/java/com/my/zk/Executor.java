package com.my.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * ZooKeeper官方文档第一个demo
 * @author shang
 */
public class Executor implements Watcher ,Runnable,DataMonitor.DataMonitorListener {
    private static Logger log = LoggerFactory.getLogger(Executor.class);
    private String  filename;
    private String[] exec;
    private ZooKeeper zk;
    private DataMonitor dm;
    private Process child;
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream in = Executor.class.getClassLoader().getResourceAsStream("zkServer.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            log.error("缺少配置文件");
        }
        String hostPort = properties.getProperty("hostPort");
        String zNode = properties.getProperty("zNode");
        String filename = properties.getProperty("filename");
        String[] exec = new String[args.length];
        try {
            new Executor(hostPort, zNode, filename, exec).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Executor(String hostPort, String zNode, String filename,
                    String[] exec) throws KeeperException, IOException {
        this.filename = filename;
        this.exec = exec;
        //zk超时时间调大点，原来用的3000连接失败无法走进process方法，调成10000后watch到连接后走进process
        zk = new ZooKeeper(hostPort, 10000, this);
        dm = new DataMonitor(zk, zNode, null, this);
    }

    public void run() {
        try {
            synchronized (this) {
                while (!dm.dead) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public void exists(byte[] data) {
        if(data == null){
            if(child != null){
                child.destroy();
                try{
                    child.waitFor();
                }catch(InterruptedException e){

                }
            }
            child = null;
        }else{
            if(child != null){
                child.destroy();
                try{
                    child.waitFor();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            try{
                FileOutputStream fos = new FileOutputStream(filename);
                fos.write(data);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closing(int rc) {
        synchronized (this){
            notifyAll();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        dm.process(watchedEvent);
    }

    static class SteamWriter extends Thread{
        OutputStream os;
        InputStream is;

        SteamWriter(InputStream is, OutputStream os){
            this.is = is;
            this.os = os;
            start();
        }

        @Override
        public void run(){
            byte[] b = new byte[80];
            int rc ;
            try{
                while ((rc = is.read(b))>0){
                    os.write(b, 0, rc);
                }
            }catch (IOException e){

            }
        }
    }
}
