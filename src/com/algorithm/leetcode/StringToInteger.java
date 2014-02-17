package com.algorithm.leetcode;

/**
 * 字符串转整数，考虑所以正常输入，不能正常执行的返回0
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 *  please do not see below and ask yourself what are the possible input cases.
 * @author xiefei
 *
 */
public class StringToInteger {
	/*
	 * 解题思路：
	 * 思路1：  首先去掉前后空白字符，然后扫描，第1个可选是'+'或者'-'
	 * 特殊情况：判断溢出，中间出现不是数字的情况，如-0012a42
	 * 原来直接返回，-0012a42 测试用例过不去，output：0，expected:-12
	 */
	public int atoi(String str) {
        long result = 0;
        str = str.trim();
        int n = str.length();
        if(n==0)
        	return 0;
        boolean neg = false;
        for(int i = 0; i < n; i++) {
        	if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        		result = 10*result + (str.charAt(i)- '0');
        	} else {
        		if(i == 0) {
        			if(str.charAt(i) == '+')
        				neg = false;
        			else if(str.charAt(i) == '-')
        				neg = true;
        			else
        				//return 0;//原来直接返回
        				break;
        		} else {
        			//return 0;//原来直接返回
        			break;
        		}
        	}
        }
        if(neg)
        	result = -result;
        if(result > Integer.MAX_VALUE)
        	result = Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
        	result = Integer.MIN_VALUE;
        return (int)result;
    }
	
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		String str = "  +";
		int result= sti.atoi(str);
		System.out.println(result);
	}
}
