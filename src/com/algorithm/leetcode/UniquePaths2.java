package com.algorithm.leetcode;

/**
 * m*n网格，左上到右下的路径数
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * @author xiefei
 *
 */
public class UniquePaths2 {
	/*
	 * 解题思路：
	 * 要特别注意上面和左边的初始化。
	 * 当一条直线上有一个obstacle=1,后面的都不可达了
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)return 0;
        int n = obstacleGrid[0].length;
        int paths[][] = new int[m][n];
        paths[0][0] = 1- obstacleGrid[0][0];
        for(int i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 0 && paths[0][i-1] == 1)
        		paths[0][i] = 1;
        	else
        		paths[0][i] = 0;
        }
        for(int i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 0 && paths[i-1][0] == 1)
        		paths[i][0] = 1;
        	else
        		paths[i][0] = 0;
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 0) {
        			paths[i][j] = paths[i-1][j] + paths[i][j-1];
        		} else {
        			paths[i][j] = 0;
        		}
        	}
        }
        return paths[m-1][n-1];
    }
}
