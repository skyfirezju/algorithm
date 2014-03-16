package com.algorithm.leetcode;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning
 *  it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children,
 *  it produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * @author xiefei
 *
 */
public class ScrambleString {
	/*
	 * 解题思路：
	 * s1[i] == s2[i]否则在s2中搜索s1[i]-> end
	 * 看s1[i...end] 和s2[i..end]是否是逆转的，这个思路是错的
	 * [注意] a = a 一个本身
	 */
    public boolean isScramble1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m == 0 || m == 1 || m != n)return false;
        boolean isCramble = false;
        int i = 0;
        while(i < m){
        	if(s1.charAt(i) == s2.charAt(i)) {
        		i++;
        	} else {
        		int end = search(s2, s1.charAt(i), i);
        		System.out.println(end);
        		if(end < n) {
        			int ps = i, pe = end;
        			while(ps <= end) {
        				if(s1.charAt(ps) == s2.charAt(pe)) {
        					ps++;
        					pe--;
        				} else {
        					return false;
        				}
        			}
        			isCramble = true;
        			i = end + 1;
        		} else {
        			return false;
        		}
        	}
        }
        return isCramble;
    }
    int search(String s2, char x, int start) {
    	int i = start;
    	for(; i < s2.length(); i++) {
    		if(s2.charAt(i) == x)break;
    	}
    	return i;
    }
    
    /*
     * 思路2：
     * s1 [0,...,i-1] [i,...,m-1]
     * s2 [0,...,i-1] [i,...,m-1]
     * 或者反过来
     * s1 [0,...,i-1] [i,...,m-1]
     * s2 [m-i,...,m-1] [0,...,m-i-1]
     */
    public boolean isScramble(String s1, String s2) {
    	int m = s1.length();
        int n = s2.length();
        if(m != n)return false;
        if(m == 0)return true;
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        if(m == 1)return c1[0] == c2[0];
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0; i < m; i++) {
        	if(c1[i] != c2[i])
        		return false;
        }
        boolean result = false;
        for(int i = 1; i < m; i++) {
        	result = isScramble(s1.substring(0,i), s2.substring(0,i))
        			&& isScramble(s1.substring(i), s2.substring(i));
        	result = result || (isScramble(s1.substring(0, i), s2.substring(m - i))
        			&& isScramble(s1.substring(i), s2.substring(0, m - i)));
        	if(result)return true;
        }
        return result;
    }
    public static void main(String[] args) {
    	ScrambleString s = new ScrambleString();
    	String s1 = "abcd";
    	String s2 = "dbac";
    	System.out.println(s.isScramble(s1, s2));
	}
}
