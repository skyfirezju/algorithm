package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 生成有效括号的所有组合
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author xiefei
 *
 */
public class GenerateParentheses {
	/*
	 * 解题思路：只想到回溯，或者递归，但是想不到具体解法
	 */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }
    
    /*
     * 思路1：递归，left=0代表已有的'(',right=0代表已有的')'
     * left+right刚好是当前元素的下标，left=right=n递归结束
     * left<n可以paren[left+right]='('，当right<left,paren[left+right]=')'递归执行
     */
    public ArrayList<String> generateParenthesis1(int n) {
    	ArrayList<String> result = new ArrayList<String>();
    	//char[] paren = new char[2*n];
    	String paren = "";
    	gp(result,0,0,n,paren);
        return result;
    }
    public void gp(ArrayList<String> result,int left, int right, int n, String paren) {
    	if(left == right && left == n) {
    		result.add(new String(paren));
    		return;
    	}
    	if(left < n){
    		//paren[left+right]= '(';
    		//paren += "(";加完后赋值会改变paren造成错误
    		gp(result,left+1, right, n, paren+"(");
    	}
    	if(right < left) {
    		//paren[left+right]=')';
    		//paren += ")";
    		gp(result,left, right+1, n, paren+")");
    	}
    }
    
    public static void main(String[] args) {
    	GenerateParentheses gp = new GenerateParentheses();
    	ArrayList<String> result = gp.generateParenthesis1(3);
    	System.out.println(result);
	}
}
