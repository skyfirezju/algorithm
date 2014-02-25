package com.algorithm.leetcode;

/**
 * �ж��ַ����Ƿ�Ϊ����
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
	 * ����˼·��
	 * û������������Ҫ����1e1.1��,��Ϊ��true����ʵe���治������С����
	 * ע�⿼��'+'��'-'
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
