package com.algorithm.leetcode;

/**
 * str是否和pattern匹配，'?'匹配单个字符,'*'匹配0到多个字符
 * implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * @author xiefei
 *
 */
public class WildcardMatch {
	/*
	 * 解题思路：
	 * 当p0！='*'，直接匹配c0 == p0 || ((c0 != '\0') && (p0 == '?'),匹配下一个
	 * 否则返回false，
	 * 但p0=='*'时，可以匹配当前
	 * OJ递归栈溢出，很长的"aa....a"， "*"
	 */
	public boolean isMatch(String s, String p) {
        if(p.equals(""))
        	return s.equals("");
        char c0 = s.length() > 0 ? s.charAt(0) : '\0';
        char p0 = p.charAt(0);
        if(p0 != '*') {
        	if(c0 == p0 || ((c0 != '\0') && (p0 == '?'))) {
        		return isMatch(s.substring(1),p.substring(1));
        	} else {
        		return false;
        	}
        }
        if(c0 != '\0') {
            if(isMatch("",p.substring(1)))
            	return true;
            return isMatch(s,p.substring(1));
        } else {
        	return isMatch(s,p.substring(1));
        }
    }
	
	/*
	 * 思路2：
	 * 用heads记录s的第一个字符的位置，维持s0,用headp记录p的第一个字符的位置，维持p0
	 * s0!='\0'
	 * p0 == '?' || s0 == p0 匹配,heads++,headp++,s和p都后移
	 * p0 == '*'时，可以匹配一个或多个，star=headp记录星号的位置，p后移，s不动，ss记录s的位置
	 * star==-1,没有'*'直接return false
	 * star!=-1,headp=star+1,更新p0,heads=++ss更新s0
	 * 最后p全部是**组成，return true，否则return false
	 */
	public boolean isMatch1(String s, String p) {
		char s0 = s.length() > 0 ? s.charAt(0):'\0';
		char p0 = p.length() > 0 ? p.charAt(0):'\0';
		int heads = 0,headp = 0,star = -1,ss=0;
		while(s0 != '\0') {
			if(p0 == '?' || s0 == p0){
				heads++;headp++;
				s0 = heads < s.length() ? s.charAt(heads):'\0';
				p0 = headp < p.length() ? p.charAt(headp):'\0';
				continue;
			}
			if(p0 == '*') {
				star = headp++;
				p0 = headp < p.length() ? p.charAt(headp):'\0';
				ss = heads;
				continue;
			}
			if(star != -1) {
				headp = star+1;
				p0 = headp < p.length() ? p.charAt(headp):'\0';
				heads = ++ss;
				s0 = heads < s.length() ? s.charAt(heads):'\0';
				continue;
			}
			return false;
		}
		while(p0 == '*') {
			headp++;
			p0 = headp < p.length() ? p.charAt(headp):'\0';
		}
		return p0 == '\0';
	}
	
	public static void main(String[] args) {
		WildcardMatch wm = new WildcardMatch();
		String s = "abeed";
		String p = "?b*d";
		System.out.println(wm.isMatch1(s, p));
	}
}
