package com.my;

import java.util.*;

/**
 * @author shang
 * @title: NumberOfSubarrays
 * @projectName study
 * @description: 统计「优美子数组」
 * @date 2020/4/21-9:17
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        List<Integer> idxJi = new ArrayList<>();
        for (int i = 0 ; i<nums.length;i++){
            if(isJi(nums[i])){
                idxJi.add(i);
                nums[i] = 1;
            }else {
                nums[i] = 0;
            }
        }
        if(idxJi.size() <k){
            return 0;
        }else {
            //将一个大的数组拆分为N个k个奇数包裹的数组，然后求和
            if(idxJi.size() == k){
                return (idxJi.get(0)+1)*(length-idxJi.get(k-1));
            }
            //可以优化将idxJi扩到到idxJi.length+2,0放-1，最后一个位置放length，这样就不用这么写临界

            for (int i = 0,j=i+k-1;j<idxJi.size();i++,j++){
                if (i == 0){
                    count += (idxJi.get(0)+1)*(idxJi.get(j+1) - idxJi.get(j));
                }else if(j == idxJi.size()-1){
                    count += (idxJi.get(i)-idxJi.get(i-1))*(length - idxJi.get(j));
                }else {
                    count += (idxJi.get(i)-idxJi.get(i-1))*(idxJi.get(j+1) - idxJi.get(j));
                }
            }
        }

        return count;
    }

    /**
     * 优化一次遍历队列
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays2(int[] nums, int k) {
        int count = 0;
        //双向队列保存k个奇数
        Deque<Integer> q = new ArrayDeque<>(k);
        //保存上一次出队的值
        int lastIdx = -1;
        List<Integer> idxJi = new ArrayList<>();
        for (int i = 0 ; i<nums.length;i++){
            if(isJi(nums[i])){
                if(q.size() == k){
                    //拿到队头，不出队防止k==1的时候连续奇数出队队列为空
                    int temp = q.peek();
                    count += (temp-lastIdx)*(i-q.getLast());
                    lastIdx = temp;
                    q.poll();
                }
                q.add(i);
            }
        }
        //遍历完的时候其实队列还有
        if(q.size() == k){
            count+=(q.peek()-lastIdx)*(nums.length-q.getLast());
        }
        return count;

    }

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        numberOfSubarrays.numberOfSubarrays2(new int[]{1,1,1,1,1},1);
    }

    public boolean isJi(int i){
        //与运算取最后一位
        return (i&1)==1;
    }

}
