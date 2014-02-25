package com.algorithm.leetcode;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 数组中找出和为固定值的两个元素，假设保证只有1个符合
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author xiefei
 *
 */
public class TwoSum {
	/*
	 * 解题思路：用HashMap存储，key=target-当前元素，value=当前元素下标，
	 * 循环判断，如果已经有当前元素为key，说明之前有一个元素和当前元素相加等于target。
	 */
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; ++i) {
        	if(map.containsKey(numbers[i])) {
        		result[0] = map.get(numbers[i]);
        		result[1] = i + 1;
        		break;
        	} else {
        		map.put(target - numbers[i], i + 1);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.algorithm.leetcode.TwoSum");
		TwoSum twoSum = (TwoSum)clazz.newInstance();
		Method[] methods = clazz.getMethods();
		int numbers[] = {2, 7, 11, 15};
		int target = 9;
		for(Method method : methods) {
			System.out.println(method.toString());
		}
		System.out.println(numbers.getClass().getName());
		Method method = clazz.getMethod("twoSum",int[].class,int.class);
		int[] result = (int[])method.invoke(twoSum, numbers, target);
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
