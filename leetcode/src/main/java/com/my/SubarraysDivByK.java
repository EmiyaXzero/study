package com.my;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shang
 * @title: SubarraysDivByK
 * @projectName study
 * @description: 和可被 K 整除的子数组
 * @date 2020/5/27-18:07
 */
public class SubarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            int modulus =(sum % K +K)%K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
    public int subarraysDivByK2(int[] A, int K) {
        int[] sum = new int[A.length+1]; sum[0] = 0;
        int result = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = A[i-1] + sum[i-1];
        }
        for (int i=0;i<A.length;i++){
            for (int j = i+1;j<=A.length;j++){
                if((sum[j]-sum[i])%K==0){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraysDivByK subarraysDivByK = new SubarraysDivByK();
        subarraysDivByK.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
    }
}
