package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * @author shanghang
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i =0 ;i<numRows;i++){
            List<Integer> temp = new ArrayList<>(i+1);
            for (int j=0 ;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }else{
                    temp.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }
}
