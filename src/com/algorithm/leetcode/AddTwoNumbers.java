package com.algorithm.leetcode;

import com.datastructure.util.ListNode;

/**
 * 两个链表表示非负数、逆序存储，每个节点表示单个数字，返回两个数相加的结果，用链表表示
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author xiefei
 *
 */
public class AddTwoNumbers {
	/*
	 * 解题思路：
	 * 思路1：设置pa和pb两个指针，add是进位，按位相加，循环执行
	 * 链表是尾插法，设置当前cur。相加结果val，add=val/10,cur.val = val%10
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, cur = null;
        ListNode pa = l1, pb = l2;
        int add = 0;
        while(pa != null || pb != null|| add != 0) {
        	 int val = add;
        	 if(pa != null) {
        		 val += pa.val;
        		 pa = pa.next;
        	 }
        	 if(pb != null) {
        		 val += pb.val;
        		 pb = pb.next;
        	 }
        	 add = val/10;
        	 ListNode node = new ListNode(val%10);
        	 if(result != null) {
        		 cur.next = node;
        		 cur = cur.next;
        	 } else {
        		 result = cur = node;
        	 }
        }
        return result;
    }
	
	/*
	 * 思路2：递归法，当前l1+l2结果result，后续位数相加结果more,利用result.next=more
	 * 讲链表链接起来，递归退出条件是l1=null&&l2=null&&add==0
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = addTwoNumbers2(l1, l2, 0);
        return result;
    }
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int add) {
		if(l1 == null && l2 == null && add == 0)
			return null;
        ListNode result = new ListNode(add);
        int val = add;
   	 	if(l1 != null) {
   	 		val += l1.val;
   	 	}
   	 	if(l2 != null) {
   	 		val += l2.val;
   	 	}
   	 	result.val = val%10;
   	 	ListNode more = addTwoNumbers2(l1==null?null:l1.next,
   	 		l2==null?null:l2.next,val >= 10 ? 1:0);
   	 	result.next = more;
        return result;
    }
	
}
