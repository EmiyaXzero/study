package com.my;

/**
 * @author shang
 * @title: NumberOfSteps
 * @projectName study
 * @description: 将数字变成 0 的操作次数
 * @date 2020/4/27-14:23
 */
public class NumberOfSteps {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num != 0){
            if((num & 1) == 0){
                num /=2;
            }else{
                num--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSteps numberOfSteps = new NumberOfSteps();
        numberOfSteps.numberOfSteps(123);
    }
}
