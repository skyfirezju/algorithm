package com.datastructure.util;

/**
 * m*n网格，左上到右下的路径数
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * @author xiefei
 *
 */
public class UniquePaths {
	/*
	 * 解题思路：简单DP
	 */
    public int uniquePaths(int m, int n) {
        int paths[][] = new int[m][n];
        for(int i = 0; i < n; i++)
        	paths[0][i] = 1;
        for(int i = 0; i < m; i++)
        	paths[i][0] = 1;
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		paths[i][j] = paths[i-1][j] + paths[i][j-1];
        	}
        }
        return paths[m-1][n-1];
    }
    public static void main(String[] args) {
		
	}
}
