package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 两个数表示为字符串形式，相乘返回字符串。非负数且无限大
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author xiefei
 *
 */
public class MultiplyString {
	/*
	 * 解题思路：
	 * m*n位的结果,总共是m+n位，用数组存储nums[i+j]=num1[m-1-i]*num[n-1-j]
	 * 最后再把数组从低位到高位相加，赋值给result,注意result="000"的情况，要把前面的0都去掉
	 */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        String result = "";
        int nums[] = new int[m+n];
        for(int i = 0; i < m+n; i++)
        	nums[i] = 0;
        for(int i = n-1; i >= 0; i--) {
        	for(int j = m-1; j >= 0; j--) {
        		int mul1 = num1.charAt(j) - '0';
        		int mul2 = num2.charAt(i) - '0';
        		int mul = mul1*mul2;
        		nums[m+n-i-j-2] += mul;
        	}
        }
        for(int i = 0; i < m+n -1; i++) {
        	nums[i+1] += nums[i]/10;
        	nums[i] = nums[i]%10;
        }
        if(nums[m+n-1] > 0) 
        	result += (char)(nums[m+n-1]+48);
        for(int i = m+n-1; i >= 0; i--) {
        	result += (char)(nums[i]+48);
        }
        int i;
        for(i = 0; i < result.length(); i++) {
        	if(result.charAt(i) != '0') 
        		break;
        }
        if(i>=0 && i < result.length()) {
        	result = result.substring(i);
        } else {
        	result = "0";
        }
        return result;
    }
    
    public static void main(String[] args) {
    	MultiplyString ms = new MultiplyString();
    	String num1 = "10";
    	String num2 = "0";
    	String result = ms.multiply(num1, num2);
    	System.out.println(result);
	}
}
