package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.TreeNode;

/**
 * 1-n数字存储在二叉搜索树节点中，返回所有的不同的二叉搜索树结构
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author xiefei
 *
 */
public class UniqueBinarySearchTree2 {
	/*
	 * 解题思路：
	 * ArrayList<TreeNode>存储头结点的数组
	 * [min,max]之间返回的数的头结点列表，因此可以递归调用
	 */
    public ArrayList<TreeNode> generateTrees(int n) {
    	return generateTrees(1, n);
    }
    
    public ArrayList<TreeNode> generateTrees(int min, int max) {
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if(min > max) {
    		result.add(null);
    		return result;
    	}
    	for(int i = min; i <= max; i++) {
    		ArrayList<TreeNode> left = generateTrees(min, i-1);
    		ArrayList<TreeNode> right = generateTrees(i+1, max);
    		for(int j = 0; j < left.size(); j++) {
    			for(int k = 0; k < right.size(); k++) {
    				TreeNode root = new TreeNode(i);
    				TreeNode lchild = left.get(j);
    				TreeNode rchild = right.get(k);
    				root.left = lchild;
    				root.right = rchild;
    				result.add(root);
    			}
    		}
    	}
    	return result;
    }
    
    void print(TreeNode root){
    	if(root == null)
    		return;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	while(!q.isEmpty()) {
    		TreeNode p = q.poll();
    		System.out.print(p.val);
    		if(p.left != null)
    			q.offer(p.left);
    		if(p.right != null)
    			q.offer(p.right);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTree2 ubst = new UniqueBinarySearchTree2();
    	int n = 3;
    	ArrayList<TreeNode> result = ubst.generateTrees(n);
    	for(int i = 0; i < result.size(); i++)
    		ubst.print(result.get(i));
	}
}
