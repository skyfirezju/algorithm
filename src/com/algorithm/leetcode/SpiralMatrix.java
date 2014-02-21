package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 顺时针旋转方式打印矩阵
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * @author xiefei
 *
 */
public class SpiralMatrix {
	/*
	 * 解题思路：
	 * top->right->bottom->left
	 * 要注意不要重复
	 */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(m == 0)
        	return result;
        int n = matrix[0].length;
        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        while(left <= right && top <= bottom) {
        	//top
        	for(int i = left; i <= right; i++) 
        		result.add(matrix[top][i]);
        	
        	//right
        	for(int i = top+1; i <= bottom; i++)
        		result.add(matrix[i][right]);
        	
        	//bottom
        	if(top+1 <= bottom) {
        		for(int i = right -1; i >= left; i--)
            		result.add(matrix[bottom][i]);
        	}
        	
        	//left
        	if(left+1<=right) {
        		for(int i = bottom-1; i >= top+1; i--)
            		result.add(matrix[i][left]);
        	}
        	
        	left++;
        	right--;
        	top++;
        	bottom--;
        }
        return result;
    }
    public static void main(String[] args) {
    	SpiralMatrix sm = new SpiralMatrix();
    	//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	int matrix[][] = {{7},{9},{6}};
    	ArrayList<Integer> result = sm.spiralOrder(matrix);
    	System.out.println(result);
	}
}
