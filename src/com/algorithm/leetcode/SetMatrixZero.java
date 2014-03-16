package com.algorithm.leetcode;

/**
 * 设置矩阵中元素为0的行列都置0
 * Given a m x n matrix, 
 * if an element is 0, set its entire row and column to 0. Do it in place.
 * @author xiefei
 *
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int zrows[] = new int[rows];
        int zcols[] = new int[cols];
        for(int i = 0; i < rows; i++)
        	zrows[i] = 0;
        for(int i = 0; i < cols; i++) 
        	zcols[i] = 0;
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < cols; j++) {
        		if(matrix[i][j] == 0){
        			zrows[i] = 1;
        			zcols[j] = 1;
        		}
        	}
        }
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < cols; j++) {
        		if(zrows[i] == 1 || zcols[j] == 1)
        			matrix[i][j] = 0;
        	}
        }
    }
}
