package com.algorithm.clr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 最多连续数子集：
 * 给一个整数数组，找到其中包含最多连续数的自己，比如给：15，7，12，6，14，13，9，11，
 * 则返回5:[11,12,13,14,15]。
 * @author xiefei
 *
 */
public class MaxContinueSubset {
	public ArrayList<Integer> longestConsecutiveItems(int nums[]){
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n = nums.length;
		int max = 0;
		int start = 0;
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(nums[i])){
				int cur = nums[i];
				int cur_start = cur;
				map.put(cur,1);
				Integer prev = map.get(cur-1);
				Integer next = map.get(cur+1);
				if(prev != null)
					map.put(cur, prev+1);
				if(next != null) {
					int last = cur + next;
					int sum = map.get(last) + map.get(cur);
					map.put(cur, sum);
					map.put(last, sum);
				}
				if(prev!=null) {
					int first = cur - prev;
					map.put(first, map.get(cur));
					cur_start = first;
				}
				if(map.get(cur_start) > max) {
					start = cur_start;
					max = map.get(cur_start);
				}
			}
		}
		for(int i = 0; i < max; i++) {
			result.add(start+i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		MaxContinueSubset mcs = new MaxContinueSubset();
		int nums[] = {15,7,12,6,14,13,9,11};
		ArrayList<Integer> result = mcs.longestConsecutiveItems(nums);
		System.out.println(result);
	}
}
