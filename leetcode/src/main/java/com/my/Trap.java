package com.my;

import java.util.Stack;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/4 16:59
 **/
public class Trap {
    public int trap(int[] height) {
        if(height.length<=2){
            return 0;
        }
        int count = 0;
        int left = 0;
        //找到第一个非0的地方
        while(height[left]== 0){
            left++;
        }
        int right = left+1;
        int min = Integer.MAX_VALUE;
        //双指针找到区间
        while (left <height.length && right<height.length){
            if(height[right]>=height[left] && left == right-1){
                left++;
                right++;
            }else if(height[right]<=height[left]){
                if(height[right] > min){
                    //存在两种情况1.到right结束，2到比left大的地方结束,
                    int theMax = height[right];
                    for (int j = right ;j<height.length;j++){
                        if(height[j]>=height[left]){
                            right = j;
                            break;
                        }else if(height[j] > min && height[j]>theMax){
                            right = j;
                            theMax = height[j];
                        }
                    }
                    int theMin = Math.min(height[left],height[right]);
                    for (int j = left+1 ; j<right;j++){
                        count += Math.max(0,theMin - height[j]);
                    }
                    left = right;
                    right = right+1;
                    min = Integer.MAX_VALUE;
                    continue;
                }
                //表示可以接水，然后找到右边结束点找到比min大的,可能右节点大于min小于left，或者右节点大于left
                min = Math.min(height[right],min);
                right++;
            }else if(height[right]>=height[left]){
                //直接遍历到right大于left的地方
                int theMin = Math.min(height[left],height[right]);
                for (int j = left+1 ; j<right;j++){
                    count += Math.max(0,theMin - height[j]);
                }
                left = right;
                right = right+1;
                min = Integer.MAX_VALUE;
            }
        }
        return count;
    }

    /**
     * 栈的解法
     * @param height
     */
    public int trap2(int[] height) {
        //s保存数组的索引
        Stack<Integer> s = new Stack<>();
        if(height.length<=2){
            return 0;
        }
        int count = 0;
        for (int i = 0;i<height.length;i++){
            while(!s.isEmpty() && height[s.peek()]<height[i]){
                //存在水坑
                int curIdx = s.pop();
                while (!s.isEmpty() && height[s.peek()] == height[curIdx]){
                    // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                    s.pop();
                }
                //计算值
                if(!s.isEmpty()){
                    count+= (i-s.peek()-1)*(Math.min(height[i],height[s.peek()])-height[curIdx]);
                }
            }

            s.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        trap.trap(new int[]{4,3,3,9,3,0,9,2,8,3});
    }
}
