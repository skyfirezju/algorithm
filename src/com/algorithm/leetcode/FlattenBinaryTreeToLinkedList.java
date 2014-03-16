package com.algorithm.leetcode;

import java.util.Stack;

import com.datastructure.util.TreeNode;

/**
 * 二叉树转换为链表（先序顺序）
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * @author xiefei
 *
 */
public class FlattenBinaryTreeToLinkedList {
	/*
	 * 解题思路：pre记录先序遍历的最后一个节点
	 * 思路有问题
	 */
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    public void flatten(TreeNode root, TreeNode pre) {
    	if(root == null)return;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.left = null;
    	if(left != null) {
    		root.right = left;
        	flatten(left , pre);
    	}
    	if(pre != null)
    		pre.right = right;
    	pre = root;
    	if(right != null) {
    		flatten(right, pre);
    	}
    }
    /*
     * 思路2：非递归先序便利
     */
    public void flatten1(TreeNode root) {
    	if(root == null)return;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	s.push(root);
    	TreeNode flattenNode = null;
    	while(!s.isEmpty()) {
    		TreeNode node = s.pop();
    		if(node.right != null) {
    			s.push(node.right);
    			node.right = null;
    		}
    		if(node.left != null) {
    			s.push(node.left);
    			node.left = null;
    		}
    		if(flattenNode != null) {
    			flattenNode.right = node;
    			flattenNode = flattenNode.right;
    		} else {
    			flattenNode = node;
    		}
    	}
    }
    public static void main(String[] args) {
    	FlattenBinaryTreeToLinkedList fi = new FlattenBinaryTreeToLinkedList();
    	TreeNode root = new TreeNode(1);
    	TreeNode p1 = new TreeNode(2);
    	TreeNode p2 = new TreeNode(5);
    	root.left = p1;
    	root.right = p2;
    	TreeNode p3 = new TreeNode(3);
    	TreeNode p4 = new TreeNode(4);
    	p1.left = p3;
    	p1.right = p4;
    	TreeNode p5 = new TreeNode(6);
    	p2.right = p5;
    	fi.print(root);
    	fi.flatten1(root);
    	fi.print(root);
//    	while(root != null) {
//    		System.out.println(root.val);
//    		root = root.right;
//    	}
	}
    public void print(TreeNode root) {
    	for(int i = 1; i <= depth(root); i++) {
    		print(root, i);
    	}
    	System.out.println();
    }
    
    public void print(TreeNode root, int level) {
    	if(level == 1){
    		if(root != null)
    			System.out.print(root.val);
    		else
    			System.out.print("#");
    		return;
    	}
    	if(root != null){
    		print(root.left, level-1);
    		print(root.right, level-1);
    	}
    }
    public int depth(TreeNode root) {
    	if(root == null)return 0;
    	return Math.max(depth(root.left), depth(root.right))+1;
    }
}
