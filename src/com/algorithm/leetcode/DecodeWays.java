package com.algorithm.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * @author xiefei
 *
 */
public class DecodeWays {
	/*
	 * 解题思路：
	 * 1组成firstNum,头2个满足secondNum
	 * return firstNum + secondNum
	 * OJ超时
	 */
    public int numDecodings(String s) {
        if(s.equals(""))return 0;
        int firstNum = 0, secondNum = 0;
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9') {
        	if(s.substring(1).equals(""))
        		firstNum = 1;
        	else
        		firstNum = numDecodings(s.substring(1));
        }
        if(s.length() < 2)
        	secondNum = 0;
        else {
        	int second = Integer.parseInt(s.substring(0, 2));
        	if(second >= 1 && second <= 26) {
        		if(s.substring(2).equals(""))
            		secondNum = 1;
            	else
            		secondNum = numDecodings(s.substring(2));
        	} else {
        		secondNum = 0;
        	}
        }
        return firstNum + secondNum;
    }
    
    /*
     * 思路2：
     * dp[i]代表从i到n的字符串的解码个数
     * dp[i] = 0                  s[i] = 0;即0X时
     * dp[i] = dp[i+1] + dp[i+2]  10-26时,i!=n-2
     * dp[i] = dp[i+1] + 1        10-26时，i=n-2
     * dp[i] = dp[i+1]            其他
     */
    public int numDecodings1(String s) {
    	int n = s.length();
    	if(n == 0)return 0;
    	int dp[] = new int[n];
    	int i = n - 1;
    	dp[i] = s.charAt(i) == '0' ? 0 : 1;
    	i--;
    	while(i >= 0) {
    		if(s.charAt(i) == '0') {
    			dp[i] = 0;
    		} else if(s.charAt(i) == '1' || (s.charAt(i) == '2'
    				&& s.charAt(i+1) <= '6')){
    			if(i == n -2 ) {
    				dp[i] = dp[i+1] + 1;
    			} else {
    				dp[i] = dp[i+1] + dp[i+2];
    			}
    		} else {
    			dp[i] = dp[i+1];
    		}
    		i--;
    	}
    	return dp[0];
    }
    
    public static void main(String[] args) {
    	DecodeWays dw = new DecodeWays();
    	String s = "1212";
    	System.out.println(dw.numDecodings1(s));
	}
}
