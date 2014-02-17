package com.algorithm.leetcode;

/**
 * ��'.'��'*'����������ʽƥ��
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
 * isMatch("aa","a") �� false
 * isMatch("aa","aa") �� true
 * isMatch("aaa","aa") �� false
 * isMatch("aa", "a*") �� true
 * isMatch("aa", ".*") �� true
 * isMatch("ab", ".*") �� true
 * isMatch("aab", "c*a*b") �� true
 * @author xiefei
 *
 */
public class RegularExpressionMatching {
	/*
	 * ����˼·��
	 * s�е��κ��ַ�p�ж�Ҫ��Ӧ��������������ָ�룬��pΪ�յ�ʱ��s���մ���û����ȫƥ�䡣
	 * ��p��Ϊ�յ�ʱ��ִ�����¡�
	 * s0Ϊs�ĵ�0���ַ�����sΪ��ʱ��s0='\0'��
	 * �����һ��p1��='*'���������p0,s0ƥ�����p0=='.'ƥ�����⣬�ٵݹ�ĵ�����һ��isMatch(s+1,p+1)
	 * �����һ��p1=='*'��̰�ĵ�ƥ�䣬����ѭ��(s0 == p0) || (p0 == '.' && s0!='\0')
	 * ��Ϊ̰�ĵ�ƥ����ܻ���������isMatch(s,p+2)ֱ�ӷ���true[�ؼ�]
	 * �ݹ�isMatch(s,p+2)
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
