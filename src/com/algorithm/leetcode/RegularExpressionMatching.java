package com.algorithm.leetcode;

/**
 * 用'.'和'*'进行正则表达式匹配
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * @author xiefei
 *
 */
public class RegularExpressionMatching {
	/*
	 * 解题思路：
	 * s中的任何字符p中都要对应，设置左右两个指针，当p为空的时候，s不空代表没有完全匹配。
	 * 当p不为空的时候，执行以下。
	 * s0为s的第0个字符，当s为空时，s0='\0'。
	 * 如果下一个p1！='*'，代表必须p0,s0匹配或者p0=='.'匹配任意，再递归的调用下一个isMatch(s+1,p+1)
	 * 如果下一个p1=='*'，贪心的匹配，可以循环(s0 == p0) || (p0 == '.' && s0!='\0')
	 * 因为贪心的匹配可能会错，所以如果isMatch(s,p+2)直接返回true[关键]
	 * 递归isMatch(s,p+2)
	 */
	public boolean isMatch(String s, String p) {
		if(p.equals(""))
			return s.equals("");
		char s0 = s.length()>0?s.charAt(0):'\0';
		char p0 = p.charAt(0);
		char p1 = p.length()>1 ? p.charAt(1):'\0';
		if(p1 != '*') {
			return ((s0 == p0) || (p0 == '.' && s0!='\0'))
					&& isMatch(s.substring(1),p.substring(1));
		}
		//System.out.println("s0:" + s0 + ", p0:" + p0);
		while((s0 == p0) || (p0 == '.' && s0!='\0')){
			if(isMatch(s, p.substring(2)))
				return true;
			s = s.substring(1);
			s0 = s.length()>0?s.charAt(0):'\0';
		}
		return isMatch(s, p.substring(2));
    }
	
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		String s = "";
		String p = "aaa";
		System.out.println(rem.isMatch(s, p));
	}
}
