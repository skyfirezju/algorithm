package com.algorithm.leetcode;

import com.datastructure.util.ListNode;

/**
 * 合并两个已排序的链表
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author xiefei
 *
 */
public class MergeTwoSortedList {
	/*
	 * 解题思路：
	 *  设置head，tail指针，p1=l1,p2=l2不断扫描添加
	 *  注意其中一个链表为空的情形
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
