package com.my;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author shang
 * @title: FindRestaurant
 * @projectName study
 * @description: 两个列表的最小索引总和
 * @date 2020/1/30-12:16
 */
public class FindRestaurant {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> listA = new HashMap<>();
        for (int i = 0; i <list1.length ; i++) {
            listA.put(list1[i],i);
        }
        HashMap<Integer,ArrayList<String>> result = new HashMap();
        int minKey = Integer.MAX_VALUE;
        for (int i = 0;i<list2.length;i++){
            Integer a = listA.get(list2[i]);
            if(a != null){
                int tempKey = a+i;
                if(tempKey<minKey){
                    minKey = tempKey;
                }
                ArrayList<String> tempValue = result.get(tempKey);
                if(tempValue == null){
                    tempValue = new ArrayList<String>();
                }
                tempValue.add(list2[i]);
                result.put(tempKey,tempValue);
            }
        }
        return result.get(minKey).toArray(new String[result.get(minKey).size()]);
    }

    public static void main(String[] args) {
        System.out.println(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"}).toString());
    }
}
