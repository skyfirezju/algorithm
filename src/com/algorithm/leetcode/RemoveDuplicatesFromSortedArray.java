package com.algorithm.leetcode;

/**
 * 排序的数组里移除重复的元素
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * @author xiefei
 *
 */
public class RemoveDuplicatesFromSortedArray {
	
	/*
	 * 解题思路：length代表当前无重复的元素个数，
	 * A[i]==A[length-1]时pass
	 * 不等时，A[length=A[i],length++
	 */
    public int removeDuplicates(int[] A) {
    	int n = A.length;
    	if(n == 0 || n == 1)
    		return n;
        int length = 1;
        for(int i = 1; i < n; i++) {
        	if(A[i] == A[length-1])
        		continue;
        	A[length++] = A[i];
        }
        return length;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesFromSortedArray rda = new RemoveDuplicatesFromSortedArray();
    	int A[] = {1,1,2,2,3,3,3,4};
    	int result = rda.removeDuplicates(A);
    	System.out.println(result);
    	for(int i = 0; i < result; i++)
    		System.out.print(A[i] + " ");
	}
}
