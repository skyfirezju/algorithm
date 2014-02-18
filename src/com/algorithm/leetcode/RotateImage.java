package com.algorithm.leetcode;

/**
 * Ë³Ê±ÕëÐý×ªn*nÍ¼Æ¬90¶È
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * @author xiefei
 *
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
        	int first = layer;
        	int last = n - 1- layer;
        	for(int i = first; i < last; i++) {
        		int offset = i - first;
        		int top = matrix[first][i];
        		//left to top
        		matrix[first][i] = matrix[last-offset][first];
        		
        		//bottom to left
        		matrix[last-offset][first] = matrix[last][last-offset];
        		
        		//right to bottom
        		matrix[last][last-offset] = matrix[i][last];
        		
        		//top to right 
        		matrix[i][last] = top;
        	}
        }
    }
}
