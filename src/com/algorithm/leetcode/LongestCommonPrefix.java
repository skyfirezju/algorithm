package com.algorithm.leetcode;

/**
 * �ַ����������������ǰ׺
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author xiefei
 *
 */
public class LongestCommonPrefix {
	/*
	 * ����˼·��
	 * �Ƚ�2���ַ��������ǰ׺�����ַ�������m��ʱ�临�Ӷ�O(m)
	 * n���ַ����Ƚϣ�����ǰ׺��ʱ�临�Ӷ�O(n*m)
	 * ע��߽�����:strs���鳤��Ϊ0,��ֹ�������������""
	 * strs���鳤��Ϊ1�������ж�OJ�ϳ�ʱ��ֱ�ӷ��ص�1���ַ���
	 */
	public String longestCommonPrefix(String[] strs) {
		int n = strs.length;
		if(n == 0)
			return "";
        String result = strs[0];
        if(n == 1)
        	return result;
        for(int i = 1; i < n; i++) {
        	String prefix = commonPrefix(result, strs[i]);
        	result = prefix;
        }
        return result;
    }
	
	String commonPrefix(String s1, String s2)
	{
		int end = 0;
		while(end < s1.length() && end < s2.length()
				&& s1.charAt(end) == s2.charAt(end)){
			++end;
		}
		return s1.substring(0, end);
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix LCP  = new LongestCommonPrefix();
		String strs[] = {"abccef","abd","abe"};
		System.out.println(LCP.longestCommonPrefix(strs));
		//System.out.println("abc".substring(0,3));
	}
}
