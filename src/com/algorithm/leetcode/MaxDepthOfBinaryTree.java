package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * 二叉树的最大深度
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along 
 * the longest path from the root node down to the farthest leaf node.
 * @author xiefei
 *
 */
public class MaxDepthOfBinaryTree {
	/*
	 * 解题思路：
	 * 递归，左子树和右子树深度的最大值+1
	 */
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
