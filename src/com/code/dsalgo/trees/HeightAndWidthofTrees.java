package com.code.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightAndWidthofTrees {
    public static void main(String[] args) {
        TreeNode root=TreeNode.getTreeStructure();
        int height = HeightAndWidthofTrees.getHeightOfTree(root);
        System.out.println("Height of the tree: "+ height);

        int width = HeightAndWidthofTrees.getWidthOfTree(root);
        System.out.println("Width of the tree: "+ width);
    }

    public static int getHeightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = getHeightOfTree(root.left);
        int r = getHeightOfTree(root.right);

        if (l > r) {
            return l + 1;
        }
        return r + 1;
    }

    public static int getWidthOfTree(TreeNode root){

        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        treeNodeQueue.add(root);
        int max=1;
        while(!treeNodeQueue.isEmpty()){
            max=Math.max(max,treeNodeQueue.size());
            int count = treeNodeQueue.size();
            while(count > 0){
                TreeNode temp= treeNodeQueue.poll();

                if(temp.left != null){
                    treeNodeQueue.add(temp.left);
                }
                if(temp.right != null){
                    treeNodeQueue.add(temp.right);
                }
                count--;
            }
        }
        return max;
    }
}
