package com.algorithm.leetcode;

import java.util.ArrayList;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * 合并k个已排序的链表，返回为1个排序的链表，分析复杂度
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * @author xiefei
 *
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int n = lists.size();
        if(n == 0)
        	return null;
        if(n == 1)
        	return lists.get(0);
        ListNode result = new ListNode(0);
        result.next = lists.get(0);
        for(int i = 1; i < n; i++) {
        	merge(result, lists.get(i));
        }
        return result.next;
    }
    public void merge(ListNode head1, ListNode head2) {
    	ListNode cur = head1;
    	ListNode p1 = head1.next, p2 = head2;
    	while(p1 != null && p2 != null) {
    		if(p1.val < p2.val) {
    			cur.next = p1;
    			cur = p1;
    			p1 = p1.next;
    		} else {
    			cur.next = p2;
    			cur = p2;
    			p2 = p2.next;
    		}
    	}
    	if(p1 != null)
    		cur.next = p1;
    	if(p2 != null)
    		cur.next = p2;
    }
    
    public static void main(String[] args) {
    	Integer s1[] = {1,3,5};
		LinkedList l1 = new LinkedList(s1);
		ListNode head1 = l1.build();
		Integer s2[] = {2,4};
		LinkedList l2 = new LinkedList(s2);
		ListNode head2 = l2.build();
		Integer s3[] = {6,7};
		LinkedList l3 = new LinkedList(s3);
		ListNode head3 = l3.build();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head1);
		lists.add(head2);
		lists.add(head3);
		MergeKSortedList mkl = new MergeKSortedList();
		ListNode result = mkl.mergeKLists(lists);
		l1.print(result);
	}
}
