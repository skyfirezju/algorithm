package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * n����������������3��Ԫ����ӵĺ���ӽ�target
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author xiefei
 *
 */
public class ThreeSumClosest {
	/*
	 * ����˼·��3Sum��˼·�����������ҵ�|closest-target|��С
	 * �ѵ����ڣ�closest��ʼֵ,minDistance=|closest-target|��ʼֵInteger.MAX_VALUE
	 * closest = target + Integer.MAX_VALUE OJҲAC�ˣ�����ϵͳû��target�ܴ����Ĳ�������
	 */
    public int threeSumClosest(int[] num, int target) {
    	int closest = Integer.MIN_VALUE;//
    	//int closest = target + Integer.MAX_VALUE;
    	int minDistance = Integer.MAX_VALUE;
    	int n = num.length;
        Arrays.sort(num);
        for(int i = 0; i < n;i++){
        	int first = i+1;
            int last = n-1;
            while(first<last){
            	int sum = num[i] + num[first] + num[last];
            	if(Math.abs(sum-target) < minDistance){
            		minDistance = Math.abs(sum-target);
            		closest = sum;
            	}
            	if(sum < target) {
            		first++;
            	} else if(sum > target) {
            		last--;
            	} else {
            		return target;
            	}
            }
            while(i+1<n &&num[i+1]==num[i])
            	i++;
        }
        return closest;
    }
    
    public static void main(String[] args) {
		int num[] = {-1,2,1,-4};
		int target = 1;
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, target));
	}
}
