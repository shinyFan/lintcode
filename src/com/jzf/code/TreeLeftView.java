package com.jzf.code;

import com.jzf.definition.TreeNode;

import java.util.List;

public class TreeLeftView {
    public static void main(String[] args) {

    }
    void treeLeftView(TreeNode treeNode, List<Integer> list,int level){
        if(treeNode!=null){
            if(level==list.size()){
                level++;
                list.add(treeNode.val);
            }
            treeLeftView(treeNode.left,list,level);
            treeLeftView(treeNode.right,list,level);
        }
    }
}
