package com.my.demo;

/**
 * @Author: shanghang
 * @Project:study
 * @description:生产消费者模型
 * @Date: 2020.12.02 22:30
 **/
public class ProductConsomerDemo {
    /**
     * 仓库
     */
     class Godown{
        //最大库存
        public static final int max_size = 100;

        //当前库存
        public int curNum;

        Godown(){

        }

        Godown(int curNum){
            this.curNum = curNum;
        }

        /**
         * 生产指定数量的产品,修改成同步方法
         */
        public synchronized void doProduct(int productNum){
            while (this.curNum+productNum>max_size){
                System.out.println("当前库存:"+ this.curNum +"+生产的数量:"+productNum+">最大库存100将等待");
                try {
                    //线程等待
                    wait();
                    System.out.println("被唤醒");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            curNum += productNum;
            System.out.println("已经生产了" + productNum + "个产品，现仓储量为" + curNum);
            //唤醒在此对象等待的线程
            notifyAll();
        }

        /**
         * 消费指定数量
         */
        public synchronized void doConSum(int conSumNum){
            while (this.curNum-conSumNum<0){
                System.out.println("当前库存:"+ this.curNum +"-消费的数量:"+conSumNum+"<0将等待");
                try {
                    //线程等待
                    wait();
                    System.out.println("被唤醒");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            curNum -= conSumNum;
            System.out.println("已经消费了" + conSumNum + "个产品，现仓储量为" + curNum);
            //唤醒在此对象等待的线程
            notifyAll();
        }
    }

    class Producer extends Thread{
        //生产产品的数量
        private int productNum;
        //仓库
        private Godown godown;

        Producer(int productNum,Godown godown){
            this.productNum = productNum;
            this.godown = godown;
        }

        @Override
        public void run(){
            godown.doProduct(this.productNum);
        }
    }

    class ConSumer extends Thread{
         //消费的数量
        private int conSumNum;
        //仓库
        private Godown godown;

        ConSumer(int conSumNum,Godown godown){
            this.conSumNum = conSumNum;
            this.godown = godown;
        }

        @Override
        public void run(){
            godown.doConSum(this.conSumNum);
        }
    }

    public static void main(String[] args){
        Godown godown = new ProductConsomerDemo().new Godown(10);
        Producer producer1 = new ProductConsomerDemo().new Producer(10,godown);
        Producer producer2 = new ProductConsomerDemo().new Producer(20,godown);
        Producer producer3 = new ProductConsomerDemo().new Producer(30,godown);
        Producer producer4 = new ProductConsomerDemo().new Producer(40,godown);
        ConSumer conSumer1 = new ProductConsomerDemo().new ConSumer(10,godown);
        ConSumer conSumer2 = new ProductConsomerDemo().new ConSumer(10,godown);
        ConSumer conSumer3 = new ProductConsomerDemo().new ConSumer(10,godown);
        ConSumer conSumer4 = new ProductConsomerDemo().new ConSumer(10,godown);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        conSumer1.start();
        conSumer2.start();
        conSumer3.start();
        conSumer4.start();
    }


}
