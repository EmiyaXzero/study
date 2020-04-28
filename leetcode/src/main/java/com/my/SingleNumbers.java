package com.my;

import java.util.*;

/**
 * @author shang
 * @title: SingleNumbers
 * @projectName study
 * @description: 数组中数字出现的次数
 * @date 2020/4/28-9:03
 */
public class SingleNumbers {
    /**
     * 先排序不符合时间复杂度o(n)的限制
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);
        result[1] = -99;
        int j = 0;
        for (int i = 0 ;i<nums.length-1;){
            if(nums[i] == nums[i+1]){
                i+=2;
            }else {
                result[j++] = nums[i++];
            }
        }
        if(result[1] == -99){
            result[1] = nums[nums.length-1];
        }
        return result;
    }

    /**
     * 二分法分组神tm的异或操作真是妙蛙种子吃着妙脆巧进米奇妙妙屋妙到家了
     * @param nums
     * @return
     */
    public int[] singleNumbers2On(int[] nums) {
       int sum = 0 ,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE ,zeroCount = 0;
       for (int num : nums){
           if(num == 0){
               //zeroCount保存0的个数，防止数组存在0和一个其他数
               zeroCount +=1;
           }
           min = Math.min(num,min);
           max = Math.max(num,max);
           //异或相等的值都为0 因为p^p = 0 p^0 = p 所以最后的值为p^q
           sum^=num;
       }
        if(zeroCount == 1){
            return new int[]{sum,0};
        }
        //通过二分法将p q 分类
        int left = min , right = max;
        //二分法找到一个值使得左边的值存在非0同时右边的值也存在非0
        while(left<=right){
            //left+right>>1 == (left+right)/2 根据最小值的正负性来判断
            int mid = left<0 ? left+right>>1 : left+(right-left)/2;
            int p = 0 ,q =0;
            for (int num : nums){
                if(num<mid){
                    p^=num;
                }else {
                    q^=num;
                }
            }
            if(p!=0 && q !=0){
                return new int[]{p,q};
            }

            if(p == 0 && q!=0){
                left = mid;
            }else {
                right=mid;
            }
        }
        return null;
    }

    /**
     * 根据后面n位进行分组
     * @param nums
     * @return
     */
    public int[] singleNumbers2On2(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum^=num;
        }
        //获取sum中1的最低位,因为通过&1进行区别可以分为奇偶两组，当与操作多位的时候同样能分成两组，因此取sum最低的一位值来分组
        int mask = 1;
        while ((sum&mask)==0){
            //mask右移一位
            mask<<=1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums){
            //根据mask后面分组
            if((mask&num) == 0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }

        public static void main(String[] args) {
        SingleNumbers singleNumber = new SingleNumbers();
        singleNumber.singleNumbers2On(new int[]{4,1,4,6});
    }
}
