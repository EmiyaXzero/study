package com.my;

/**
 * 统计位数为偶数的数字
 * @author shang
 */
public class FindNumbers {

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0 ;i< nums.length ; i++){
            if((int) (Math.log10(nums[i]*1.0)%2)== 1){
                count ++ ;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{252}));
    }
}
