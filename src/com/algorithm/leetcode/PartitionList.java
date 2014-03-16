package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * ����ʹ��<x �Ľ����>=x��ǰ�棬�ҽ���Ⱥ�˳�򲻱�
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
	 * ���������ֵ�ͷβָ��smaller С��x��ͷָ�룬smallerTailС��x��βָ��
	 * greater >=x��ͷָ�룬greaterTail >=x��βָ�롣Ȼ��ɨ��ά����������
	 * ����жϰ�����������Ϸ��ء�
	 * [ע��]greater == null�������greaterTail.next = null;�ᱨ��ָ�����
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
