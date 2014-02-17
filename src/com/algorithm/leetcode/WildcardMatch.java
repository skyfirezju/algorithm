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
	
	public static void main(String[] args) {
		WildcardMatch wm = new WildcardMatch();
		String s = "b";
		String p = "?*?";
		System.out.println(wm.isMatch(s, p));
	}
}
