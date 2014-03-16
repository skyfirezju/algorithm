package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * 划分使得<x 的结点在>=x的前面，且结点先后顺序不变
 * Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * @author xiefei
 *
 */
public class PartitionList {
	/*
	 * 设置两部分的头尾指针smaller 小于x的头指针，smallerTail小于x的尾指针
	 * greater >=x的头指针，greaterTail >=x的尾指针。然后扫描维护两个链表
	 * 最后判断把两个链表组合返回。
	 * [注意]greater == null的情况，greaterTail.next = null;会报空指针错误
	 */
    public ListNode partition(ListNode head, int x) {
    	if(head == null)return null;
        ListNode smaller = null, greater = null;
        ListNode smallerTail = null,greaterTail = null;
        ListNode p = head;
        while(p != null) {
        	if(p.val < x) {
        		if(smaller == null) {
        			smaller = p;
        			smallerTail = p;
        		} else {
        			smallerTail.next = p;
        			smallerTail = p;
        		}
        	} else {
        		if(greater == null) {
        			greater = p;
        			greaterTail = p;
        		} else {
        			greaterTail.next = p;
        			greaterTail = p;
        		}
        	}
        	p = p.next;
        }
        if(smaller != null) {
        	smallerTail.next = greater;
        	if(greaterTail != null)
        		greaterTail.next = null;
        	return smaller;
        } else {
        	greaterTail.next = null;
        	return greater;
        }
    }
    public static void main(String[] args) {
    	PartitionList p = new PartitionList();
    	Integer list[] = {1,2,4,3,5,2};
    	LinkedList l = new LinkedList(list);
    	ListNode head = l.build();
    	int x = 3;
    	head = p.partition(head, x);
    	l.print(head);
	}
}
