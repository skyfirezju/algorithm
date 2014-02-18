package com.algorithm.leetcode;

/**
 * ����һ���Ǹ����������飬��ʼλ����0��ÿ��Ԫ�ش����ڵ�ǰλ�õ������Ծ������
 * ����С�Ĳ����ﵽ���һ��Ԫ�ص�λ��
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
	 *  ����˼·:
	 *  ʱ�临�Ӷ�O(n*n) OJ TLE��ʱ
	 *  dp[i]����iλ�õ���С����
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
     * ˼·2��
     * last����ret���ܹ��������Զ�±꣬curr����ret+1���ܹ��ﵽ����Զ�±�
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
