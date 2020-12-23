package com.code.dsalgo.trees;

import java.util.Stack;

/**
 * This class has the Preorder,Inorder and Post order Traversal
 *
 *           10
 *      20       30
 * 40      50 60     70
 *
 */
public class TreeTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.getTreeStructure();
        TreeTraversal treeTraversal = new TreeTraversal();
        //treeTraversal.inOrder(treeNode);
        //treeTraversal.inOrderIterative(treeNode);
        //treeTraversal.preOrder(treeNode);
        //treeTraversal.preOrderIterative(treeNode);
        treeTraversal.postOrder(treeNode);
        treeTraversal.postOrderIterative(treeNode);
    }

    /**
     * In Order in recursive way
     * Left -> Root -> Right
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void inOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;

        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    /**
     * Pre Order in recursive way
     * Root-> Left -> Right
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderIterative(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp= stack.pop();
            System.out.println(temp.val);
            if(temp.right !=null){
                stack.push(temp.right);
            }
            if(temp.left !=null){
                stack.push(temp.left);
            }
        }

    }

    /**
     * Post Order in recursive way
     * Left -> Right -> Root
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public void postOrderIterative(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        Stack<TreeNode> out=new Stack<>();
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            out.push(temp);

            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right !=null){
                stack.push(temp.right);
            }
        }

        out.stream().map(e->e.val).forEach(System.out::println);
        while(!out.isEmpty()){
            System.out.print(out.pop().val+"-");
        }
    }
}
