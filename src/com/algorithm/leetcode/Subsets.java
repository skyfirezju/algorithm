package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 所有子集
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author xiefei
 *
 */
public class Subsets {
	/*
	 * 解题思路：参考Combinations调用S里面选k个元素
	 */
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = S.length;
        Arrays.sort(S);
    	for(int i = 0; i <= n; i++) {
        	combine(result, S, n, i);
        }
    	return result;
    }
    public void combine(ArrayList<ArrayList<Integer>> result, 
    		int[] S, int n, int k) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	boolean used[] = new boolean[n];
    	for(int i = 0; i < n; i++)
    		used[i] = false;
    	combine(S, result, used, res, 0, n, k);
    }
    public void combine(int[] S, ArrayList<ArrayList<Integer>> result, boolean used[],
    		ArrayList<Integer> res, int step, int n, int k){
    	if(step == k) {
    		ArrayList<Integer> rescopy = new ArrayList<Integer>(res);
    		result.add(rescopy);
    	}
    	for(int i = 0; i < n; i++) {
    		if(!used[i]) {
    			for(int j = 0; j <= i; j++)
    				used[j] = true;
    			res.add(S[i]);
    			combine(S, result, used, res, step+1, n, k);
    			for(int j = 0; j <= i; j++)
    				used[j] = false;
    			res.remove(res.size()-1);
    		}
    	}
    }
    public static void main(String[] args) {
    	Subsets s = new Subsets();
    	int []S = {4,1,0};
    	ArrayList<ArrayList<Integer>> result = s.subsets(S);
    	System.out.println(result);
	}
}
