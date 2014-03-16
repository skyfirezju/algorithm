package com.algorithm.leetcode;

/**
 * �Ƴ��ظ�Ԫ�أ���֤�ظ�Ԫ������2��
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * @author xiefei
 *
 */
public class RemoveDuplicatesFromSortedArray2 {
	/*
	 * ����˼·��
	 * k��¼��ǰ�ƶ�λ�ã�ÿ�δ�A[i]�ƶ���A[k]
	 * prev��¼֮ǰ��Ԫ�أ���A[i]==prev������count����2��ʱ�����ƶ�
	 * �����Ķ��ƶ�
	 */
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n <= 1)return n;
        int count = 1;
        int prev = A[0];
        int k = 1;
        for(int i = 1; i < n; i++) {
        	if(A[i] == prev) {
        		if(count < 2) {
        			A[k++] = A[i];
        		}
        		count++;
        	} else {
        		count = 1;
        		prev = A[i];
        		A[k++] = A[i];
        	}
        }
        return k;
    }
    public static void main(String[] args) {
    	RemoveDuplicatesFromSortedArray2 rd = new RemoveDuplicatesFromSortedArray2();
    	int A[] = {1,1,1,4,2,2,2,3,3};
    	System.out.println(rd.removeDuplicates(A));
    	for(int i = 0; i < A.length; i++)
    		System.out.print(A[i] + " ");
	}
}
