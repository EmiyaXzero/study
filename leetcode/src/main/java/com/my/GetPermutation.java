package com.my;

import java.util.*;

/**
 * @author shanghang
 * @title: GetPermutation
 * @projectName study
 * @description: 60. 第k个排列
 * @date 2020/9/5-16:24
 */
public class GetPermutation {

    PriorityQueue<Integer> queue = new PriorityQueue();
    List<Integer> alls = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> ints = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ints.add(i+1);
        }
        dfs(ints,0);
        alls.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return alls.get(k-1)+"";
    }

    private void dfs(List<Integer> ints, int sum) {
        if(ints == null || ints.size()==0){
            alls.add(sum);
        }
        for (int i = 0 ;i<ints.size();i++){
            List<Integer> temp = new ArrayList<>(ints);
            temp.remove(i);
            dfs(temp,sum*10+ints.get(i));
        }
    }

    public String getPermutation2(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1 ;i<n;i++){
            factorial[i] = factorial[i-1]*i;
        }
        k--;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n+1];
        Arrays.fill(valid,1);
        for (int i = 1;i<=n;i++){
            int order = k/factorial[n-i]+1;
            for (int j = 1;j<=n;j++){
                order -= valid[j];
                if(order == 0){
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n-i];
        }
        return ans.toString();
    }
}
