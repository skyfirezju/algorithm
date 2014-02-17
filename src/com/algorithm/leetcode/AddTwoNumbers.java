package com.algorithm.leetcode;

import com.datastructure.util.ListNode;

/**
 * ���������ʾ�Ǹ���������洢��ÿ���ڵ��ʾ�������֣�������������ӵĽ�����������ʾ
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
	 * ����˼·��
	 * ˼·1������pa��pb����ָ�룬add�ǽ�λ����λ��ӣ�ѭ��ִ��
	 * ������β�巨�����õ�ǰcur����ӽ��val��add=val/10,cur.val = val%10
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
	 * ˼·2���ݹ鷨����ǰl1+l2���result������λ����ӽ��more,����result.next=more
	 * �����������������ݹ��˳�������l1=null&&l2=null&&add==0
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
