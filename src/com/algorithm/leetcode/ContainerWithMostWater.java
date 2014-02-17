package com.algorithm.leetcode;

/**
 * 最多水的容器，n个非负整数a1, a2, ..., an,表示坐标点(i, ai)， (i, ai) 和(i,0)构成线段，
 * 寻找2个线段与x轴一起构成的容器你，能够装最多的水
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * @author xiefei
 *
 */
public class ContainerWithMostWater {
	/*
	 * 解题思路：
	 * DP(其实是蛮力，而且浪费空间):时间复杂度O(n*n),空间复杂度o(n)
	 * S[n]代表n以前的最大面积，s[n]=max{s[n-1],c[n,i]} 0<=i<=n-1,c[n,i]=(n-i)*min(an,ai)
	 * s[1]=min(a0,a1)
	 */
	public int maxArea(int[] height) {
        int n = height.length;
        int S[] = new int[n];
        S[1] = Math.min(height[0], height[1]);
        for(int i = 2; i < n; i++)
        {
        	int max = S[i-1];
        	for(int j = 0; j <= i-1; j++)
        	{
        		int c = (i-j)*Math.min(height[i], height[j]);
        		if(c>max)
        			max = c;
        	}
        	S[i] = max;
        }
        return S[n-1];
    }
	/*
	 * 思路1：剪枝加快速度，
	 * 考虑maxPossibleJ之后的最好情况都>=height[i]，这样取短板还是height[i],
	 * 靠的太近了肯定不会大于maxArea
	 * maxArea = height[i]*(i-maxPosssibleJ);
	 * 所以maxPossible之后的不用考虑，近似o(n*n)
	 */
	public int maxArea1(int[] height) {
		int maxArea = 0;
		int n = height.length;
		for(int i = 1; i < n; i++){
			if(height[i]==0)continue;
			int maxPossibleJ = i - maxArea/height[i];
			for(int j = 0; j < i && j <= maxPossibleJ; j++) {
				int area = (i-j)*Math.min(height[i],height[j]);
				if(area > maxArea)
					maxArea = area;
			}
		}
		return maxArea;
	}
	/*
	 * 思路2：时间复杂度o(n)
	 * 保持两个指针low,high；分别指向长度数组的首尾。如height[low]小于height[high]，则移动low向后（low++）。
	 * 反之，移动high向前（high--）。如果当前的area大于了所记录的area，替换之。
	 * 这个想法的基础是，如果low的长度小于high，无论如何移动high，短板在low，不可能找到比当前记录的area更大的值了，
	 * 只能通过移动low来找到新的可能的更大面积。
	 */
	public int maxArea2(int[] height) {
		int len = height.length, low = 0, high = len -1 ;  
		int maxArea = 0;  
		while (low < high) {  
			maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));  
			if (height[low] < height[high]) {  
				low++;  
			} else {  
				high--;  
			}  
		}  
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int height[] = {1,5,7,3,9};
		System.out.println(cwmw.maxArea1(height));
	}
}
