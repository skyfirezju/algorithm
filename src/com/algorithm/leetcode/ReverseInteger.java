package com.algorithm.leetcode;

import java.math.BigInteger;

/**
 * 整数反转
 * 需要注意的问题：
 * 1.整数最后1个数字是0，反转后输出，如10,100
 * 2.反转后的数字可能会溢出，如1000000003会溢出。溢出情况是抛出异常或者
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author xiefei
 *
 */
public class ReverseInteger {
	/*
	 * 解题思路：负数的模还是负数，利用取模得到各位数字，
	 * 然后循环相加，OJ上可以通过，但是没有考虑溢出
	 */
	public int reverse(int x) {
        int result = 0;
        while(x != 0) {
        	result = result*10 + x%10;
        	x = x/10;
        }
        return result;
    }
	
	/*
	 * 思路1：网友版本，考虑溢出，该版本是错误的，
	 * 因为int类型变量不可能存储>Integer.MAX_VALUE
	 */
	public int reverse1(int x) {
        int result = 0;
        boolean neg = x < 0;
        if (neg) x = -x;
        while(x > 0){
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (neg) result = - result;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return result;
    }
	
	/*
	 * 思路2：用long数据类型存储,可以存储最大位数是64大于整形的32位
	 */
	public int reverse2(int x) {
		long result = 0;
        while(x != 0) {
        	result = result*10 + x%10;
        	x = x/10;
        }
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int)result;
        /*
		long result = 0;
        boolean neg = x < 0;
        if (neg) x = -x;
        while(x > 0){
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (neg) result = - result;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int)result;*/
    }
	
	public static void main(String[] args) {
		int x = 0;
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse2(x));
	}

}
