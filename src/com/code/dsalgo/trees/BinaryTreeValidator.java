package com.code.dsalgo.trees;

/**
 * To check Valid Binary Tree
 */
public class BinaryTreeValidator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(60);
        root.left = new TreeNode(40);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(50);
        System.out.println("is Valid Binary Search Tree:" + isBinarySearchTree(root));
    }

    public static boolean isBinarySearchTree(TreeNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinarySearchTree(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val < minValue || root.val > maxValue) {
            return false;
        }

        return isBinarySearchTree(root.left, minValue, root.val - 1) && isBinarySearchTree(root.right, root.val + 1, maxValue);
    }
}
