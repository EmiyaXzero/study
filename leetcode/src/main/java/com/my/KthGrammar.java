package com.my;

/**
 * @author shang
 * @title: KthGrammar
 * @projectName study
 * @description: 第K个语法符号
 * @date 2020/1/15-10:44
 */
public class KthGrammar {
    public static int kthGrammar(int N, int K) {
        return (getStr(N,K));
    }

    /**
     * 想要知道(N,K) ，那么需要获取到(N-1,preK)是0还是1就好
     * @param N
     * @param k
     * @return
     */
    public static int getStr(int N,int k){
        if(N == 1 ){
            return 0;
        }else{
           boolean isJi = k%2==1;
           int y = (k-1)/2;
           int result = getStr(N-1,y+1);
           if(result == 0){
               if (isJi){
                   return 0;
               }else {
                   return 1;
               }
           }else {
               if (isJi){
                   return 1;
               }else {
                   return 0;
               }
           }
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        kthGrammar(5,
                1);
        System.out.println(System.currentTimeMillis() - t1);
    }
}
