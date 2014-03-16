package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.TreeNode;

/**
 * 二叉树zigzag形式层次遍历
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author xiefei
 *
 */
public class BinaryTreeZigzagLevelOrderTraverse {
	/*
	 * 解题思路：
	 * 添加的时候根据行数是偶数reverse
	 */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 1;
        int next = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean odd = true;
        while(!q.isEmpty()){
        	TreeNode p = q.poll();
        	res.add(p.val);
    		if(p.left != null) {
        		q.offer(p.left);
        		next++;
        	}
        	if(p.right != null) {
        		q.offer(p.right);
        		next++;
        	}
        	count--;
        	if(count == 0) {
        		if(!odd)
        			Collections.reverse(res);
        		result.add(res);
        		res = new ArrayList<Integer>();
        		count = next;
        		next = 0;
        		odd = !odd;
        	} 
        }
        return result;
    }
}
