package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 在S中找L单词拼成的子串的下标
 * You are given a string, S, and a list of words, L, 
 * that are all of the same length. 
 * Find all starting indices of substring(s) in S 
 * that is a concatenation of each word in L exactly once 
 * and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * @author xiefei
 *
 */
public class SubstrWithConcatenationAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int m = L.length;
    	int n = S.length();
    	if(m == 0 || n == 0)
    		return result;
    	int len = L[0].length();
        for(int i = 0; i <= n - m*len; i++) {
        	String str = S.substring(i, i+m*len);
        	if(isConcatenation(str,L))
        		result.add(i);
        }
        return result;
    }
    boolean isConcatenation(String S, String[] L) {
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	int n = S.length();
    	int m = L.length;
    	for(int i = 0; i < m; i++) {
    		if(map.containsKey(L[i])) {
    			map.put(L[i], map.get(L[i]) + 1);
    		} else {
    			map.put(L[i], 1);
    		}
    	}
    	int len = L[0].length();
    	for(int i = 0; i <n; i+=len) {
    		String str = S.substring(i,i+len);
    		if(map.containsKey(str)) {
    			int count = map.get(str);
    			if(count > 0) {
    				map.put(str, count-1);
    			} else {
    				return false;
    			}
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
    	SubstrWithConcatenationAllWords swcaw = new SubstrWithConcatenationAllWords();
    	String S = "barfoothefoobarman";
    	String L[] = {"foo", "bar"};
    	ArrayList<Integer> result= swcaw.findSubstring(S, L);
    	System.out.println(result);
	}
}
