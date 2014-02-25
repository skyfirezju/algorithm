package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * 旋转链表
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
	 * 解题思路：
	 * 考虑k大于链表长度n的时候，循环相当于k%n
	 * 1->2->3  
	 * k=1  3->1->2
	 * k=2  2->3->1
	 * k=3  1->2->3
	 * k=4  3->1->2
	 * 设置前置指针preHead->next=head
	 * slow=preHead,fast=head
	 * fast移n-1下，使slow和fast相差n
	 * 注意当fast=null时，要把fast=head这样就循环了
	 * 最后fast移到最后一个元素的位置，slow指向右数第k+1个元素的位置
	 * 然后旋转
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
