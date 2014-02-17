package com.algorithm.leetcode;

/**
 * n��Ԫ�ش�����Ϊn���Ϊ1�����ӣ����ܹ��������ˮ���٣�
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
	 * ����˼·����������ɨ�裬��¼A[i],A[i+1],...,A[j-1]��һ���Ƚ����������У�
	 * Ȼ��������������뷨������j��ȷ�������������
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
     * ˼·2��
     * ʱ��O(n)�ռ�O(n)
     * A[i]��trapedˮ,�ۼ�����
     * ������left=LeftMost[i]���ұ����right=rightMost[i]
     * Min(right,left)>A[i]
     * A[i]��trapedˮ = Min(right,left)-A[i]
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
