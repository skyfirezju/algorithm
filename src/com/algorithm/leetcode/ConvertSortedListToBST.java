package com.algorithm.leetcode;

import com.datastructure.util.ListNode;
import com.datastructure.util.TreeNode;

/**
 * �����������ת��Ϊƽ�����������
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * @author xiefei
 *
 */
public class ConvertSortedListToBST {
	/*
	 * slow��һ��,fast��2����fast==nullʱ��slowָ���м�ڵ�
	 */
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
    	if(head.next == null) {
    		TreeNode root = new TreeNode(head.val);
    		return root;
    	}
    	ListNode slow = head, fast = head.next;
    	ListNode pre = new ListNode(0);
    	pre.next = head;
    	while(fast != null) {
    		fast = fast.next;
    		if(fast != null) 
    			fast = fast.next;
    		slow = slow.next;
    		pre = pre.next;
    	}
    	TreeNode root = new TreeNode(slow.val);
    	pre.next = null;
    	TreeNode lchild = sortedListToBST(head);
    	TreeNode rchild = sortedListToBST(slow.next);
    	root.left = lchild;
    	root.right = rchild;
    	return root;
    }
}
