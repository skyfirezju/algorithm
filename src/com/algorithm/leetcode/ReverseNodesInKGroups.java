package com.algorithm.leetcode;

import com.datastructure.util.LinkedList;
import com.datastructure.util.ListNode;

/**
 * ��K��Ϊһ������������ת
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * @author xiefei
 *
 */
public class ReverseNodesInKGroups {
	
	/*
	 * ����˼·������cur�ǵ�ǰ�ĵ�һ����end=cur���ƿ���k���Ƿ�Ϊnull��
	 * ��Ϊ�մ��������ת��from,to�ֱ��ʾ�������β��tailָ����ת������һ����
	 * tail.next=from,tail=to
	 */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || k==0)
        	return head;
        if(head == null)
        	return null;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode tail = pHead,cur = head,end = head;
        while(cur!=null) {
        	int count = k;
        	end = cur;
        	while(count != 1 && end != null) {
            	end = end.next;
            	count--;
            }
            if(end == null)break;
            ListNode from = cur,to = cur;
            count = 0;
            while(count != k) {
            	ListNode temp = cur.next;
            	cur.next = from;
            	from = cur;
            	cur = temp;
            	count++;
            }
            tail.next = from;
            tail = to;
            to.next = cur;
        }
        return pHead.next;
    }
    
    public static void main(String[] args) {
    	Integer s[] = {1,2,3,4,5};
		LinkedList list = new LinkedList(s);
		ListNode head = list.build();
		ReverseNodesInKGroups rk = new ReverseNodesInKGroups();
		ListNode afterhead = rk.reverseKGroup(head,3);
		list.print(afterhead);
	}
}
