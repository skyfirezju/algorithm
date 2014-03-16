package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * ��֤�������Ƿ���ƽ�⣬���������������������1
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * @author xiefei
 *
 */
public class BalancedBinaryTree {
	
	/*
	 * ����˼·��
	 * ���������ĸ߶Ȳ�>1��ֱ�ӷ���false
	 * ���򷵻�����������ƽ���&&
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
