package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author xiefei
 *
 */
public class PascalTriangle2 {
	/*
	 * 解题思路：两个数组交替赋值
	 */
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(rowIndex < 0)
    		return res;
    	res.add(1);
        for(int i = 1; i <= rowIndex; i++) {
        	ArrayList<Integer> res2 = new ArrayList<Integer>();
        	res2.add(1);
        	for(int j = 0; j < res.size()-1; j++) {
        		res2.add(res.get(j) + res.get(j+1));
        	}
        	res2.add(1);
        	res = new ArrayList<Integer>(res2);
        }
        return res;
    }
    public static void main(String[] args) {
    	PascalTriangle2 pt = new PascalTriangle2();
    	int rowIndex = 2;
    	ArrayList<Integer> res = pt.getRow(rowIndex);
    	System.out.println(res);
	}
}
