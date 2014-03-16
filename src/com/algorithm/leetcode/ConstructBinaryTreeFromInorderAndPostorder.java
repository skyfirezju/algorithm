package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * ����ͺ���������������
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author xiefei
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
	/*
	 * ����˼·��
	 * ����Χ[postS,postE]������Χ[inS,inE]
	 * ��postS>postE,return null;��postS==postE,���ص����ڵ�
	 * ������inorder�в���postorder[postE]��λ��mid,��������������ٵݹ鴦��õ����������ĸ��ڵ�
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder, postorder, 0, n-1, 0, n-1);
    }
    public TreeNode build(int[] inorder, int[] postorder,
    		int inS, int inE, int postS, int postE) {
    	if(postS == postE) {
    		TreeNode root = new TreeNode(postorder[postS]);
    		root.left = null;
    		root.right = null;
    		return root;
    	}
    	if(postS > postE) return null;
    	int i = 0;
    	for(; i < inorder.length; i++) {
    		if(inorder[i] == postorder[postE])break;
    	}
    	int mid = i;
    	TreeNode root = new TreeNode(inorder[mid]);
    	TreeNode lchild = build(inorder, postorder, inS, mid-1, postS, postS + mid - inS -1);
    	TreeNode rchild = build(inorder, postorder, mid+1, inE, postS + mid - inS, postE -1);
    	root.left = lchild;
    	root.right = rchild;
    	return root;
    }
}
