package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * @author xiefei
 *
 */
public class Triangle {
	/*
	 * 解题思路：
	 * 直接按顺序选择下一个最小的，局部最小的不一定是全局最优的，思路错误
	 */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int len = triangle.size();
    	if(len == 0)return 0;
        int minSum = triangle.get(0).get(0);
        int minIndex = 0;
        for(int i = 1; i < len; i++) {
        	int num0 = triangle.get(i).get(minIndex);
        	int num1 = triangle.get(i).get(minIndex+1);
        	if(num0 > num1) {
        		minSum += num1;
        		minIndex = minIndex +1;
        	} else {
        		minSum += num0;
        	}
        }
        return minSum;
    }
    
    /*
     * 思路2：dp[i]代表第i个最小的和，进行由底往上扫描n--，
     * dp[i] = triangle[n][i] + min(dp[i]，dp[i+1])
     */
    public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
    	int n = triangle.size();
    	if(n == 0)return 0;
    	int dp[] = new int[n+1];
    	for(int i = 0; i < n; i++)
    		dp[i] = 0;
    	while(n-- > 0) {
    		for(int i = 0; i <= n; i++) {
    			dp[i] = triangle.get(n).get(i) + Math.min(dp[i], dp[i+1]);
    		}
    	}
	    return dp[0];
    }
    public static void main(String[] args) {
    	Triangle t = new Triangle();
    	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> tri0 = new ArrayList<Integer>();
    	ArrayList<Integer> tri1 = new ArrayList<Integer>();
    	ArrayList<Integer> tri2 = new ArrayList<Integer>();
    	ArrayList<Integer> tri3 = new ArrayList<Integer>();
    	tri0.add(2);
    	tri1.add(3);
    	tri1.add(4);
    	tri2.add(6);
    	tri2.add(5);
    	tri2.add(7);
    	tri3.add(4);
    	tri3.add(1);
    	tri3.add(8);
    	tri3.add(3);
    	triangle.add(tri0);
    	triangle.add(tri1);
    	triangle.add(tri2);
    	triangle.add(tri3);
    	System.out.println(t.minimumTotal1(triangle));
	}
}
