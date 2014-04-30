package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author xiefei
 *
 */
public class PascalTriangle {
	/*
	 * 解题思路：两个数组交替赋值
	 */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(numRows <= 0)
    		return result;
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	res.add(1);
    	result.add(res);
        for(int i = 1; i < numRows; i++) {
        	ArrayList<Integer> res2 = new ArrayList<Integer>();
        	res2.add(1);
        	for(int j = 0; j < res.size()-1; j++) {
        		res2.add(res.get(j) + res.get(j+1));
        	}
        	res2.add(1);
        	result.add(res2);
        	res = new ArrayList<Integer>(res2);
        }
        return result;
    }
    public static void main(String[] args) {
    	PascalTriangle pt = new PascalTriangle();
    	int numRows = 4;
    	ArrayList<ArrayList<Integer>> result = pt.generate(numRows);
    	System.out.println(result);
	}
}
