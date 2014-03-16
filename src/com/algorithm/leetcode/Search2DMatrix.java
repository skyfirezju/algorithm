package com.algorithm.leetcode;

/**
 * 排序的矩阵中搜索元素
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * @author xiefei
 *
 */
public class Search2DMatrix {
	/*
	 * 解题思路：
	 * 首先搜索行，确定target所在行
	 * 然后对列二分搜索
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int i;
        for(i = 0; i < m; i++) {
        	if(matrix[i][0]> target)break;
        	else if(matrix[i][0] == target)return true;
        }
        if(i == 0)return false;
        int lo = 0, hi = n-1;
        while(lo <= hi) {
        	int mid = (lo+hi)/2;
        	if(matrix[i-1][mid] > target) {
        		hi = mid-1;
        	} else if(matrix[i-1][mid] < target) {
        		lo = mid+1;
        	} else {
        		return true;
        	}
        }
        return false;
    }
    public static void main(String[] args) {
    	Search2DMatrix sm = new Search2DMatrix();
    	int matrix[][] = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
    	int target = 51;
    	System.out.println(sm.searchMatrix(matrix, target));
	}
}
