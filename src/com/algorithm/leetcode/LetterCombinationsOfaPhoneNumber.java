package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * �绰���ֵ���ĸ���
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
	 * ����˼·���ݹ飬������洢��ĸ���ֶ�Ӧ�ֵ�
	 * [����1]��Ҫע��digits=""�����Ϊ[""]������[]
	 * [����2]��ʱ���²����ԭ��������Խ��
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
	 * ˼·2��HashMap<Integer,String>�洢��ĸ���ֶ�Ӧ�ֵ�
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
