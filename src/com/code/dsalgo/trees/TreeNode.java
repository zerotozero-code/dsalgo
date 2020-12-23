package com.code.dsalgo.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getTreeStructure() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.left = new TreeNode(60);
        treeNode.right.right = new TreeNode(70);
        return treeNode;
    }
}
