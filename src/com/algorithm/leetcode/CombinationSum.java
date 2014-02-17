package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 在数字集合C中寻找数字组合，使得相加为T
 * 集合C中数字可以使用任意次
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * @author xiefei
 *
 */
public class CombinationSum {
	/*
	 * 解题思路：对第i个元素枚举0,1,2..,。j*candidate[i]==target添加result，
	 * 递归
	 */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combine = new ArrayList<Integer>();
        combine2(candidates, result, combine, 0, target);
        return result;
    }
    
    public void combine(int[] candidates, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> combine, int start, int target) {
    	int n = candidates.length;
    	if(start>=n)return;
		for(int j = 0; j*candidates[start] <= target; j++) {
			int reminder = target-j*candidates[start];
			ArrayList<Integer> new_combine = new ArrayList<Integer>();
			for(int k =0; k < combine.size(); k++)
				new_combine.add(combine.get(k));
			for(int k = 0 ; k < j; k++) {
				new_combine.add(candidates[start]);
			}
			if(reminder == 0) {
				result.add(new_combine);
			} else {
				combine(candidates, result, new_combine, start+1, reminder);
			}
		}
    }
    
    /*
     * 错误想法：
     * 如果直接多次的话会出现重复的情况，如[2,3,6,7] [3,6,7] 都会返回1个7
     */
    public void combine2(int[] candidates, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> combine, int start, int target) {
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(combine));
    		return;
    	}
    	for(int i = start; i < candidates.length; i++) {
    		for(int j = 0; j*candidates[i]<=target;j++) {
    			for(int k = 0; k < j; k++)
    				combine.add(candidates[i]);
    			combine2(candidates,result,combine,i+1,target-j*candidates[i]);
    			for(int k = 0; k < j; k++)
    				combine.remove(combine.size()-1);
    		}
    	}
    }
    
    /*
     * 思路2：第i个candidates[i]不断的添加，递归直到candidates[i]>target，
     * 或者不添加,这样在第i重循环里面，会有多次的递归调用。j*candidates[i]<target,
     * 
     */
    public void combine3(int[] candidates, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> combine, int start, int target) {
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(combine));
    		return;
    	}
    	for(int i = start; i < candidates.length; i++) {
    		if(candidates[i]>target)return;
			combine.add(candidates[i]);
			combine3(candidates,result,combine,i,target-candidates[i]);
			combine.remove(combine.size()-1);
    	}
    }
    
    public static void main(String[] args) {
    	CombinationSum cs = new CombinationSum();
    	int []candidates = {2,3,6,7};
    	int target = 7;
    	ArrayList<ArrayList<Integer>> result = cs.combinationSum(candidates, target);
    	for(int i = 0; i < result.size(); i++) 
    		System.out.println(result.get(i));
	}
}
