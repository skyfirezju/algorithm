package com.algorithm.leetcode;

/**
 * 未排序的数组里找第一个缺失的正整数，时间复杂度要求O(n),空间复杂度O(1)
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author xiefei
 *
 */
public class FirstMissingPositiveInteger {
	/*
	 * 解题思路：时间O(n),空间O(n)
	 * n个元素的数组，result最多也是n+1，这个时候数组是1,2,...,n。
	 * 所以用另一个数组hash[n]存储，第i个元素是否在A数组中存在
	 * 然后扫描找到第一个不存在的元素的下标
	 */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if(n==0)
        	return 1;
        int hash[] = new int[n];
        for(int i = 0; i < n; i++)
        	hash[i] = 0;
        for(int i = 0; i < n; i++) {
        	if(A[i] >= 1 && A[i] <= n) {
        		hash[A[i]-1] = 1;
        	}
        }
        int i;
        for(i = 0; i < n; i++) {
        	if(hash[i] == 0) 
        		break;
        }
        return i+1;
    }
    
    /*
     * 错误思路：
     * count是不属于[1,n]的元素个数
     * n+1-count
     */
    public int firstMissingPositive1(int[] A) {
    	int n = A.length;
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		if(!(A[i] >=1 && A[i] <= n))
    			count++;
    	}
    	return n+1-count;
    }
    
    /*
     * 思路2：移动元素，使得A[i]=i+1，最后扫描A[i]！=i+1
     */
    public int firstMissingPositive2(int[] A) {
    	int n = A.length;
    	if(n==0)
    		return 1;
    	for(int i = 0; i < n; i++) {
    		while(A[i]>=1 && A[i]<=n && A[i]!=i+1 && A[A[i]-1] != A[i]) {
    			int temp = A[i];
    			A[i] = A[temp-1];
    			A[temp-1] = temp;
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		if(A[i] != i+1)
    			return i+1;
    	}
    	return n+1;
    }
    
    public static void main(String[] args) {
    	FirstMissingPositiveInteger fmpi = new FirstMissingPositiveInteger();
    	int A[] = {3,4,-1,1};
    	System.out.println(fmpi.firstMissingPositive2(A));
	}
}
