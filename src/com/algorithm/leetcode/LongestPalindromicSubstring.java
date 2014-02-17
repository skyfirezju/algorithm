package com.algorithm.leetcode;
/**
 * 最大长度回文子串
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author xiefei
 *
 */
public class LongestPalindromicSubstring {
	/*
	 * 解题思路：设置前后两个下标start=0,end=length-1。
	 * 比较字符，如果不等，最大长度回文字符串s1,s2的回文子串的最大值
	 * 如果相等，s3的最长回文子串如果是s3,结果为s[start]+s3+s[length-1],
	 * 不是s3,结果为s3的最长回文子串
	 * [自己想的解法]递归OJ上超时
	 */
	public String longestPalindrome(String s) {
        String result = "";
        if(s.equals(""))
        	return result;
        if(s.length() == 1)
        	return s;
        int start = 0, end = s.length() - 1;
        if(s.charAt(start) != s.charAt(end)) {
        	String s1 = longestPalindrome(s.substring(start, end));
        	String s2 = longestPalindrome(s.substring(start+1, end+1));
        	if(s1.length() > s2.length()) {
        		result = s1;
        	}
        	if(s1.length() < s2.length()) {
        		result = s2;
        	}
        } else {
        	String s3 = longestPalindrome(s.substring(start +1, end));
        	if(s3.length() == end - start -1) {
        		result = s.charAt(start) + s3 + s.charAt(end);
        	} else {
        		result = s3;
        	}
        }
        return result;
    }
	
	/*
	 * 思路1：动态规划思想，设置dp[i][j]=true代表s[i]到s[j]是回文
	 * dp[i][i]=ture,当s[i]=s[i+1]时，dp[i][i+1]=true
	 * 由len=1,2拓展到len=n。当dp[i+1][j-1]=ture和s[i]=s[j]时，dp[i][j]=true
	 * 时间复杂度O(n*n),空间复杂度O(n*n)
	 */
	public String longestPalindrome1(String s) {
		boolean dp[][] = new boolean[1000][1000];
		int maxLen = 1;
		int longestBegin = 0;
		int n = s.length();
		if(n == 0)
			return "";
		if(n == 1)
			return s;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(i==j)
					dp[i][j] = true;
				else if(i + 1 == j) {
					if(s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						longestBegin = i;
						maxLen = 2;
					}
				} else
					dp[i][j] = false;
		
		for(int len = 3; len <= n; len++) {
			for(int i = 0; i < n - len + 1; i++) {
				int j = i + len -1;
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					longestBegin = i;
					maxLen = len;
				}
			}
		}
		return s.substring(longestBegin, longestBegin + maxLen);
	}
	
	/*
	 * 思路2：以回文中心进行扩展，因为中心可能在两个字母中间，所以有2N-1个中心
	 * 设置c1,c2，往左右扩展，返回最长的回文，O(n)
	 * 时间复杂度O(n*n),空间复杂度o(1)
	 */
	public String longestPalindrome2(String s) {
		if(s.equals(""))
			return "";
		String result = s.substring(0, 1);
		for(int i = 0; i < s.length() -1; i++) {
			String s1 = expandCenter(s, i, i);
			if(s1.length() > result.length()) {
				result = s1;
			}
			String s2 = expandCenter(s, i, i+1);
			if(s2.length() > result.length()) {
				result = s2;
			}
		}
		return result;
	}
	
	public String expandCenter(String s, int c1, int c2) {
		int l = c1, r = c2;
		while(l>=0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l+1, r);
	}
	
	
}
