package com.algorithm.leetcode;

/**
 * �ַ����ɵ��ʺͿո���ɣ��������һ�����ʵĳ���
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
	 * ����˼·��
	 * curLength������ǰ���ȣ�lastLength��󳤶�ѭ��ɨ��
	 * ��Ϊ' ',curLength++;==''ʱ,curLength>0�͸���
	 * lastLength = curLength,curLength = 0;
	 * ע��������������һֱû�пո񣬻���Ҫ��ֵlastLength
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
