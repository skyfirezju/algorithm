package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 �� m �� n �� length of list.
 * @author xiefei
 *
 */
public class ReverseLinkedList2 {
	/*
	 * first�ǵ�m��Ԫ�أ�prevָ��ǰ��һ��Ԫ�أ�cur��ǰ��next��һ��
	 * �ӵ�m��ָ�뿪ʼ��ָ��ת�����ƴ����β
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode prev = preHead, cur = head, next = cur.next;
        int dis = n - m;
        while(--m > 0) {
        	prev = prev.next;
        	cur = cur.next;
        	next = next.next;
        }
        ListNode first = cur;
        while(dis-- > 0) {
        	ListNode temp = next.next;
        	next.next = cur;
        	cur = next;
        	next = temp;
        }
    	first.next = next;
    	prev.next = cur;
        return preHead.next;
    }
    public static void main(String[] args) {
    	ReverseLinkedList2 r = new ReverseLinkedList2();
    	Integer list[] = {1,2,3,4,5};
    	LinkedList l = new LinkedList(list);
    	ListNode head = l.build();
    	int m = 2, n = 3;
    	head = r.reverseBetween(head, m, n);
    	l.print(head);
	}
}
