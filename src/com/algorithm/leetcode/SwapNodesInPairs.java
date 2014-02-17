package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * 交换链表中每2个相邻的节点
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * @author xiefei
 *
 */
public class SwapNodesInPairs {
	/*
	 * 解题思路：设置哨兵pHead=new ListNode(0),pHead.next=head;
	 * 直接遍历交换
	 */
    public ListNode swapPairs(ListNode head) {
    	if(head == null)return null;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode tail = pHead;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
        	ListNode sencond = cur.next;
        	tail.next = sencond;
        	cur.next = sencond.next;
        	sencond.next = cur;
        	tail = cur;
        	cur = cur.next;
        }
        return pHead.next;
    }
    
    public static void main(String[] args) {
    	Integer s[] = {1,2,3,4,5,6};
		LinkedList list = new LinkedList(s);
		ListNode head = list.build();
		SwapNodesInPairs sp = new SwapNodesInPairs();
		ListNode afterhead = sp.swapPairs(head);
		list.print(afterhead);
	}
}
