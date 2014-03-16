package com.algorithm.leetcode;

import java.util.ArrayList;

import com.datastructure.util.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @author xiefei
 *
 */
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root == null)return result;
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	search(result, res, root, sum);
    	return result;
    }
    public void search(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> res, 
    		TreeNode root, int sum){
    	res.add(root.val);
    	if(root.left == null && root.right == null){
	   		if(sum == root.val){
	   			//数组是存引用,res会被删除
	   			ArrayList<Integer> rescopy = new ArrayList<Integer>(res);
	   			result.add(rescopy);
	   		}
	   		res.remove(res.size()-1);
	   		return;
	   	}
	   	if(root.left != null) {
	   		search(result, res, root.left, sum - root.val);
	   	} 
	   	if(root.right != null) {
	   		search(result, res, root.right, sum - root.val);
	   	} 
	   	res.remove(res.size()-1);
    }
    public static void main(String[] args) {
    	PathSum2 ps = new PathSum2();
    	TreeNode root = new TreeNode(5);
    	TreeNode p1 = new TreeNode(4);
    	TreeNode p2 = new TreeNode(8);
    	root.left = p1;
    	root.right = p2;
    	TreeNode p3 = new TreeNode(11);
    	TreeNode p4 = new TreeNode(13);
    	TreeNode p5 = new TreeNode(4);
    	p1.left = p3;
    	p2.left = p4;
    	p2.right = p5;
    	TreeNode p6 = new TreeNode(7);
    	TreeNode p7 = new TreeNode(2);
    	p3.left = p6;
    	p3.right = p7;
    	TreeNode p8 = new TreeNode(5);
    	TreeNode p9 = new TreeNode(1);
    	p5.left = p8;
    	p5.right = p9;
    	int sum = 22;
    	ArrayList<ArrayList<Integer>> result = ps.pathSum(root, sum);
    	System.out.println(result);
	}
}
