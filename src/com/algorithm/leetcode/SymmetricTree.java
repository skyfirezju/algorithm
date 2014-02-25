package com.algorithm.leetcode;

import java.util.Stack;

import com.datastructure.util.TreeNode;

/**
 * �ж�һ�����Ƿ��Լ�����Գ�
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @author xiefei
 *
 */
public class SymmetricTree {
	/*
	 * ����˼·��
	 * �������������������ջS�У������������������ջ�ȽϿ��Ƿ���ͬ
	 */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        inorder(root.left, s1);
        return inorderCheck(root.right, s1);
    }
    public boolean inorderCheck(TreeNode root, Stack<TreeNode> s) {
    	if(root == null) {
    		if(s.isEmpty()) 
    			return true;
    		else
    			return false;
    	}
    	if(s.isEmpty()) return false;
    	return inorderCheck(root.left, s)
    			&& (root == s.pop())
    			&& inorderCheck(root.right, s);
    }
    public void inorder(TreeNode root, Stack<TreeNode> s) {
    	if(root == null) return;
    	inorder(root.left, s);
    	s.push(root);
    	inorder(root.right, s);
    }
    
    /*
     * ˼·2��
     * �������ҵ���reverse.Ȼ��reverse��root�Ƿ�ͬһ����
     */
    public boolean isSymmetric1(TreeNode root) {
    	if(root == null) return true;
    	TreeNode reverse = reverse(root);
    	return isSameTree(root, reverse);
    }
    
    public TreeNode reverse(TreeNode root) {
    	if(root == null)return null;
    	TreeNode reverse = new TreeNode(root.val);
    	reverse.right = reverse(root.left);
    	reverse.left = reverse(root.right);
    	return reverse;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
        	return true;
        } else if(p != null && q != null) {
        	return (p.val == q.val)&& (isSameTree(p.left, q.left))
        			&& (isSameTree(p.right, q.right));
        } else {
        	return false;
        }
    }
}
