package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * �����������ȥ��
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author xiefei
 *
 */
public class RemoveDuplicatesFromSortedList {
	/*
	 * ����˼·��
	 * prevָ��ǰ�棬nextɨ�����Ԫ�ؿ��Ƿ����
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null)return head;
        ListNode prev = head;
        ListNode next = head.next;
        while(next != null) {
        	if(next.val != prev.val) {
        		prev.next = next;
        		prev = next;
        		next = next.next;
        	} else {
        		next = next.next;
        	}
        }
        prev.next = null;
        return head;
    }
    public static void main(String[] args) {
    	Integer list[] = {1,1,2,3,3};
		LinkedList l =  new LinkedList(list);
		ListNode head = l.build();
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		head = r.deleteDuplicates(head);
		l.print(head);
	}
}
