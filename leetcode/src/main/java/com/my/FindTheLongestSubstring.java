package com.my;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: shanghang
 * @Project:study
 * @description:1371. 每个元音包含偶数次的最长子字符串
 * @Date: 2020/5/20 22:19
 **/
public class FindTheLongestSubstring {
    public int findTheLongestSubstring(String s) {
        int[][] dp = new int[s.length()+1][5];
        for (int i = 1 ;i<=s.length();i++){
            switch (s.charAt(i-1)){
                case 'a':
                    dp[i][0] = dp[i-1][0]+1;
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2];
                    dp[i][3] = dp[i-1][3];
                    dp[i][4] = dp[i-1][4];
                    break;
                case 'e':
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1]+1;
                    dp[i][2] = dp[i-1][2];
                    dp[i][3] = dp[i-1][3];
                    dp[i][4] = dp[i-1][4];
                    break;
                case 'i':
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2]+1;
                    dp[i][3] = dp[i-1][3];
                    dp[i][4] = dp[i-1][4];
                    break;
                case 'o':
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2];
                    dp[i][3] = dp[i-1][3]+1;
                    dp[i][4] = dp[i-1][4];
                    break;
                case 'u':
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2];
                    dp[i][3] = dp[i-1][3];
                    dp[i][4] = dp[i-1][4]+1;
                    break;
                default:
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] = dp[i-1][2];
                    dp[i][3] = dp[i-1][3];
                    dp[i][4] = dp[i-1][4];
                    break;
            }
        }
        if(isOu(dp[s.length()][0]) &&
                isOu(dp[s.length()][1]) &&
                isOu(dp[s.length()][2]) &&
                isOu(dp[s.length()][3]) &&
                isOu(dp[s.length()][4]) ){
            return s.length();
        }
        int max = 0;
        if(isOu(dp[1][0]) &&
                isOu(dp[1][1]) &&
                isOu(dp[1][2]) &&
                isOu(dp[1][3]) &&
                isOu(dp[1][4]) ){
            max = 1;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = i+1;j<dp.length;j++){
                if(isOu(dp[j][0]) &&
                        isOu(dp[j][1]) &&
                        isOu(dp[j][2]) &&
                        isOu(dp[j][3]) &&
                        isOu(dp[j][4]) ){
                    max = Math.max(max,j);
                }
//                if((dp[j][0] - dp[i][0] == 0?isOu(dp[j][0]):isOu(dp[j][0]-dp[i][0]))&&
////                        (dp[j][1] - dp[i][1] == 0?isOu(dp[j][1]):isOu(dp[j][1]-dp[i][1]))&&
////                        (dp[j][2] - dp[i][2] == 0?isOu(dp[j][2]):isOu(dp[j][2]-dp[i][2]))&&
////                        (dp[j][3] - dp[i][3] == 0?isOu(dp[j][3]):isOu(dp[j][3]-dp[i][3]))&&
////                        (dp[j][4] - dp[i][4] == 0?isOu(dp[j][4]):isOu(dp[j][4]-dp[i][4]))){
////                    max = Math.max(max,j-i);
////                }
                if((isOu(dp[j][0]-dp[i][0]))&&
                        (isOu(dp[j][1]-dp[i][1]))&&
                        (isOu(dp[j][2]-dp[i][2]))&&
                        (isOu(dp[j][3]-dp[i][3]))&&
                        (isOu(dp[j][4]-dp[i][4]))){
                    max = Math.max(max,j-i);
                }
            }
        }
        return max;
    }

    public int findTheLongestSubstringForOnce(String s) {
        int length = s.length();
        //pos保存状态码的下标值
        int[] pos = new int[1<<5];
        Arrays.fill(pos,-1);
        int ans = 0 ,status = 0;
        pos[0] = 0;
        //五位数表示奇偶
        for (int i = 0;i<length;i++){
            switch (s.charAt(i)){
                case 'a':
                    //异或运算判断奇偶，1表示奇数0表示偶数，因为异或相等为0则为偶数
                    status^=1<<0;
                    break;
                case 'e':
                    status^=1<<1;
                    break;
                case 'i':
                    status^=1<<2;
                    break;
                case 'o':
                    status^=1<<3;
                    break;
                case 'u':
                    status^=1<<4;
                    break;
                default:
                    break;
            }
            //因为奇偶是连续的
            if(pos[status] >=0){
                ans = Math.max(ans,i+1-pos[status]);
            }else {
                pos[status] = i+1;
            }
        }
        return ans;
    }


    boolean isOu(int i){
        return (i&1)==0;
    }

    public static void main(String[] args) {
        FindTheLongestSubstring findTheLongestSubstring = new FindTheLongestSubstring();
        findTheLongestSubstring.findTheLongestSubstring("id");
    }
}
