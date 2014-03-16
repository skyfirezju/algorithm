package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.TreeNode;

/**
 * 自底向上的二叉树层次遍历
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 * @author xiefei
 *
 */
public class BinaryTreeLevelOrderTraverse2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 1;
        int next = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
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
        		result.add(res);
        		res = new ArrayList<Integer>();
        		count = next;
        		next = 0;
        	} 
        }
        Collections.reverse(result);
        return result;
    }
}
