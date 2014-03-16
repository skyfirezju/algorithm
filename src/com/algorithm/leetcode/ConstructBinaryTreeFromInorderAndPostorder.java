package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * 中序和后序遍历构造二叉树
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author xiefei
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
	/*
	 * 解题思路：
	 * 后序范围[postS,postE]，中序范围[inS,inE]
	 * 当postS>postE,return null;当postS==postE,返回当过节点
	 * 否则在inorder中查找postorder[postE]的位置mid,中序的左右两边再递归处理得到左右子树的跟节点
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder, postorder, 0, n-1, 0, n-1);
    }
    public TreeNode build(int[] inorder, int[] postorder,
    		int inS, int inE, int postS, int postE) {
    	if(postS == postE) {
    		TreeNode root = new TreeNode(postorder[postS]);
    		root.left = null;
    		root.right = null;
    		return root;
    	}
    	if(postS > postE) return null;
    	int i = 0;
    	for(; i < inorder.length; i++) {
    		if(inorder[i] == postorder[postE])break;
    	}
    	int mid = i;
    	TreeNode root = new TreeNode(inorder[mid]);
    	TreeNode lchild = build(inorder, postorder, inS, mid-1, postS, postS + mid - inS -1);
    	TreeNode rchild = build(inorder, postorder, mid+1, inE, postS + mid - inS, postE -1);
    	root.left = lchild;
    	root.right = rchild;
    	return root;
    }
}
