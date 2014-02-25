package com.algorithm.leetcode;

/**
 * 爬楼梯，每次1,2步，总共n步，有多少种爬法
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author xiefei
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2)
        	return n;
        int step[] = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        for(int i = 3; i <= n; i++) {
        	step[i] = step[i-1] + step[i-2];
        }
        return step[n];
    }
    public static void main(String[] args) {
    	ClimbingStairs cs = new ClimbingStairs();
    	int n = 4;
    	System.out.println(cs.climbStairs(n));
	}
}
