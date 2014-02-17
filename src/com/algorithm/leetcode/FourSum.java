package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * @author xiefei
 *
 */
public class FourSum {
	/*
	 * 解题思路：3sum = target
	 */
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int n = num.length;
    	if(n<4)
    		return result;
    	Arrays.sort(num);
    	for(int i = 0; i < n; i++){
    		int threeSumTarget = target - num[i];
    		for(int j = i+1; j < n; j++){
    			int first = j+1;
    			int last = n-1;
    			while(first<last){
    				int threeSum = num[j] + num[first] + num[last];
    				if(threeSum < threeSumTarget) {
    					first++;
    				} else if(threeSum > threeSumTarget){
    					last--;
    				} else {
    					ArrayList<Integer> quadruplet = new ArrayList<Integer>();
    					quadruplet.add(num[i]);
    					quadruplet.add(num[j]);
    					quadruplet.add(num[first]);
    					quadruplet.add(num[last]);
    					result.add(quadruplet);
    					while(first + 1<last && num[first+1]== num[first])
    						first++;
    					first++;
    					while(last-1>first && num[last-1] == num[last])
    						last--;
    					last--;
    				}
    			}
    			while(j+1<n && num[j+1]==num[j])
    				j++;
    		}
    		while(i+1<n && num[i+1]==num[i])
				i++;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		int num[] = {1,0,-1,0,-2,2};
		int target = 0;
		FourSum fs = new FourSum();
		System.out.println(fs.fourSum(num, target));
	}
}
