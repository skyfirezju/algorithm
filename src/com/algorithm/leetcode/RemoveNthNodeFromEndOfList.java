package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * �Ƴ���������N���ڵ㣬ֻ�ܱ���1������
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * @author xiefei
 *
 */
public class RemoveNthNodeFromEndOfList {
	/*
	 * ����˼·�����ǵ�ͷ��㣬��������ָ�룬prev=head��next�������N������ͬʱ�ƶ�
	 * nextָ��β�ڵ�ʱ��prevָ������N���ڵ��ǰһ���ڵ㣬�ú�ɾ���ڵ㣬
	 * ���������ֻ��1���ڵ�,OJ����next.next��ָ��
	 * [ע��]leetcode��ͷ����ǵ�һ���ڵ�
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
