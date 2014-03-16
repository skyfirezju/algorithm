package com.algorithm.leetcode;

import java.util.Stack;

/**
 * n个数字直方图，找最大的矩阵面积
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * @author xiefei
 *
 */
public class LargestRectangleInHistogram {
	/*
	 * 解题思路：
	 * O(n*n)超时
	 * 按顺序遍历，计最小高度，算面积
	 */
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        if(n == 0)return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	if(height[i] > max)
        		max = height[i];
        	int min = height[i];
        	for(int j = i+1; j < n; j++) {
        		if(height[j] < min)min = height[j];
        		int area = (j-i+1)*min;
        		if(area > max)
        			max = area;
        	}
        }
        return max;
    }
    
    /*
     * 思路2：
     * 我们计算以i为最小高度，尽量往左右扩散的矩形的面积，这样的面积有n个
     * 在n个面积里面取最大的。难点在于对于i怎么确定左右边界。
     * 左右边界具有刚好小于height[i]的特点。
     * 利用一个栈，当前的height[i]<栈顶对应的元素height[s.top]时，栈顶出栈，因为满足要求，
     * 计算栈顶元素的面积，右边界是i，左边界是栈顶出栈后的新栈顶，因为它在栈里面一定是小于原来的栈顶的。
     */
    public int largestRectangleArea1(int[] height) {
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
    	LargestRectangleInHistogram l = new LargestRectangleInHistogram();
    	int height[] = {2,1,5,6,2,3};
    	System.out.println(l.largestRectangleArea1(height));
	}
}
