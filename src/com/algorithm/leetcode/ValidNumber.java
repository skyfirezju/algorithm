package com.algorithm.leetcode;

/**
 * 判断字符串是否为数字
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * @author xiefei
 *
 */
public class ValidNumber {
	/*
	 * 解题思路：
	 * 没有做出来，主要考虑1e1.1等,以为是true，其实e后面不可以有小数点
	 * 注意考虑'+'和'-'
	 * e1.1
	 * 1..1
	 * 1ee1
	 * e2
	 * 1e+2
	 * 
	 */
    public boolean isNumber(String s) {
        String str = s.trim();
        boolean flagE = false;
        boolean flagD = false;
        boolean flagN = false;
        if(str.equals(""))return false;
        int i = 0;
        if(str.charAt(i) == '+' || str.charAt(i) == '-')
        	++i;
        for(; i < str.length(); i++) {
        	char x = str.charAt(i);
        	if(x >= '0' && x <= '9') {
        		flagN = true;
        	} else if(x == '.') {
        		if(flagE || flagD) return false;
        		flagD = true;
        	} else if(x == '+' || x == '-') {
        		if(str.charAt(i-1) != 'e')return false;
        	} else if(x == 'e') {
        		if(flagE || flagN == false)return false;
        		flagE = true;
        		flagN = false;
        	} else {
        		return false;
        	}
        }
        return flagN;
    }
    
    public static void main(String[] args) {
    	ValidNumber vn = new ValidNumber();
    	String s = " 005047e+6";
    	System.out.println(vn.isNumber(s));
	}
    
}
