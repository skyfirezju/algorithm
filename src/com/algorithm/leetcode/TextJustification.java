package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 实现word的英文排版自动对齐功能，每行固定L个单词。
 * 单词和单词间的空隙尽量均匀，左边的要大于右边的
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * @author xiefei
 *
 */
public class TextJustification {
	/*
	 * 解题思路：
	 * wordSum记录已有的单词长度+1进行累加的和，wordCount记录已有的单词个数，因为中间默认会加一个空格" "
	 * 当wordSum + words[i].length() > L，把已有的单词进行对齐，计算剩余的空格位置进行补齐
	 */
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int wordCount = 0;
        int wordSum = 0;
        int i = 0;
        for(; i < words.length; i++) {
        	if(wordSum + words[i].length() <= L) {
        		wordSum += (words[i].length() + 1);
        		wordCount++;
        	} else {
        		int reminder = L - (wordSum - wordCount);
        		if(wordCount == 1){
        			String res = words[i-1];
        			while(reminder-- > 0)
        				res += " ";
        			result.add(res);
        		} else {
        			int base = reminder/(wordCount-1);
        			int add = reminder%(wordCount-1);
        			String res = "";
            		for(int j = wordCount; j >= 1; j--) {
            			res += words[i-j];
            			int n = base;
            			if(add > 0) {
            				n = base + 1;
            				add--;
            			}
            			if(j != 1) {
            				while(n-- > 0){
                				res += " ";
                			}
            			}
            		}
            		result.add(res);
        		}
        		wordCount = 1;
        		wordSum = (words[i].length() + 1);
        	}
        }
        String res = "";
        int reminder = L - wordSum + 1;
        for(int j = wordCount; j >= 1; j--) {
        	if(j != 1)
        		res += words[i-j] + " ";
        	else
        		res += words[i-j];
		}
        while(reminder-- > 0) 
        	res += " ";
        result.add(res);
        return result;
    }
    
	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = {"a"};
		int L = 1;
		ArrayList<String> result = tj.fullJustify(words, L);
		System.out.println(result);
	}
}
