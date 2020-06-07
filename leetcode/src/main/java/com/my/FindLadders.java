package com.my;

import java.util.*;

/**
 * @author shanghang
 * @title: FindLadders
 * @projectName study
 * @description: 126. 单词接龙 II
 * @date 2020/6/7-13:56
 */
public class FindLadders {
    private static final int INF = 1<<20;
    /**
     * 单词到号码的映射
     */
    private Map<String,Integer> wordId = new HashMap<>();
    /**
     * id到单词的映射
     */
    private List<String> idWord = new ArrayList<>();
    /**
     * 图的边
     */
    private ArrayList<Integer>[] edges;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        //将wordList所有单词加入wordId中相同的只保留一个//并为每一个单词分配一个id
        for (String word:wordList){
            if(!wordId.containsKey(word)){
                wordId.put(word,id++);
                idWord.add(word);
            }
        }
        // 若endWord不在wordList中 则无解
        if(!wordId.containsKey(endWord)){
            return new ArrayList<>();
        }
        //把beginWord也加入到wordList中
        if(!wordId.containsKey(beginWord)){
            wordId.put(beginWord,id++);
            idWord.add(beginWord);
        }
        //-------------------构造图-------------------------
        //初始化图数组
        edges = new ArrayList[idWord.size()];
        for (int i = 0;i<idWord.size();i++){
            edges[i] = new ArrayList<>();
        }
        //添加边
        for (int i = 0 ;i<idWord.size();i++){
            for (int j=i+1;j<idWord.size();j++){
                if(transformCheck(idWord.get(i),idWord.get(j))){
                    //建立无向边
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        //-------------------构造图结束-------------------------
        //目的Id
        int dest = wordId.get(endWord);
        List<List<String>> result = new ArrayList<>();
        int[] cost = new int[id];
        //将代价设置为无穷大
        Arrays.fill(cost,INF);
        // 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)]=0;

        //开始广度优先搜索
        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.poll();
            int last = cur.get(cur.size()-1);
            if (last == dest){
                //到终点了
                ArrayList<String> temp = new ArrayList<>();
                for (int index : cur){
                    //获取map中的str
                    temp.add(idWord.get(index));
                }
                result.add(temp);
            }else {
                //不是终点继续添加
                for (int i = 0 ;i<edges[last].size();i++){
                    //获取无向图关联节点
                    int to = edges[last].get(i);
                    //此处<=目的在于把代价相同的不同路径全部保留下来
                    if(cost[last]+1<=cost[to]){
                        cost[to] = cost[last]+1;
                        //把to放入到路径中
                        ArrayList<Integer> tmp = new ArrayList<>(cur);
                        tmp.add(to);
                        //把tmp加入到队列中
                        q.add(tmp);
                    }
                }
            }
        }
        return result;
    }


    boolean transformCheck(String str1,String str2){
        int differences = 0;
        for (int i = 0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                differences++;
                if (differences>1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        findLadders.findLadders("hit","cog",new ArrayList<String>(){
            {add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");}});
    }
}
