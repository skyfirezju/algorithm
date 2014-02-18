package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * �������ҳ���Ϊ�̶�ֵ������Ԫ�أ����豣ֻ֤��1������
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
	 * ����˼·����HashMap�洢��key=target-��ǰԪ�أ�value=��ǰԪ���±꣬
	 * ѭ���жϣ�����Ѿ��е�ǰԪ��Ϊkey��˵��֮ǰ��һ��Ԫ�غ͵�ǰԪ����ӵ���target��
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
}
