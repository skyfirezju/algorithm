package com.algorithm.leetcode;

/**
 * �ϲ�2�����������
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B.
 *  The number of elements initialized in A and B are m and n respectively.
 * @author xiefei
 *
 */
public class MergeSortedArray {
	/*
	 * ����˼·���Ӻ���ǰ�ϲ�������Ͳ��Ḳ�ǣ�ʵ��ԭ���㷨
	 */
    public void merge(int A[], int m, int B[], int n) {
    	int i = m-1, j = n -1, k = m + n -1;
        while(j >= 0 && i >= 0) {
        	if(A[i] > B[j]) {
        		A[k--] = A[i--];
        	} else {
        		A[k--] = B[j--];
        	}
        }
        if(j >= 0) {
        	while(j >= 0) {
        		A[k--] = B[j--];
        	}
        }
    }
}
