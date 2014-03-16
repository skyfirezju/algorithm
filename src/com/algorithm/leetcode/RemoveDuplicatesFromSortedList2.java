package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * �������������ȥ���ظ���Ԫ�أ�ֻ���²�ͬ��Ԫ��
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author xiefei
 *
 */
public class RemoveDuplicatesFromSortedList2 {
	/*
	 * ����˼·��
	 * tailָʾĩβ��preTail������β�����ݣ�prev���ڱȽ��Ƿ��ظ�
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null)return null;
        ListNode prev = head, cur = head.next;
        ListNode tail = head, preTail = head;
        while(cur != null) {
        	if(cur.val != prev.val) {
        		if(head == null) {
        			//System.out.println(cur.val);
        			head = cur;
        			tail = cur;
        			prev = cur;
        			preTail = null;
        		} else {
        			preTail = tail;
        			tail.next = cur;
        			tail = cur;
        			prev = cur;
        		}
        	} else {
        		if(prev == head) {
        			head = null;
        		}
        		if(preTail == null) {
        			head = null;
        			tail = null;
        		} else {
        			tail = preTail;
        			tail.next = null;
        		}
        	}
        	cur = cur.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesFromSortedList2 r = new RemoveDuplicatesFromSortedList2();
    	Integer list[] = {1,1,1,2,2,3,3,4,5};
    	LinkedList l = new LinkedList(list);
    	ListNode head = l.build();
    	head = r.deleteDuplicates(head);
    	l.print(head);
	}
}
