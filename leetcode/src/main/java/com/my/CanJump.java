package com.my;

/**
 * @author shang
 * @title: CanJump
 * @projectName study
 * @description: 跳跃游戏
 * @date 2020/4/17-16:30
 */
public class CanJump {
    int max = 0;
    public boolean canJump(int[] nums) {
        if(nums.length <=1){
            return true;
        }
        return canJump(nums,0);
    }

    /**
     * 递归超时了
     * @param nums
     * @param i
     * @return
     */
    public boolean canJump(int[] nums ,int i){
        max = Math.max(max,i+nums[i]);

        if(i+nums[i] >= nums.length-1){
            return true;
        }
        int temp = nums[i];
        for (int j = 1 ;j<= temp ;j++){
            if(nums[i]+i < max){
                continue;
            }
            if(canJump(nums,i+j)){
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        for(int i=0 ; i < nums.length ;i++){
            if(i<=max){
                max = Math.max(nums[i]+i,max);
                if(i+nums[i] >= nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        canJump.canJump(new int[]{2,0,0});
    }
}
