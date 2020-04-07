package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/7 9:56
 **/
public class TripleInOne {
    /**
     * 最后一位保留当前栈的长度
     */
    private int[][] stacks;
    public TripleInOne(int stackSize) {
        stacks = new int[3][stackSize+1];
    }

    public void push(int stackNum, int value) {
        if(stacks[stackNum][stacks[0].length-1] < stacks[0].length-1){
            stacks[stackNum][(stacks[stackNum][stacks[0].length-1])] = value;
            stacks[stackNum][stacks[0].length-1]+=1;
        }
    }

    public int pop(int stackNum) {
        if(stacks[stackNum][stacks[0].length-1] == 0){
            return -1;
        }else {
            int temp =  stacks[stackNum][(stacks[stackNum][stacks[0].length-1]-1)];
            stacks[stackNum][stacks[0].length-1]-=1;
            return temp;
        }
    }

    public int peek(int stackNum) {
        if(stacks[stackNum][stacks[0].length-1] == 0){
            return -1;
        }else {
            return stacks[stackNum][(stacks[stackNum][stacks[0].length-1]-1)];
        }
    }

    public boolean isEmpty(int stackNum) {
        return stacks[stackNum][stacks[0].length-1]==0;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0,1);
        tripleInOne.push(0,2);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);

    }
}
