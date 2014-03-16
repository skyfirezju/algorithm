package com.algorithm.leetcode;

import java.util.Stack;

/**
 * 2维矩阵单元是0,1组成，找出全是1的最大的矩形区域
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * @author xiefei
 *
 */
public class MaxRectangle {
	/*
	 * 把每行看做基底往上拖，其的连续1的柱子，转换为直方图的最大矩形面积问题
	 */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)return 0;
        int n = matrix[0].length;
        int height[][] = new int[m][n];
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0) {
            		height[i][j] = matrix[i][j] == '0' ? 0 : 1;
            	} else {
            		height[i][j] = matrix[i][j] == '1' ? height[i-1][j] + 1 : 0;
            	}
        	}
        }
        for(int i = 0; i < m; i++) {
        	int area = largestRectangleArea(height[i]);
    		if(area > maxArea)
    			maxArea = area;
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] height) {
    	Stack<Integer> s = new Stack<Integer>();
    	int n = height.length;
    	if(n == 0)return 0;
    	int max = Integer.MIN_VALUE;
    	int i = 0;
    	while(i < n){
    		if(s.isEmpty() || height[s.peek()] <= height[i]) {
    			s.push(i++);
    		} else {
    			int smaller = s.pop();
    			int area = height[smaller]*(s.isEmpty() ? i : i - s.peek() - 1);
    			if(area > max)
    				max = area;
    		}
    	}
    	while(!s.isEmpty()) {
    		int smaller = s.pop();
    		int area = height[smaller]*(s.isEmpty() ? n : n - s.peek() - 1);
			if(area > max)
				max = area;
    	}
    	return max;
    }
    
    public static void main(String[] args) {
    	MaxRectangle mr = new MaxRectangle();
    	char[][] matrix = {{'0','1','1','0'},{'0','1','1','1'},{'0','0','0','0'}};
    	System.out.println(mr.maximalRectangle(matrix));
	}
}
