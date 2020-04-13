package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/4/12 22:16
 **/
public class Hanota {
    /**
     * 汉诺塔，一个盘子A-->C
     * 2个盘子 A-->B A-->C B-->C  ==> (N-1) to B  1 TO C N-1 TO C
     * 3个盘子 (A-->C A-->B  C-->A)==(N-1 TO B)  A-->C  (B-->A B-->C  A-->C)将B当作起点盘A当作辅助盘  ==> (N-1) to B  1 TO C N-1 TO C
     * n个盘子 == 首先将A上的N-1个盘子移到B上,将C当作辅助盘，然后将A的第一个盘子移到C上B当辅助盘，然后将B上面的N-1个盘子，移到C上将A当作辅助盘，递归结束的条件就是递归到第一层，将A盘上的最后一个A.SIZE-1移到C上
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
        System.out.println(C.toString());
    }

    /**
     *
     * @param size 第几层
     * @param A 起始
     * @param B 辅助
     * @param C 目标
     */
    public void move(int size , List<Integer> A, List<Integer> B, List<Integer> C){
       if(size==1){
           //因为递归的终点是将起始柱的最后一个就A.SIZE-1移到C柱子上
           C.add(A.remove(A.size()-1));
           return;
       }
       //A上的SIZE-1移到B，C当辅助柱
       move(size-1,A,C,B);
       //将A柱子第一个移到C
       move(1,A,B,C);
       //将B上的SIZE-1移到C，A当辅助
       move(size-1,B,A,C);
    }

    public static void main(String[] args) {
        Hanota h = new Hanota();

        h.hanota(new ArrayList<Integer>(){{add(2);add(1);add(0);}},new ArrayList<Integer>(),new ArrayList<Integer>());
    }
}
