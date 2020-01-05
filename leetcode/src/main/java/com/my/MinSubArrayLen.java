package com.my;


/**
 * 长度最小的子数组
 * @author shanghang
 */
public class MinSubArrayLen {
    /**
     * 暴力法 o(n^2)
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if(nums == null || nums.length<=0){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i;j<nums.length;j++){
                temp += nums[j];
                if(temp >= s){
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    /**
     * 使用两个指针
     * 遍历数组累加一旦和超过s,我们就能知道以left为起点的值达到了最小解，这个时候将left右移，累加值减去left值就可以继续找left+1的最佳解
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i=0 ;i <nums.length;i++){
            sum+=nums[i];
            while (sum>=s){
                min = Math.min(i-left+1,min);
                sum -= nums[left];
                left++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
    public static int minSubArrayLen3(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        //将nums的和都放到sums里面sums -->{0,sums[0]+nums[0],sums[1]+nums[1]....sums[len]+nums[len]}
        int[] sums = new int[len+1];
        sums[0] = 0;
        for (int i=0 ; i<len;i++){
            sums[i+1] = sums[i]+nums[i];
        }
        for(int i =0;i<len;i++){
            //将当前sum值+s当做target，就能够从结果数组中取到从当前值开始最小的目标
            int target = lowerBound(sums,sums[i]+s);
            if(target!=-1){
                //target获取到的是i+len,所以需要target-i
                min = Math.min(min,target-i);
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }

    /**
     *
     * @param nums  有序数组
     * @param target 目标值
     * @return
     */
    private static int lowerBound(int[] nums, int target){
        if(nums[nums.length-1]<target){
            return -1;
        }
        int left = 0 ,right = nums.length-1;
        int mid = (right+left)/2;
        while (left<=right){
            if(nums[mid]>=target){
                right = mid;
            }else {
                left = mid+1;
            }
            mid =left+ (right-left)/2;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
