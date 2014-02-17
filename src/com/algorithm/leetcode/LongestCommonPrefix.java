package com.algorithm.leetcode;

/**
 * 字符串数组里找最长公共前缀
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author xiefei
 *
 */
public class LongestCommonPrefix {
	/*
	 * 解题思路：
	 * 比较2个字符串最长公共前缀，设字符串长度m，时间复杂度O(m)
	 * n个字符串比较，更新前缀，时间复杂度O(n*m)
	 * 注意边界条件:strs数组长度为0,防止数组溢出，返回""
	 * strs数组长度为1，不做判断OJ上超时，直接返回第1个字符串
	 */
	public String longestCommonPrefix(String[] strs) {
		int n = strs.length;
		if(n == 0)
			return "";
        String result = strs[0];
        if(n == 1)
        	return result;
        for(int i = 1; i < n; i++) {
        	String prefix = commonPrefix(result, strs[i]);
        	result = prefix;
        }
        return result;
    }
	
	String commonPrefix(String s1, String s2)
	{
		int end = 0;
		while(end < s1.length() && end < s2.length()
				&& s1.charAt(end) == s2.charAt(end)){
			++end;
		}
		return s1.substring(0, end);
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix LCP  = new LongestCommonPrefix();
		String strs[] = {"abccef","abd","abe"};
		System.out.println(LCP.longestCommonPrefix(strs));
		//System.out.println("abc".substring(0,3));
	}
}
