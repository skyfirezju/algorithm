package com.algorithm.leetcode;

/**
 * ���ˮ��������n���Ǹ�����a1, a2, ..., an,��ʾ�����(i, ai)�� (i, ai) ��(i,0)�����߶Σ�
 * Ѱ��2���߶���x��һ�𹹳ɵ������㣬�ܹ�װ����ˮ
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
	 * ����˼·��
	 * DP(��ʵ�������������˷ѿռ�):ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�o(n)
	 * S[n]����n��ǰ����������s[n]=max{s[n-1],c[n,i]} 0<=i<=n-1,c[n,i]=(n-i)*min(an,ai)
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
	 * ˼·1����֦�ӿ��ٶȣ�
	 * ����maxPossibleJ֮�����������>=height[i]������ȡ�̰廹��height[i],
	 * ����̫���˿϶��������maxArea
	 * maxArea = height[i]*(i-maxPosssibleJ);
	 * ����maxPossible֮��Ĳ��ÿ��ǣ�����o(n*n)
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
	 * ˼·2��ʱ�临�Ӷ�o(n)
	 * ��������ָ��low,high���ֱ�ָ�򳤶��������β����height[low]С��height[high]�����ƶ�low���low++����
	 * ��֮���ƶ�high��ǰ��high--���������ǰ��area����������¼��area���滻֮��
	 * ����뷨�Ļ����ǣ����low�ĳ���С��high����������ƶ�high���̰���low���������ҵ��ȵ�ǰ��¼��area�����ֵ�ˣ�
	 * ֻ��ͨ���ƶ�low���ҵ��µĿ��ܵĸ��������
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
