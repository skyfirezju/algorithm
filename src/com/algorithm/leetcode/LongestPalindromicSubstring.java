package com.algorithm.leetcode;
/**
 * ��󳤶Ȼ����Ӵ�
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author xiefei
 *
 */
public class LongestPalindromicSubstring {
	/*
	 * ����˼·������ǰ�������±�start=0,end=length-1��
	 * �Ƚ��ַ���������ȣ���󳤶Ȼ����ַ���s1,s2�Ļ����Ӵ������ֵ
	 * �����ȣ�s3��������Ӵ������s3,���Ϊs[start]+s3+s[length-1],
	 * ����s3,���Ϊs3��������Ӵ�
	 * [�Լ���Ľⷨ]�ݹ�OJ�ϳ�ʱ
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
	 * ˼·1����̬�滮˼�룬����dp[i][j]=true����s[i]��s[j]�ǻ���
	 * dp[i][i]=ture,��s[i]=s[i+1]ʱ��dp[i][i+1]=true
	 * ��len=1,2��չ��len=n����dp[i+1][j-1]=ture��s[i]=s[j]ʱ��dp[i][j]=true
	 * ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�O(n*n)
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
	 * ˼·2���Ի������Ľ�����չ����Ϊ���Ŀ�����������ĸ�м䣬������2N-1������
	 * ����c1,c2����������չ��������Ļ��ģ�O(n)
	 * ʱ�临�Ӷ�O(n*n),�ռ临�Ӷ�o(1)
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
