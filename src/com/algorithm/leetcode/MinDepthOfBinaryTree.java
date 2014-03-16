package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * ����������̸߶�
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along 
 * the shortest path from the root node down to the nearest leaf node.
 * @author xiefei
 *
 */
public class MinDepthOfBinaryTree {
	/*
	 * ����˼·��
	 * ע��������������==null������
	 */
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null) {
        	return 1 + minDepth(root.right);
        }
        if(root.right == null) {
        	return 1 + minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
