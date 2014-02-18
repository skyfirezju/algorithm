package com.algorithm.leetcode;

/**
 * 给你一个非负整数的数组，初始位置是0，每个元素代表在当前位置的最大跳跃步数。
 * 以最小的步数达到最好一个元素的位置
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * @author xiefei
 *
 */
public class JumpGame2 {
	/*
	 *  解题思路:
	 *  时间复杂度O(n*n) OJ TLE超时
	 *  dp[i]代表i位置的最小步数
	 *  dp[i] = min{dp[j]} if(A[j]>= i-j)  j=0,1,...,i-1
	 */
    public int jump(int[] A) {
        int n = A.length;
        if(n == 0 || n == 1)return 0;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
        	int min = Integer.MAX_VALUE;
        	for(int j = 0; j < i; j++) {
        		if(A[j] >= (i-j) && dp[j] + 1 < min) {
        			min = dp[j] + 1;
        		}
        	}
        	dp[i] = min;
        }
        return dp[n-1];
    }
    
    /*
     * 思路2：
     * last代表ret步能够到达的最远下标，curr代表ret+1步能够达到的最远下标
     * curr=max(i+A[i]) 0<=i<=last
     */
    public int jump1(int[] A) {
    	int n = A.length;
    	int ret = 0;
    	int curr = 0;
    	int last = 0;
    	for(int i = 0; i < n; i++) {
    		if(i > last) {
    			last = curr;
    			ret++;
    		}
    		curr = Math.max(curr, i+A[i]);
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
    	JumpGame2 jg = new JumpGame2();
    	int A[] = {2,3,1,1,4};
    	System.out.println(jg.jump1(A));
	}
}
