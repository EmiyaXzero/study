package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shang
 * @title: ListOfDepth
 * @projectName study
 * @description: TODO
 * @date 2020/4/10-17:42
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> allList = new ArrayList<>();
        getAllNode(tree,0,allList);
        return (ListNode[]) allList.toArray(new ListNode[0]);
    }

    public void getAllNode(TreeNode tree , int size , List<ListNode> allList){
        TreeNode temp = tree;
        if(tree == null){
            return;
        }
        if(allList.size() == size){
            allList.add(new ListNode(temp.val));
        }else {
            //需要到最后一个
            ListNode sizeTemp = allList.get(size);
            while(sizeTemp.next !=null){
                sizeTemp = sizeTemp.next;
            }
            sizeTemp.next = new ListNode(temp.val);
        }

        getAllNode(temp.left,size+1,allList);
        getAllNode(temp.right,size+1,allList);
    }

    public static void main(String[] args) {
        ListOfDepth listOfDepth = new ListOfDepth();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode temp  = treeNode.left;
        temp.left = new TreeNode(4);
        temp.right = new TreeNode(5);
        temp.left.left = new TreeNode(8);

        treeNode.right.right = new TreeNode(7);

        listOfDepth.listOfDepth(treeNode);
    }
}
