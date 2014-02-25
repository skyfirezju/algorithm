package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * �����Ƿ���Ч�Ķ���������
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @author xiefei
 *
 */
public class ValidBST {
	
	/*
	 * ����˼·��
	 * ���͵Ĵ���ⷨ��
	 * ��߽ڵ�С���ұ߽ڵ�󣬶�ʵ���϶���������Ҫ����������������ڵ㶼С�ڸ��ڵ�
	 * �����������ڵ㶼���ڸ��ڵ�
	 */
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        if(root.left != null && root.left.val >= root.val)
        	return false;
        if(root.right != null && root.right.val <= root.val)
        	return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    /*
     * ˼·2��
     * ���������ֵmaxBST(root.left)<root.val
     * ��������СֵminBST(root.right)>root.val
     */
    public boolean isValidBST1(TreeNode root) {
    	if(root == null)return true;
        if(root.left != null && maxBST(root.left) >= root.val)
        	return false;
        if(root.right != null && minBST(root.right) <= root.val)
        	return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    public int maxBST(TreeNode root) {
    	int result = root.val;
    	int left = Integer.MIN_VALUE;
    	int right = Integer.MIN_VALUE;
    	if(root.left != null) {
    		left = maxBST(root.left);
    		if(left > result)result = left;
    	}
    	if(root.right != null) {
    		right = maxBST(root.right);
    		if(right > result)result = right;
    	}
    	return result;
    }
    
    public int minBST(TreeNode root) {
    	int result = root.val;
    	int left = Integer.MIN_VALUE;
    	int right = Integer.MIN_VALUE;
    	if(root.left != null) {
    		left = minBST(root.left);
    		if(left < result)result = left;
    	}
    	if(root.right != null) {
    		right = minBST(root.right);
    		if(right < result)result = right;
    	}
    	return result;
    }
    
    /*
     * ˼·3��
     */
    public boolean isValidBST2(TreeNode root) {
    	return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int min, int max) {
    	if(root == null)return true;
    	return (root.val > min && root.val < max)
    			&& isValidBST(root.left, min, root.val)
    			&& isValidBST(root.right, root.val, max);
    }
    
    public static void main(String[] args) {
		
	}
}
