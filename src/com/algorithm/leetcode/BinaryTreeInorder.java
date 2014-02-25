package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.datastructure.util.TreeNode;


/**
 * ÖÐÐò±éÀú¶þ²æÊ÷
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author xiefei
 *
 */
public class BinaryTreeInorder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) 
        	return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(p!= null || !s.isEmpty()) {
        	while(p != null) {
        		s.push(p);
        		p = p.left;
        	}
        	if(!s.isEmpty()) {
        		p = s.pop();
        		result.add(p.val);
        		p = p.right;
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(6);
		root.left = p1;
		root.right = p2;
		TreeNode p3 = new TreeNode(1);
		TreeNode p4 = new TreeNode(3);
		p1.left = p3;
		p1.right = p4;
		TreeNode p5 = new TreeNode(5);
		TreeNode p6 = new TreeNode(7);
		p2.left = p5;
		p2.right= p6;
		BinaryTreeInorder bti = new BinaryTreeInorder();
		//System.out.println(root.val);
		ArrayList<Integer> result = bti.inorderTraversal(root);
		System.out.println(result);
	}
}
