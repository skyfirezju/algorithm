package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T,
 * return the emtpy string "".
 * If there are multiple such windows, you are guaranteed 
 * that there will always be only one unique minimum window in S
 * @author xiefei
 *
 */
public class MinimumWindowSubstring {
	/*
	 * 解题思路：
	 *         A D O B E C O D E B A N C
	 * seq[]   0     3   5       9 10  12
	 * 然后在seq数组里面暴力搜索最小的窗口
	 */
    public String minWindow(String S, String T) {
        int m = S.length();
        int n = T.length();
        if(m == 0 || n == 0)return "";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        ArrayList<Integer> seq = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
        	if(!map.containsKey(T.charAt(i))) {
        		map.put(T.charAt(i), 1);
        	} else {
        		map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(map.containsKey(S.charAt(i)))
        		seq.add(i);
        }
        int len = seq.size();
        if(len < n)return "";
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        for(int k = n; k <= len; k++) {
        	for(int i = 0; i + k -1 < len; i++) {
        		if(isContain(seq, i, i + k -1, map, S, n)) {
        			if(seq.get(i + k -1) - seq.get(i) < min) {
        				min = seq.get(i + k -1) - seq.get(i);
        				l = seq.get(i);
        				r = seq.get(i + k -1);
        			}
        		}
        	}
        }
        if(min != Integer.MAX_VALUE) {
        	return S.substring(l, r + 1);
        } else {
        	return "";
        }
    }
    
    public boolean isContain(ArrayList<Integer> seq,
    		int l, int r, HashMap<Character,Integer> map, String S, int n) {
    	int count = 0;
    	HashMap<Character,Integer> mapcopy = new HashMap<Character,Integer>(map);
    	for(int i = l; i <= r; i++) {
    		if(mapcopy.containsKey(S.charAt(seq.get(i)))) {
    			int value = mapcopy.get(S.charAt(seq.get(i)));
    			if(value > 0) {
    				mapcopy.put(S.charAt(seq.get(i)), value-1);
    				count++;
    			}
    		}
    	}
    	return count == n;
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring mws = new MinimumWindowSubstring();
    	String S = "ADOBECODEBANC";
    	String T = "ABC";
    	System.out.println(mws.minWindow(S, T));
	}
}
