package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * �����룬���ڵ����ֶ�����ֻ��1λ��ͬ
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * @author xiefei
 *
 */
public class GrayCode {
	/*
	 * n = 1ʱ =�� 0,1
	 * �����Ƴ�n=2ʱ����1�Ļ�����ǰ�벿����ֱ��+0����벿���Ƿ�������2^(n-1)
	 * 00
	 * 01
	 * ---
	 * 11
	 * 10
	 */
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(n == 0) {
    		result.add(0);
    		return result;
    	}
        ArrayList<Integer> pre = grayCode(n-1);
        for(int i = 0; i < pre.size(); i++) {
        	result.add(pre.get(i));
        }
        for(int i = pre.size()-1; i >= 0; i--) {
        	int head = 1 << (n-1);
        	result.add(pre.get(i) + head);
        }
        return result;
    }
    public static void main(String[] args) {
    	GrayCode g = new GrayCode();
    	int n = 0;
    	System.out.println(g.grayCode(n));
	}
}
