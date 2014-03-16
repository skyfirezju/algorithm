package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * 验证二叉树是否是平衡，任意左右子树深度相差不超过1
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * @author xiefei
 *
 */
public class BalancedBinaryTree {
	
	/*
	 * 解题思路：
	 * 左右子树的高度差>1，直接返回false
	 * 否则返回左右子树的平衡的&&
	 */
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) {
        	return false;
        } 
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
    	if(root == null)return 0;
    	return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
