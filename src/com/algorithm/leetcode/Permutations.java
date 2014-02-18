package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 全排列
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author xiefei
 *
 */
public class Permutations {
	/*
	 * 解题思路：
	 * 搜索执行，used[i]记录第i个是否使用过，对每一个元素从前往后，都是有2种情况，使用perm[step]=num[i]，
	 * 或者不使用，递归退出条件，执行步数step=num.length
	 */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int n = num.length;
    	int perm[] = new int[n];
    	boolean used[] = new boolean[n];
    	for(int i = 0; i < n; i++) {
    		used[i] = false;
    	}
    	subPermute(num, used, 0, perm, result);
    	return result;
    }
    
    public void subPermute(int[] num, boolean[] used,int step, int[] perm, 
    		ArrayList<ArrayList<Integer>> result) {
    	if(step == num.length) {
    		ArrayList<Integer> res = new ArrayList<Integer>();
    		for(int i = 0; i < perm.length; i++) {
    			res.add(perm[i]);
    		}
    		result.add(res);
    	}
    	for(int i = 0; i < num.length; i++) {
    		if(!used[i]) {
    			used[i] = true;
    			perm[step] = num[i];
    			subPermute(num, used, step+1, perm, result);
    			used[i] = false;
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Permutations p = new Permutations();
    	int num[] = {1,2,3};
    	ArrayList<ArrayList<Integer>> res = p.permute(num);
    	for(int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i));
    	}
	}
}
