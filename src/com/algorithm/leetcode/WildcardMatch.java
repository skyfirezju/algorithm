package com.algorithm.leetcode;

/**
 * str�Ƿ��patternƥ�䣬'?'ƥ�䵥���ַ�,'*'ƥ��0������ַ�
 * implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") �� false
 * isMatch("aa","aa") �� true
 * isMatch("aaa","aa") �� false
 * isMatch("aa", "*") �� true
 * isMatch("aa", "a*") �� true
 * isMatch("ab", "?*") �� true
 * isMatch("aab", "c*a*b") �� false
 * @author xiefei
 *
 */
public class WildcardMatch {
	/*
	 * ����˼·��
	 * ��p0��='*'��ֱ��ƥ��c0 == p0 || ((c0 != '\0') && (p0 == '?'),ƥ����һ��
	 * ���򷵻�false��
	 * ��p0=='*'ʱ������ƥ�䵱ǰ
	 * OJ�ݹ�ջ������ܳ���"aa....a"�� "*"
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
	 * ˼·2��
	 * ��heads��¼s�ĵ�һ���ַ���λ�ã�ά��s0,��headp��¼p�ĵ�һ���ַ���λ�ã�ά��p0
	 * s0!='\0'
	 * p0 == '?' || s0 == p0 ƥ��,heads++,headp++,s��p������
	 * p0 == '*'ʱ������ƥ��һ��������star=headp��¼�Ǻŵ�λ�ã�p���ƣ�s������ss��¼s��λ��
	 * star==-1,û��'*'ֱ��return false
	 * star!=-1,headp=star+1,����p0,heads=++ss����s0
	 * ���pȫ����**��ɣ�return true������return false
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
