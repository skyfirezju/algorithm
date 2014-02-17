package com.algorithm.leetcode;
/**
 * ZigZag转换
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author xiefei
 *
 */
public class ZigZagConversion {
	/*
	 * 解题思路：从每行的数字下标，发现规律。nRows=3时，第1行是0,4,8,12;
	 * nRows=4时，第1行是0,6,12，可以发现间隔是2*(nRows-1)。
	 * 第1行和最后1行是等差数列，中间的还有一个数字，间隔是2*(nRows-1)-2*i
	 */
	public String convert(String s, int nRows) {
        String result = "";
        int n = s.length();
        if(nRows == 1) 
        	return s;
        for(int i = 0; i < nRows; i++) {
        	int cur = i;
    		while(cur < n) {
    			result += s.charAt(cur);
    			if(i > 0 && i < nRows -1) {
    				if(cur + 2*(nRows-1)-2*i < n) {
    					result += s.charAt(cur + 2*(nRows-1)-2*i);
    				}
    			}
    			cur += 2*(nRows-1);
    		}
        }
        return result;
    }
	
	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int nRows = 4;
		String result = zzc.convert(s, nRows);
		System.out.println(result);
	}
}
