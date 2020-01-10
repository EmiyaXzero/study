package com.my.concurrency;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/1/8 23:14
 **/
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        Thread thread = new Thread(new Print(reader),"PrintThread");
        thread.start();
        int receive = 0;
        try {
            while ((receive=System.in.read())!=-1){
                writer.write(receive);
            }
        }finally {
            writer.close();
        }
    }
    static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receiver = 0;
            try{
                while((receiver = in.read())!=-1){
                    System.out.println((char) receiver);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
