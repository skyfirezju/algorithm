package com.algorithm.leetcode;

/**
 * 给定1个非负整数，你最初始在第一个元素，每个元素代表最大跳跃步数。
 * 问是否能够达到最后一个元素。
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * @author xiefei
 *
 */
public class JumpGame {
	
	/*
	 * 解题思路：
	 * cur存储当前最远下标位置，i<=cur代表当前i位置可达，否则return false
	 */
    public boolean canJump(int[] A) {
    	int n = A.length;
    	int cur = 0;
        for(int i = 0; i < n; i++) {
        	if(i <= cur) {
        		cur = Math.max(cur, i+A[i]);
        	} else {
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
    	JumpGame jg = new JumpGame();
    	int A[] = {2,3,1,1,4};
    	System.out.println(jg.canJump(A));
	}
}
