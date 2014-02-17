package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �����ּ���C��Ѱ��������ϣ�ʹ�����ΪT
 * ����C�����ֿ���ʹ��1��
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * @author xiefei
 *
 */
public class CombinationSum2 {
	/*
	 * ����˼·�����ݣ�ֻ���뵽���¿��������鱣��״̬��
	 * OJ�ϳ���TLE��ʱ
	 */
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combine = new ArrayList<Integer>();
        combine(num, result, combine, 0, target);
        return result;
    }
    public void combine(int[] candidates, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> combine, int start, int target) {
    	int n = candidates.length;
    	if(start>=n)return;
		int reminder = target-candidates[start];
		ArrayList<Integer> new_combine = new ArrayList<Integer>();
		for(int k =0; k < combine.size(); k++) {
			new_combine.add(combine.get(k));
		}
		new_combine.add(candidates[start]);
		if(reminder == 0) {
			result.add(new_combine);
		} else {
			combine(candidates, result, new_combine, start+1, reminder);
		}
		int end = start;
    	while(end < n-1 && candidates[end+1] == candidates[end])
    		end++;
		combine(candidates, result, combine, end+1, target);
    }
    
    /*
     * ˼·2���������֮����ɾ�����ݣ���start��ʼ��
     * ÿ����������ӺͲ����2��ѡ����Ӻ�ݹ�start+1������ӵĲ��ܵݹ飬������ظ���������ѭ������ʾ����ӵ�
     */
    public ArrayList<ArrayList<Integer>> combinationSum22(int[] num, int target) {
        Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combine = new ArrayList<Integer>();
        combine2(num, result, combine, 0, target);
        return result;
    }
    public void combine2(int[] candidates, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> combine, int start, int target) {
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(combine));
    		return;
    	}
    	int prev = -1;
    	for(int i = start; i < candidates.length; i++) {
    		if(prev == candidates[i])continue;
    		if(candidates[i]>target)return;
    		prev = candidates[i];
			combine.add(candidates[i]);
			combine2(candidates,result,combine,i+1,target-candidates[i]);
			combine.remove(combine.size()-1);
    	}
    }
    
    public static void main(String[] args) {
    	CombinationSum2 cs = new CombinationSum2();
    	int []num = {10,1,2,7,6,1,5};
    	int target = 10;
    	ArrayList<ArrayList<Integer>> result = cs.combinationSum22(num, target);
    	for(int i = 0; i < result.size(); i++) 
    		System.out.println(result.get(i));
	}
}
