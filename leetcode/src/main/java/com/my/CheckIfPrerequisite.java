package com.my;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shanghang
 * @Project:study
 * @description:5410. 课程安排 IV
 * @Date: 2020/5/30 23:34
 **/
public class CheckIfPrerequisite {
    public static class Node{
        int curseId;
        List<Node> next;
        Node(int curseId){
            this.curseId = curseId;
        }
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        if(n<1){
            return new ArrayList<Boolean>();
        }
        //----------构建图节点---------------
        Node[] graphy = new Node[n];
        for (int i = 0 ;i<n;i++){
            graphy[i] = new Node(i);
        }
        for (int[] pre : prerequisites){
            List<Node> next = graphy[pre[0]].next;
            if(next == null){
                next = new ArrayList<Node>();
                graphy[pre[0]].next = next;
            }
            next.add(graphy[pre[1]]);
        }
        for (int[] querie :queries){
            Node nodes = graphy[querie[0]];
            result.add(get(nodes.next,querie[1]));
        }
        return result;
    }

    public boolean get(List<Node> nodes,int next){
        if(nodes == null){
            return false;
        }
        for (Node node : nodes){
            if(node.curseId == next){
                return true;
            }else {
                if(get(node.next,next)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfPrerequisite checkIfPrerequisite = new CheckIfPrerequisite();
        checkIfPrerequisite.checkIfPrerequisite(2,new int[][]{{1,0}},new int[][]{{0,1},{1,0}});
    }
}
