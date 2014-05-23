package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return 6.
 * @author xiefei
 *
 */
public class BinaryTreeMaximumPathSum {
	class NodeInfo {
		public int maxVal;
		public int maxFromRoot;
		public NodeInfo() {
			maxVal = Integer.MIN_VALUE;
			maxFromRoot = Integer.MIN_VALUE;
		}
	}
    public int maxPathSum(TreeNode root) {
        NodeInfo res = dfs(root);
        return res.maxVal;
    }
    public NodeInfo dfs(TreeNode node) {
    	NodeInfo root = new NodeInfo();
    	NodeInfo left = new NodeInfo();
    	NodeInfo right = new NodeInfo();
    	if(node == null) 
    		return root;
    	if(node.left != null) {
    		left = dfs(node.left);
    	}
    	if(node.right != null) {
    		right = dfs(node.right);
    	}
    	int l = Math.max(0, left.maxFromRoot);
    	int r = Math.max(0, right.maxFromRoot);
    	root.maxFromRoot = node.val + Math.max(0, Math.max(l, r));
    	root.maxVal = Math.max(left.maxVal, right.maxVal);
    	root.maxVal = Math.max(root.maxVal, l + r + node.val);
    	return root;
    }
}
