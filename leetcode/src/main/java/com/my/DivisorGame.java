package com.my;

/**
 * @author shanghang
 * @title: DivisorGame
 * @projectName study
 * @description: 1025. 除数博弈
 * @date 2020/7/24-18:16
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        if((N&1) == 0 ){
            return  true;
        } else {
            return false;
        }
    }
}
