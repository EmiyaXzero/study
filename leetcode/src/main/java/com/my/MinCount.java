package com.my;

/**
 * @author shang
 * @title: MinCount
 * @projectName study
 * @description: TODO
 * @date 2020/4/18-15:08
 */
public class MinCount {
    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0 ; i<coins.length ;i++){
            count += Math.ceil(coins[i]/2.0);
        }
        return count;
    }

    public static void main(String[] args) {
        MinCount minCount = new MinCount();
        System.out.println(minCount.minCount(new int[]{1, 2, 3}));
    }
}
