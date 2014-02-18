package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 全排列，集合有重复的情况
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * @author xiefei
 *
 */
public class Permutations2 {
	/*
	 * 解题思路：排序，扫描时跳过重复的元素
	 */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int n = num.length;
    	int perm[] = new int[n];
    	boolean used[] = new boolean[n];
    	for(int i = 0; i < n; i++) {
    		used[i] = false;
    	}
    	Arrays.sort(num);
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
    			while(i+1<num.length && num[i+1] == num[i]) {
    				i++;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Permutations2 p = new Permutations2();
    	int num[] = {1,1,2};
    	ArrayList<ArrayList<Integer>> res = p.permuteUnique(num);
    	for(int i = 0; i < res.size(); i++) {
    		System.out.println(res.get(i));
    	}
	}
}
