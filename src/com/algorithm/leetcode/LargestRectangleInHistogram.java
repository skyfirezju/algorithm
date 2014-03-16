package com.algorithm.leetcode;

import java.util.Stack;

/**
 * n������ֱ��ͼ�������ľ������
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
	 * ����˼·��
	 * O(n*n)��ʱ
	 * ��˳�����������С�߶ȣ������
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
     * ˼·2��
     * ���Ǽ�����iΪ��С�߶ȣ�������������ɢ�ľ��ε�����������������n��
     * ��n���������ȡ���ġ��ѵ����ڶ���i��ôȷ�����ұ߽硣
     * ���ұ߽���иպ�С��height[i]���ص㡣
     * ����һ��ջ����ǰ��height[i]<ջ����Ӧ��Ԫ��height[s.top]ʱ��ջ����ջ����Ϊ����Ҫ��
     * ����ջ��Ԫ�ص�������ұ߽���i����߽���ջ����ջ�����ջ������Ϊ����ջ����һ����С��ԭ����ջ���ġ�
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
