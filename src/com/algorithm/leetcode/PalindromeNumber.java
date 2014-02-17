package com.algorithm.leetcode;

/**
 * 判断整数是否回文
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author xiefei
 *
 */
public class PalindromeNumber {
	/*
	 * 解题思路：整数逆转是否与本身相等
	 * 思考1：-121是否算回文，负数不是回文
	 * 思考2：整数逆转会溢出，OJ上通过了，
	 * 原因是逆转后溢出的例子，如1000000003肯定不是回文，恰好蒙对了
	 */
	public boolean isPalindrome(int x) {
        int reverse = 0;
        int original = x;
        if(x < 0)return false;
        while(x > 0) {
        	reverse = reverse*10 + x%10;
        	x = x/10;
        }
        return reverse == original;
    }
	
	/*
	 * 思路2：循环依次比较最高位和最低位数字，如果不等，就不是回文
	 * 每次去掉最高位和最低位
	 */
	public boolean isPalindrome1(int x) {
		if(x < 0)
			return false;
		int div = 1;
		//div是高位模,x/div是最高位
		while(x/div >= 10) {
			div = div *10;
		}
		while(x > 0) {
			int high = x/div;
			int low = x%10;
			if(high != low)
				return false;
			x = (x%div)/10;//去掉高位和低位数字
			div = div/100;//去掉2位
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		int x = 13100;
		System.out.println(pn.isPalindrome1(x));
	}
}
