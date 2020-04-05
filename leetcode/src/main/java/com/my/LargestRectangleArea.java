package com.my;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/5 14:27
 **/
public class LargestRectangleArea {
    /**
     * 暴力法，循环查找出来所有的大小值
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights.length<1){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }
        int sum = 0;
        for (int i = 0;i<heights.length ;i++){
            if(heights[i] == 0){
                continue;
            }
            int left = i;
            int right = i;
            for (int j = i-1;j>=0;j--){
                if(heights[j]<heights[i]){
                    left = j+1;
                    break;
                }else{
                    left = j;
                }
            }
            for (int j= i+1;j<heights.length;j++){
                if (heights[j]<heights[i]){
                    right = j-1;
                    break;
                }else{
                    right = j;
                }
            }

            sum = Math.max(sum,(right-left+1)*heights[i]);
        }
        return sum;
    }
    public int largestRectangleArea2(int[] heights) {
        if(heights.length<1){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }
        heights = Arrays.copyOf(heights,heights.length+1);
        //增加结束标记
        heights[heights.length-1] = 0;
        //单调递增栈
        int count = 0;
        Stack<Integer> s = new Stack<>();
        for (int i =0 ;i<heights.length;i++){
            while (!s.isEmpty() && heights[s.peek()]>heights[i]){
                int curIdx = s.pop();
                count = Math.max(heights[curIdx]*(s.isEmpty()?i:i-s.peek()-1),count);
            }
            s.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        l.largestRectangleArea(new int[]{2,3});
    }
}
