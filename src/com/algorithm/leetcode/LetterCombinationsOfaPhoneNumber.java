package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 电话数字的字母组合
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author xiefei
 *
 */
public class LetterCombinationsOfaPhoneNumber {
	/*
	 * 解题思路：递归，用数组存储字母数字对应字典
	 * [错误1]需要注意digits=""，输出为[""]，不是[]
	 * [错误2]超时，猜测可能原因是数字越界
	 */
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
        String digitLetter[] = {"abc","def","ghi","jkl",
        		"mno","pqrs","tuv","wxyz"};
        int n = digits.length();
        if(n==0){
        	result.add("");
        	return result;
        }
        String firstLetter = digitLetter[digits.charAt(0) - '2'];
        ArrayList<String> next = letterCombinations(digits.substring(1));
        for(int i = 0; i < firstLetter.length(); i++) {
        	for(int j = 0; j < next.size(); j++){
        		String combination = firstLetter.charAt(i) + next.get(j);
        		result.add(combination);
        	}
        }
        return result;
    }
	/*
	 * 思路2：HashMap<Integer,String>存储字母数字对应字典
	 */
	HashMap<Integer,String> digitLetter = new HashMap<Integer,String>();
	public ArrayList<String> letterCombinations1(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		initDict();
        int n = digits.length();
        if(n==0){
        	result.add("");
        	return result;
        }
        String firstLetter = digitLetter.get(digits.charAt(0)-'0');
        ArrayList<String> next = letterCombinations(digits.substring(1));
        for(int i = 0; i < firstLetter.length(); i++) {
        	for(int j = 0; j < next.size(); j++){
        		String combination = firstLetter.charAt(i) + next.get(j);
        		result.add(combination);
        	}
        }
        return result;
	}
	
	public void initDict()
	{
		digitLetter.put(2, "abc");
		digitLetter.put(3, "def");
		digitLetter.put(4, "ghi");
		digitLetter.put(5, "jkl");
		digitLetter.put(6, "mno");
		digitLetter.put(7, "pqrs");
		digitLetter.put(8, "tuv");
		digitLetter.put(9, "wxyz");
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfaPhoneNumber lcpn = new LetterCombinationsOfaPhoneNumber();
		String digits = "23456789";
		System.out.println(lcpn.letterCombinations(digits));
	}
}
