package com.algorithm.leetcode;
/**
 * ZigZagת��
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
	 * ����˼·����ÿ�е������±꣬���ֹ��ɡ�nRows=3ʱ����1����0,4,8,12;
	 * nRows=4ʱ����1����0,6,12�����Է��ּ����2*(nRows-1)��
	 * ��1�к����1���ǵȲ����У��м�Ļ���һ�����֣������2*(nRows-1)-2*i
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
