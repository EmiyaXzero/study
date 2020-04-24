package com.my;

/**
 * @author shang
 * @title: WaysToChange
 * @projectName study
 * @description: 硬币
 * @date 2020/4/23-9:07
 */
public class WaysToChange {
    int result = 0;
    int[] coins = new int[]{1,5,10,25};

    public int waysToChange(int n) {
        result =0;
        for (int i = 0 ;i<4;i++){
            if (coins[i]<n){
                doAdd(n,i,coins[i]);
            }else if(coins[i] == n ){
                result++;
                break;
            }else {
                break;
            }

        }
        return result;
    }

    public void doAdd(int target , int curIdx ,int curAdd){
        for (int i = curIdx ; i<4;i++){
            int tempAdd = curAdd+coins[i];
            if(tempAdd<target){
                doAdd(target,i,tempAdd);
            }else if(tempAdd == target){
                result++;
                return;
            }else {
                return;
            }

        }
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        for (int i = 1;i<=100;i++){
            System.out.println(i+" : "+waysToChange.waysToChange(i));
        }
    }
}
