package com.my;

import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5414. 收藏清单
 * @Date: 2020/5/17 10:48
 **/
public class PeopleIndexes {
    static class Pojo{
        int idx;
        List<String> strings;

        Pojo(int idx , List<String> strings){
            this.idx = idx;
            this.strings = strings;
        }
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> results = new ArrayList<>();
        Pojo[] pojos = new Pojo[favoriteCompanies.size()];
        for (int i = 0 ;i<favoriteCompanies.size();i++){
            pojos[i] = new Pojo(i,favoriteCompanies.get(i));
        }
        Arrays.sort(pojos, new Comparator<Pojo>() {
            @Override
            public int compare(Pojo o1, Pojo o2) {
                return o1.strings.size()-o2.strings.size();
            }
        });
        for (int i = 0 ;i<pojos.length;i++){
            boolean flag = true;
            for (int j = i+1;j<pojos.length;j++){
                int samInt = 0;
                for (int z = 0;z<pojos[i].strings.size();z++){
                    for (int x = 0;x<pojos[j].strings.size();x++){
                        if(pojos[i].strings.get(z) .equals(pojos[j].strings.get(x))){
                            samInt++;
                        }
                    }
                }
                if(samInt == pojos[i].strings.size()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                results.add(pojos[i].idx);
            }
        }

        Collections.sort(results, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return results;
    }

    public List<Integer> peopleIndexesBySet(List<List<String>> favoriteCompanies) {
        List<Integer> results = new ArrayList<>();
        List<Set<String>> sets = new ArrayList<>();
        for (int i = 0 ;i<favoriteCompanies.size();i++){
            Set<String> set = new HashSet<>();
            for (int j = 0 ;j<favoriteCompanies.get(i).size();j++){
                set.add(favoriteCompanies.get(i).get(j));
            }
            sets.add(set);
        }
        for (int i = 0 ;i<favoriteCompanies.size();i++){
            boolean flag = true;
            for (int j = 0 ;j<favoriteCompanies.size();j++){
                if(i == j || sets.get(i).size()>sets.get(j).size()){
                    continue;
                }
                if(sets.get(j).containsAll(sets.get(i))){
                    flag = false;
                    break;
                }
            }
            if (flag){
                results.add(i);
            }
        }
        return results;
    }
}
