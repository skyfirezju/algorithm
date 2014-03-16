package com.algorithm.leetcode;

import com.datastructure.util.TreeNode;

/**
 * ǰ�������������������
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author xiefei
 *
 */
public class ConstructBinaryTreeFromPreAndInorder {
	/*
	 * ����˼·��
	 * ǰ��Χ[preS,preE]������Χ[inS,inE]
	 * ��preS>preE,return null;��preS==preE,���ص����ڵ�
	 * ������inorder�в���preorder[preS]��λ��mid,��������������ٵݹ鴦��õ����������ĸ��ڵ�
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int lenpre = preorder.length;
    	int lenin = inorder.length;
    	return build(preorder, inorder, 0, lenpre-1, 0, lenin -1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int preS, int preE,
    		int inS, int inE) {
    	if(preS == preE) {
    		TreeNode root = new TreeNode(preorder[preS]);
    		root.left = null;
    		root.right = null;
    		return root;
    	}
    	if(preS > preE) return null;
    	int i = 0;
    	for(; i < inorder.length; i++) {
    		if(inorder[i] == preorder[preS])break;
    	}
    	int mid = i;
    	TreeNode root = new TreeNode(inorder[mid]);
    	TreeNode lchild = build(preorder, inorder, preS+1, preS + mid - inS, inS, mid-1);
    	TreeNode rchild = build(preorder, inorder, preS + mid - inS +1, preE, mid+1, inE);
    	root.left = lchild;
    	root.right = rchild;
    	return root;
    }
}
