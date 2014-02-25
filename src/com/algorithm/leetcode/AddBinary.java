package com.algorithm.leetcode;

/**
 * 二进制相加，返回字符串
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author xiefei
 *
 */
public class AddBinary {
	/*
	 * 解题思路：
	 * 从末位往前扫描，逐行累加进位
	 */
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(m == 0 || n == 0)return "";
        int add = 0;
        String str = "";
        int i, j;
        for(i = m-1, j = n-1; i >= 0 && j >=0; i--,j--) {
        	int num = add + (a.charAt(i) - '0') + (b.charAt(j) - '0');
        	str = (char)(num%2 + 48) + str;
        	add = num >= 2 ? 1 : 0;
        }
        while(i >= 0) {
        	int num = add + (a.charAt(i--) - '0');
        	str = (char)(num%2 + 48) + str;
        	add = num >= 2 ? 1 : 0;
        }
        while(j >= 0) {
        	int num = add + (b.charAt(j--) - '0');
        	str = (char)(num%2 + 48) + str;
        	add = num >= 2 ? 1 : 0;
        }
        if(add != 0) {
        	str = (char)(add + 48) + str;
        }
        return str;
    }
    public static void main(String[] args) {
    	AddBinary ab = new AddBinary();
    	String a = "110";
    	String b = "111";
    	String result = ab.addBinary(a, b);
    	System.out.println(result);
	}
    
}
