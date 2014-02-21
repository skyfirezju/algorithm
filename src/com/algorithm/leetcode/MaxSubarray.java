package com.algorithm.leetcode;

/**
 * 最大连续子数组的和
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author xiefei
 *
 */
public class MaxSubarray {
	/*
	 * 解题思路：
	 * curSum 记录当前的和，curSum<0时,curSum=A[i]
	 * 否则curSum+=A[i]
	 * 当curSum>maxSum,maxSum=curSum
	 */
    public int maxSubArray(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int maxSum = A[0], curSum = A[0];
        for(int i = 1; i < n; i++) {
        	if(curSum < 0) {
        		curSum = A[i];
        	} else {
        		curSum += A[i];
        	}
        	if(curSum > maxSum)
        		maxSum = curSum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
    	MaxSubarray ms = new MaxSubarray();
    	//int A[] = {-2,1,-3,4,-1,2,1,-5,4};
    	int A[] = {0,-1,1,2};
    	System.out.println(ms.maxSubArray(A));
    }
}
