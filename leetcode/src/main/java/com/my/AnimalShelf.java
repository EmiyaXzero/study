package com.my;

import java.util.LinkedList;

/**
 * @author shang
 * @title: AnimalShelf
 * @projectName study
 * @description: TODO
 * @date 2020/4/10-9:15
 */
public class AnimalShelf {
    LinkedList<MyNode> catList;
    LinkedList<MyNode> dogList;
    LinkedList<MyNode> allList;

    public AnimalShelf() {
        catList = new LinkedList<>();
        dogList = new LinkedList<>();
        allList = new LinkedList<>();
    }

    /**
     * animal[0]代表编号  animal[1]代表动物
     * @param animal
     */
    public void enqueue(int[] animal) {
        MyNode temp = new MyNode(animal[0],animal[1]);
        allList.add(temp);
        if(animal[1] == 0){
            catList.add(temp);
        }else {
            dogList.add(temp);
        }
    }

    /**
     * 从狗队列中走最早的
     * @return
     */
    public int[] dequeueAny() {
        if(allList.size() == 0){
            return new int[]{-1,-1};
        }else {
            MyNode returnNode = allList.pop();
            if(returnNode.type == 0){
                catList.remove(returnNode);
            }else {
                dogList.remove(returnNode);
            }
            return new int[]{returnNode.no,returnNode.type};
        }
    }

    public int[] dequeueDog() {
        if(dogList.size() == 0){
            return new int[]{-1,-1};
        }else {
            MyNode returnNode = dogList.pop();
            allList.remove(returnNode);
            return new int[]{returnNode.no,returnNode.type};
        }
    }

    public int[] dequeueCat() {
        if(catList.size() == 0){
            return new int[]{-1,-1};
        }else {
            MyNode returnNode = catList.pop();
            allList.remove(returnNode);
            return new int[]{returnNode.no,returnNode.type};
        }
    }

    public class MyNode{
        /**
         * no递增
         */
        public int no;
        /**
         * type 0猫  1狗
         */
        public int type;

        MyNode(int i ,int j){
            this.no = i;
            this.type = j;
        }
    }
}
