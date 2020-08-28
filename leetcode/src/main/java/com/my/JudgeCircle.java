package com.my;

/**
 * @author shanghang
 * @title: JudgeCircle
 * @projectName study
 * @description: 657. 机器人能否返回原点
 * @date 2020/8/28-9:49
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int[] count = new int[4];
        for (int i =0;i<moves.length();i++ ){
            switch (moves.charAt(i)){
                case 'R':
                    count[0]++;
                    break;
                case 'L':
                    count[1]++;
                    break;
                case 'U':
                    count[2]++;
                    break;
                case 'D':
                    count[3]++;
                    break;

            }
        }
        return count[0] == count[1] && count[2] == count[3];
    }
}
