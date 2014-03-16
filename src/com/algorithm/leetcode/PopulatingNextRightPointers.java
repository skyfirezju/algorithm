package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructure.util.TreeLinkNode;

/**
 * Given a binary tree
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *         1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * @author xiefei
 *
 */
public class PopulatingNextRightPointers {
	/*
	 * 解题思路：层次遍历的时候设置一个前节点prev，按层次遍历的顺序改变next指针
	 */
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        int count = 1;
        int next = 0;
        TreeLinkNode prev = null;
        while(!q.isEmpty()) {
        	TreeLinkNode p = q.poll();
        	if(prev != null) {
        		prev.next = p;
        		prev = p;
        	} else {
        		prev = p;
        	}
        	if(count == 1) {
        		p.next = null;
        	} 
        	count--;
        	if(p.left != null) {
        		q.offer(p.left);
        		next++;
        	}
        	if(p.right != null) {
        		q.offer(p.right);
        		next++;
        	}
        	if(count == 0) {
        		count = next;
        		next = 0;
        		prev = null;
        	}
        }
    }
}
