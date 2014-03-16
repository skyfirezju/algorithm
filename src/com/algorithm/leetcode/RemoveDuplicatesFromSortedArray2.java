package com.algorithm.leetcode;

/**
 * 移除重复元素，保证重复元素至多2个
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
	 * 解题思路：
	 * k记录当前移动位置，每次从A[i]移动到A[k]
	 * prev记录之前的元素，当A[i]==prev，数量count超过2的时候不用移动
	 * 其他的都移动
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
