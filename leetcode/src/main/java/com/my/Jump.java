package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @description: 跳跃游戏 II
 * @Date: 2020/5/4 17:14
 **/
public class Jump {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[length-1] = 0;
        for (int i = length-2;i>=0;i--){
            int min = Integer.MAX_VALUE/2;
            for (int j = i+1;j<=i+nums[i] && j<length;j++){
                min = Math.min(dp[j]+1,min);
            }
            dp[i] = min;
        }
        return dp[0];
    }

    /**
     * 贪心算法求解,思路从前往后找到最前面达到目标的点
     * @param nums
     * @param type1
     * @return
     */
    public int jump(int[] nums,int type1) {
        int position = nums.length-1;
        int steps = 0;
        while (position>0){
            for (int i = 0;i<position;i++){
                if (nums[i]+i>=position){
                    steps++;
                    position=i;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 贪心算法正向查找
     * @param type2
     * @param nums
     * @return
     */

    public int jump(int type2 ,int[] nums) {
        int steps = 0;
        int maxPosition = 0;
        //一开始的起始点
        int end = 0;
        for (int i = 0 ;i<nums.length-1;i++){
            //维持当前区间内最大的右边值
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if(i == end){
                //当i达到了最大边界的时候说明要步数加一了
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        jump.jump(new int[]{2,1});
    }
}
