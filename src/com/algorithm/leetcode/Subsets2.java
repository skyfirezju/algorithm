package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合元素有重复，求所有不重复子集
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * @author xiefei
 *
 */
public class Subsets2 {
	/*
	 * 解题思路：
	 * subsets上面改下，但是有问题
	 */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        Arrays.sort(num);
    	for(int i = 0; i <= n; i++) {
        	combine(result, num, n, i);
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
    			while(i <= n-2 && S[i] == S[i+1])
    				i++;
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
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup1(int[] num) {
    	if (num.length == 0) {
			return null;
		}
		Arrays.sort(num);
		int[] backtrack = new int[num.length+1];
		backtrack[0] = -1;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ss(num, result, 0, backtrack);
		return result;
    }
    
    public void ss(int[] num, ArrayList<ArrayList<Integer>> result, int pos, int[] backtrack) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 1; i <= pos; i++) {
			x.add(num[backtrack[i]]);
		}
		result.add(x);
		for (int i = backtrack[pos] + 1; i < num.length; i++) {
			backtrack[pos + 1] = i;
			ss(num, result, pos + 1,  backtrack);
			while (i + 1 < num.length && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
    
    public static void main(String[] args) {
    	Subsets2 s = new Subsets2();
    	int num[] = {1,2,2};
    	ArrayList<ArrayList<Integer>> result = s.subsetsWithDup1(num);
    	System.out.println(result);
	}
}
