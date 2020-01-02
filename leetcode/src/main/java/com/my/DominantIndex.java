package com.my;
/**
 * 至少是其他数字两倍的最大数
 * @author shang
 */
public class DominantIndex {
    public static int dominantIndex(int[] nums) {
        if(nums == null){
            return -1;
        }
        int result = 0;
        //一开始默认twiceNum是0
        int twiceNum = 0;
        int max = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>=max){
                max = nums[i];
                if(nums[i]>=twiceNum){
                    result = i;
                }else {
                    result = -1;
                }
                twiceNum = nums[i]*2;
            }else {
                //存在当前值小于max，但2倍大于max
                if(max <2*nums[i]){
                    result = -1;
                    twiceNum = nums[i]*2;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{2, 0, 0, 3}));
    }
}
