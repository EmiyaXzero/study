package com.my;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/25 15:34
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少
 **/
public class MinTime {
    /**
     * 二分查找，找到一个mid使得用mid分割数组使每个数组的值不超过这个最大值
     * @param time
     * @param m
     * @return
     */
    public int minTime(int[] time, int m) {
        if(time.length <= m){
            return 0;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left<right){
            int mid = left+(right-left)/2;
            if(check(time,mid,m)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }


    public boolean check(int[] time ,int spiltInt ,int m){
        //用来计算用max分割的个数
        int count = 0;
        int target = 0;
        int tempMax = Integer.MIN_VALUE;
        for (int tempItem : time){
            target+=tempItem;
            //用于获取这段区间最大的值，让工具人小明来做
            tempMax = Math.max(tempMax,tempItem);
            if(target-tempMax>spiltInt){
                //到达tempItem的时候需要分割数组了
                count++;
                if(count == m){
                    //在遍历中已经达到天数了，说明取值太小了，需要扩大
                    return false;
                }
                //将tempItem放到下一天去
                target=tempItem;
                tempMax=tempItem;
            }
        }
        return true;
    }

    /**
     *
     * @param time
     * @param idx  当前位置
     * @param deepth 第几天
     * @param m 天数限制
     * @return
     */
    public int getMax(int[] time ,int idx ,int deepth,int m){
        if(deepth > m || idx >= time.length){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        if(m == deepth){
            //只有最后一天需要全部做完
            for (int i = idx;i<time.length;i++){
                max = Math.max(time[i],max);
                temp += time[i];
            }
            temp-=max;
            return temp;
        }
        for (int i = idx;i<time.length;i++){
            max = Math.max(time[i],max);
            //到i的时候请小杨帮忙解决需要时间最大的值
            temp += time[i] - max;
            //获取第二天最大的max
            int maxTime = getMax(time,i+1,deepth+1,m);
            //后面和当前花费的时间取最大
            int curMax = Math.max(maxTime,temp);
            min = Math.min(curMax,min);
            //状态回归
            temp += max;
        }
        return min;
    }

    public static void main(String[] args) {
        MinTime minTime = new MinTime();
        System.out.println(minTime.minTime(new int[]{1,999,3,4,5,999}, 4));
    }

}
