package com.datastructure.util;

import java.util.ArrayList;

public class LinkedList {
	public Integer list[];
	public ListNode head;
	public LinkedList(Integer list[]){
		this.list = list;
	}
	public ListNode build(){
		ListNode preHead = new ListNode(0);
		ListNode cur = preHead;
		for(int i = 0 ; i < list.length; i++) {
			ListNode node = new ListNode(list[i]);
			cur.next = node;
			cur = node;
		}
		this.head = preHead.next;
		return preHead.next;
	}
	public static void print(ListNode head){
		if(head == null)return;
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
	}
}
