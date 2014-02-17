package com.algorithm.leetcode;

/**
 * n个元素代表长度为n宽度为1的柱子，问总共最多能蓄水多少？
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author xiefei
 *
 */
public class TrappingRainWater {
	/*
	 * 解题思路：从左向右扫描，记录A[i],A[i+1],...,A[j-1]是一个先降后升的序列，
	 * 然后计算面积，这个想法的在于j的确定上面会有问题
	 */
    public int trap(int[] A) {
        int n = A.length;
        if(n<3)
        	return 0;
        int trap = 0;
        for(int i = 0; i < n-1; i++) {
        	if(A[i] > A[i+1]) {
        		System.out.println("i=" + i);
        		int j,area = 0,count=0;
        		for(j = i+1; j < n; j++) {
        			if(A[j]<=A[j-1]) {
        				count++;
        				area += A[j];
        			} else {
        				break;
        			}
        		}
        		if(j < n) {
        			System.out.println(area);
        			area = count*Math.min(A[i], A[j]) - area;
        			trap += area;
        			System.out.println(j + " " + count + " " + A[j] + " " + A[i] + " " + area);
        		}
        		i = j-1;
        	}
        }
        return trap;
    }
    
    /*
     * 思路2：
     * 时间O(n)空间O(n)
     * A[i]上traped水,累加起来
     * 左边最大left=LeftMost[i]和右边最大right=rightMost[i]
     * Min(right,left)>A[i]
     * A[i]上traped水 = Min(right,left)-A[i]
     */
    public int trap1(int[] A) {
    	int n = A.length;
    	if(n < 3)
    		return 0;
    	int trap= 0;
    	int leftMost[] = new int[n];
    	leftMost[0] = 0;
    	int maxl = A[0];
    	for(int i = 1; i < n; i++) {
    		leftMost[i] = maxl;
    		if(maxl<A[i])
    			maxl = A[i];
    	}
    	int maxr = A[n-1];
    	for(int i = n-2; i >= 1; i--) {
    		int min = Math.min(leftMost[i], maxr);
    		if(min > A[i]) {
    			trap += (min - A[i]);
    		}
    		if(A[i]>maxr)
    			maxr = A[i];
    	}
    	return trap;
    }
    
    public static void main(String[] args) {
    	TrappingRainWater trw = new TrappingRainWater();
    	//int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    	int A[] = {4,2,3};
    	System.out.println(trw.trap1(A));
	}
}
