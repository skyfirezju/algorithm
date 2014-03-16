package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * n个元素的集合里面选择k个
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @author xiefei
 *
 */
public class Combinations {
	/*
	 * 解题思路：
	 * used[i]之前都置为false，可以保证顺序输出1,2;1,3;1,4;2,3;2,4;3,4
	 */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	boolean used[] = new boolean[n];
    	for(int i = 0; i < n; i++)
    		used[i] = false;
    	combine(result, used, res, 0, n, k);
    	return result;
    }
    public void combine(ArrayList<ArrayList<Integer>> result, boolean used[],
    		ArrayList<Integer> res, int step, int n, int k){
    	if(step == k) {
    		ArrayList<Integer> rescopy = new ArrayList<Integer>(res);
    		result.add(rescopy);
    	}
    	for(int i = 0; i < n; i++) {
    		if(!used[i]) {
    			for(int j = 0; j <= i; j++)
    				used[j] = true;
    			res.add(i+1);
    			combine(result, used, res, step+1, n, k);
    			for(int j = 0; j <= i; j++)
    				used[j] = false;
    			res.remove(res.size()-1);
    		}
    	}
    }
    public static void main(String[] args) {
    	Combinations c = new Combinations();
    	int n = 5;
    	int k = 2;
    	ArrayList<ArrayList<Integer>> result = c.combine(n, k);
    	System.out.println(result);
	}
}
