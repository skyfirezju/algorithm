package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * ��ת����
 * Given a list, rotate the list to the right by k places, 
 * where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author xiefei
 *
 */
public class RotateList {
	/*
	 * ����˼·��
	 * ����k����������n��ʱ��ѭ���൱��k%n
	 * 1->2->3  
	 * k=1  3->1->2
	 * k=2  2->3->1
	 * k=3  1->2->3
	 * k=4  3->1->2
	 * ����ǰ��ָ��preHead->next=head
	 * slow=preHead,fast=head
	 * fast��n-1�£�ʹslow��fast���n
	 * ע�⵱fast=nullʱ��Ҫ��fast=head������ѭ����
	 * ���fast�Ƶ����һ��Ԫ�ص�λ�ã�slowָ��������k+1��Ԫ�ص�λ��
	 * Ȼ����ת
	 */
    public ListNode rotateRight(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        if(n == 0)return head;
        preHead.next = head;
        ListNode slow = preHead, fast = head;
        while(--n != 0) {
        	fast = fast.next;
        	if(fast == null) {
        		fast = head;
        	}
        }
        while(fast != null && fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        if(slow != preHead && slow.next != null) {
        	preHead.next = slow.next;
        	slow.next = null;
        	fast.next = head;
        }
        return preHead.next;
    }
    
    public static void main(String[] args) {
    	RotateList rl = new RotateList();
    	Integer list[] = {1,2,3};
    	LinkedList ll = new LinkedList(list);
    	ListNode head = ll.build();
    	ll.print(head);
    	System.out.println();
    	int n = 0;
    	ListNode result = rl.rotateRight(head, n);
    	ll.print(result);
	}
}
