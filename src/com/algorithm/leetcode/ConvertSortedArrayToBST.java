package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * 把排序的数组转换为平衡二叉树
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author xiefei
 *
 */
public class ConvertSortedArrayToBST {
	/*
	 * 解题思路：
	 * 1,3=>3,1
	 * 即每次取mid=(left+right+1)/2,要向上取整而不是mid=(left+right)/2
	 */
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length-1);
    }
    public TreeNode convert(int[] num, int left, int right) {
    	if(left > right)return null;
    	if(left == right) {
    		TreeNode root = new TreeNode(num[left]);
    		root.left = null;
    		root.right = null;
    		return root;
    	}
    	int mid = (left+right+1)/2;
    	TreeNode root = new TreeNode(num[mid]);
    	TreeNode lchild = convert(num, left, mid-1);
    	TreeNode rchild = convert(num, mid+1, right);
    	root.left = lchild;
    	root.right = rchild;
    	return root;
    }
}
