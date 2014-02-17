package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * 移除链表倒数第N个节点，只能遍历1遍链表
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author xiefei
 *
 */
public class RemoveNthNodeFromEndOfList {
	/*
	 * 解题思路：考虑到头结点，设置两个指针，prev=head和next，间隔是N，两个同时移动
	 * next指向尾节点时，prev指向倒数第N个节点的前一个节点，让后删除节点，
	 * 特殊情况是只有1个节点,OJ出错，next.next空指针
	 * [注意]leetcode上头结点是第一个节点
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode prev = head, next = head;
        while((n--)!=0 && next != null)
        	next = next.next;
        if(next == null)
        	return head.next;
        while(next.next != null) {
        	prev = prev.next;
        	next = next.next;
        }
        if(prev.next != null) {
        	prev.next = prev.next.next;
        }
        return head;
    }
    
    /*
     * 
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
    	//ListNode sentiel = new ListNode(0);
    	//sentiel.next = head;
    	if(head == null)
    		return null;
    	ListNode prev = head, next = head.next;
        while((n--)!=0 && next != null)
        	next = next.next;
        if(next == null)
        	return head;
        while(next != null) {
        	prev = prev.next;
        	next = next.next;
        }
        if(prev != null && prev.next != null) {
        	prev.next = prev.next.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
    	Integer list[] = {1,2,3,4,5};
		LinkedList ll = new LinkedList(list);
		ListNode head = ll.build();
		ll.print(head);
		System.out.println();
		RemoveNthNodeFromEndOfList rnl = new RemoveNthNodeFromEndOfList();
		int n = 6;
		ListNode removed = rnl.removeNthFromEnd(head, n);
		ll.print(removed);
	}
}
