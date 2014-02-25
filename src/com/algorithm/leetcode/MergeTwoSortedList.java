package com.algorithm.leetcode;

import com.datastructure.util.ListNode;

/**
 * �ϲ����������������
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author xiefei
 *
 */
public class MergeTwoSortedList {
	/*
	 * ����˼·��
	 *  ����head��tailָ�룬p1=l1,p2=l2����ɨ�����
	 *  ע������һ������Ϊ�յ�����
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode head = null, tail = null;
         ListNode p1 = l1, p2 = l2;
         while(p1 != null && p2 != null) {
        	 if(p1.val < p2.val) {
        		 if(head == null) {
        			 head = p1;
        			 tail = p1;
        		 } else {
        			 tail.next = p1;
        			 tail = p1;
        		 }
        		 p1 = p1.next;
        	 } else {
        		 if(head == null) {
        			 head = p2;
        			 tail = p2;
        		 } else {
        			 tail.next = p2;
        			 tail = p2;
        		 }
        		 p2 = p2.next;
        	 }
         }
         if(p1 != null) {
        	 if(head != null)
        		 tail.next = p1; 
        	 else
        		 head = p1;
         }
         if(p2 != null) {
        	 if(head != null) 
        		 tail.next = p2;
        	 else
        		 head = p2;
         }
         return head;
    }
}
