package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * @author xiefei
 *
 */
public class CountAndSay {
	/*
	 * 解题思路：递归调用，按照方法对前一个解读，
	 * 统计连续的数字m的个数n,result += "nm";
	 */
    public String countAndSay(int n) {
        if(n == 1)
        	return "1";
        String result = "";
        String text = countAndSay(n-1);
        char prev = ' ';
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
        	char cur = text.charAt(i);
        	if(cur != prev) {
        		if(count>0) {
        			result += Integer.toString(count) + prev;
        		}
        		prev = cur;
        		count = 1;
        	} else {
        		count++;
        	}
        }
        result += Integer.toString(count) + prev;
        return result;
    }
    public static void main(String[] args) {
    	CountAndSay cas = new CountAndSay();
    	int n = 7;
    	System.out.println(cas.countAndSay(n));
	}
}
