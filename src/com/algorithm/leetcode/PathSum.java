package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * 二叉树从根到叶子节点是否有路径和等于sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author xiefei
 *
 */
public class PathSum {
	/*
	 * 解题思路：
	 * 当root为叶子节点，return root.val == sum
	 * 当左右子树不为null,递归
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)return false;
    	return search(root, sum);
    }
    public boolean search(TreeNode root, int sum) {
    	boolean result = false;
    	 if(root.left != null) {
    		if(search(root.left, sum - root.val)) {
    			return true;
    		}
    	} 
    	if(root.right != null) {
    		if(search(root.right, sum - root.val)) {
    			return true;
    		}
    	} 
    	if(root.left == null && root.right == null){
    		return sum == root.val;
    	}
    	return result;
    }
}
