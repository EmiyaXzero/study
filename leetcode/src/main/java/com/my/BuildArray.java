package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5404. 用栈操作构建数组
 * @Date: 2020/5/10 10:32
 **/
public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 1;
        for (int j = 0;j<target.length;){
            if(i != target[j]){
                result.add("Push");
                result.add("Pop");
                i++;
            }else {
                result.add("Push");
                i++;
                j++;
            }
        }
        return result;
    }
}
