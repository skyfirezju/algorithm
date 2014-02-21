package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * ���Ĺ��ʷ�
 * Input: ["tea","and","ate","eat","den"]
 * Ouput: ["tea","ate","eat"]
 * Given an array of strings, 
 * return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * @author xiefei
 *
 */
public class Anagrams {
	/*
	 * ����˼·��
	 * ���ַ������򣬱Ƚ��Ƿ���ͬ����HashMap<String,Integer>keyΪstr��valueΪ�±�
	 * �����ҵ�ԭ�ַ�������һ����ʱ����±꣬������ͬ��ʱ�򣬰��±��Ӧ��Ԫ��add������value����Ϊ-1��
	 * ��֤��һ��Ԫ��ֻ����1�Ρ�
	 */
    public ArrayList<String> anagrams(String[] strs) {
        int n = strs.length;
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < n; i++) {
        	char[] s = strs[i].toCharArray();
        	Arrays.sort(s);
        	String str = new String(s);
        	if(!map.containsKey(str)) {
        		map.put(str, i);
        	} else {
        		if(map.get(str) >= 0) {
        			result.add(strs[map.get(str)]);
        			map.put(str, -1);
        		}
        		result.add(strs[i]);
        	}
        } 
        return result;
    }
    public static void main(String[] args) {
    	Anagrams a = new Anagrams();
    	String strs[] = {"tea","and","ate","eat","den"};
    	ArrayList<String> result = a.anagrams(strs);
    	System.out.println(result);
	}
}
