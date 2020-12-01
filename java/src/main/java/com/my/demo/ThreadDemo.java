package com.my.demo;

/**
 * @author shanghang
 * @title: ThreadDemo
 * @projectName study
 * @description: threadDemo
 * @date 2020.11.27-13:53
 */
public class ThreadDemo {
    public class Demo{
        private int i = 100;

        public int getI(){
            return this.i;
        }

        public int doIt(int y ){
            return i-y;
        }
    }

    public class RunnableDemo implements Runnable{
        private Demo demo;

        public RunnableDemo(Demo demo){
            this.demo = demo;
        }


        @Override
        public void run() {
            for (int i = 0 ;i<3;i++){
                int origin = demo.getI();
                System.out.println(Thread.currentThread().getName() + "当前值" + origin + "预测-30的值"+(origin-30)+"实际值"+demo.doIt(30));
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadDemo.Demo demo = new  ThreadDemo().new Demo();
        ThreadDemo.RunnableDemo runnableDemo = new ThreadDemo(). new RunnableDemo(demo);
        Thread t1 = new Thread(runnableDemo,"Thread-1");
        Thread t2 = new Thread(runnableDemo,"Thread-2");
        t1.start();
        t2.start();
    }
}
