package com.algorithm.leetcode;

/**
 * 按顺序生成n*n个数的顺时针旋转矩阵
 * Given an integer n, generate a square matrix filled with elements 
 * from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author xiefei
 *
 */
public class SpiralMatrix2 {
	/*
	 * 解题思路：
	 * 参考旋转矩阵
	 */
    public int[][] generateMatrix(int n) {
    	int matrix[][] = new int[n][n];
    	int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int count = 1;
        while(left <= right && top <= bottom) {
        	//top
        	for(int i = left; i <= right; i++) 
        		matrix[top][i] = count++;
        	//right
        	for(int i = top+1; i <= bottom; i++)
        		matrix[i][right] = count++;
        	//bottom
        	if(top+1 <= bottom) {
        		for(int i = right -1; i >= left; i--)
            		matrix[bottom][i] = count++;
        	}
        	//left
        	if(left+1<=right) {
        		for(int i = bottom-1; i >= top+1; i--)
            		matrix[i][left] = count++;
        	}
        	left++;
        	right--;
        	top++;
        	bottom--;
        }
        return matrix;
    }
    public static void main(String[] args) {
    	SpiralMatrix2 sm = new SpiralMatrix2();
    	int n = 4;
    	int matrix[][] = sm.generateMatrix(n);
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
	}
}
