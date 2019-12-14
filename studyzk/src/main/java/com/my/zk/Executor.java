package com.my.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * ZooKeeper官方文档第一个demo
 * 维护ZooKeeper连接（主线程以及执行逻辑）
 * @author shang
 */
public class Executor implements Watcher ,Runnable,DataMonitor.DataMonitorListener {
    private static Logger log = LoggerFactory.getLogger(Executor.class);
    private String  filename;
    private String[] exec;
    private ZooKeeper zk;
    private DataMonitor dm;
    private Process child;
    public Executor(String hostPort, String zNode, String filename,
                    String[] exec) throws KeeperException, IOException {
        this.filename = filename;
        this.exec = exec;
        //zk超时时间调大点，原来用的3000连接失败无法走进process方法，调成10000后watch到连接后走进process
        zk = new ZooKeeper(hostPort, 30000, this);
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
                log.error("killing process");
                child.destroy();
                try{
                    child.waitFor();
                }catch(InterruptedException e){

                }
            }
            child = null;
        }else{
            if(child != null){
                log.error("stopping Child");
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
            try {
                log.error("Starting child");
                //Runtime.getRuntime().exec()运行脚本
                child = Runtime.getRuntime().exec(exec);
                new StreamWriter(child.getInputStream(), System.out);
                new StreamWriter(child.getErrorStream(), System.err);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 以响应ZooKeeper连接永久消失。
     */
    public void closing(int rc) {
        synchronized (this){
            notifyAll();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        log.info("process");
        dm.process(watchedEvent);
    }

    static class StreamWriter extends Thread{
        OutputStream os;
        InputStream is;

        StreamWriter(InputStream is, OutputStream os){
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
        String[] exec = new String[]{"calc"};
        try {
            new Executor(hostPort, zNode, filename, exec).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
