package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanghang
 * @title: MinimumTotal
 * @projectName study
 * @description: 120. 三角形最小路径和
 * @date 2020/7/14-19:44
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
      List<List<Integer>> dp = new ArrayList<>();
      dp.add(new ArrayList<>());
      for (int i = 0;i<triangle.get(triangle.size()-1).size();i++){
        dp.get(dp.size()-1).add(triangle.get(triangle.size()-1).get(i));
      }
      for (int i = triangle.size()-2 ;i>=0 ;i--){
          dp.add(new ArrayList<>());
          for (int j = 0;j<triangle.get(i).size();j++){
              int min = Math.min(triangle.get(i).get(j)+dp.get(dp.size()-2).get(j),triangle.get(i).get(j)+dp.get(dp.size()-2).get(j+1));
              dp.get(dp.size()-1).add(min);
          }
      }
      return dp.get(dp.size()-1).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1;i<len;i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j = 1;j<i;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<len;i++){
            min = Math.min(min,dp[len-1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> key = new ArrayList<>();
        key.add(new ArrayList<Integer>(){{add(2);}});
        key.add(new ArrayList<Integer>(){{add(3);add(4);}});
        key.add(new ArrayList<Integer>(){{add(5);add(6);add(7);}});
        key.add(new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}});
        minimumTotal.minimumTotal(key);
    }
}

