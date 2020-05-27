package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5412. 在既定时间做作业的学生人数
 * @Date: 2020/5/17 10:32
 **/
public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0;i<startTime.length;i++){
            if(queryTime>=startTime[i] && queryTime<=endTime[i]){
                result++;
            }
        }
        return result;
    }
}
