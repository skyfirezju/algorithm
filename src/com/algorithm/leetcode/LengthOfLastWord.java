package com.algorithm.leetcode;

/**
 * 字符串由单词和空格组成，返回最后一个单词的长度
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * @author xiefei
 *
 */
public class LengthOfLastWord {
	/*
	 * 解题思路：
	 * curLength计数当前长度，lastLength最后长度循环扫描
	 * 不为' ',curLength++;==''时,curLength>0就更新
	 * lastLength = curLength,curLength = 0;
	 * 注意特殊情况：最后一直没有空格，还需要赋值lastLength
	 */
    public int lengthOfLastWord(String s) {
        int lastLength = 0;
        int curLength = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) != ' ') {
        		curLength++;
        	} else {
        		if(curLength > 0) {
        			lastLength = curLength;
        		}
        		curLength = 0;
        	}
        }
        if(curLength > 0) {
			lastLength = curLength;
		}
        return lastLength;
    }
    public static void main(String[] args) {
    	LengthOfLastWord ll = new LengthOfLastWord();
    	String s = "a a ab a";
    	System.out.println(ll.lengthOfLastWord(s));
	}
}
