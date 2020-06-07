package com.my;


import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: shanghang
 * @Project:study
 * @Date: 2020/3/28 19:53
 **/
public class MinimumLengthEncoding {
    /**
     * 将数组按大小排序，然后判断是否存在对应后缀
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 1){
            return words[0].length()+1;
        }else {
            Arrays.sort(words,new rule());
            String result = words[words.length-1]+"#";
            for(int i = words.length-2 ;i>=0;i--){
                if(result.contains(words[i]+"#")){
                    continue;
                }else {
                    result+=words[i]+"#";
                }
            }
            return result.length();
        }
    }

    class rule implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length()-o2.length();
        }
    }

    public static void main(String[] args) {
        MinimumLengthEncoding o = new MinimumLengthEncoding();
        o.minimumLengthEncoding2(new String[]{"time", "me", "bell"});
    }

    /**
     * 根据Hashset去除重复的后缀字符串
     * @param words
     * @return
     */
    public int minimumLengthEncoding1(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        //然后过滤存在的set
        for (String word : words) {
            for (int i = 1 ; i<word.length();i++){
                //将word i后缀的都去掉
                set.remove(word.substring(i));
            }
        }

        int result = 0 ;
        for (String s : set) {
            result+=s.length()+1;
        }
        return result;
    }

    /**
     * 字典树
     */
    public int minimumLengthEncoding2(String[] words) {
        int result = 0 ;
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();
        int j = 0;
        for (String word : words) {
            TrieNode cur = trie;
            for (int i = word.length()-1 ; i>=0;i--){
                //字符串的字典树
                cur = cur.get(word.charAt(i));
            }
            //保存字符串最后一个字符节点
            nodes.put(cur,j);
            j++;
        }
        for (TrieNode trieNode : nodes.keySet()) {
            if(trieNode.count == 0 ){
                //如果是叶子节点则取字符串长度
                result += words[nodes.get(trieNode)].length()+1;
            }
        }
        return result;
    }

    class TrieNode{
        private TrieNode[] childTree;
        int count;
        TrieNode(){
            //26个字符
            childTree = new TrieNode[26];
            //0表示叶子节点
            count = 0;
        }

        public TrieNode get(char c){
            if(childTree[c-'a'] == null){
                childTree[c-'a'] = new TrieNode();
                count++;
            }
            return childTree[c-'a'];
        }
    }
}
