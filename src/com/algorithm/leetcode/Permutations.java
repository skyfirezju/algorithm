package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * ȫ����
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author xiefei
 *
 */
public class Permutations {
	/*
	 * ����˼·��
	 * ����ִ�У�used[i]��¼��i���Ƿ�ʹ�ù�����ÿһ��Ԫ�ش�ǰ���󣬶�����2�������ʹ��perm[step]=num[i]��
	 * ���߲�ʹ�ã��ݹ��˳�������ִ�в���step=num.length
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
