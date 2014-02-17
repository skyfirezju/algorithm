package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 最长有效括号
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 * @author xiefei
 *
 */
public class LongestValidParentheses {
	/*
	 * 解题思路：用栈保存，扫描s[i]=='('入栈,
	 * 如果s[i]==')',出栈判断'('，cur+=2,如果cur>max更新
	 * 错误在于如"()(()"会得到4，而结果是2，因为中间会断开，思路有问题
	 */
    public int longestValidParentheses(String s) {
    	int n = s.length();
    	if(n==0 || n==1)return 0;
    	Stack<Character> stack = new Stack<Character>();
        int max = 0;
        int cur = 0;
        for(int i = 0; i < n; i++) {
        	if(s.charAt(i) == '(') {
        		stack.push('(');
        	} else if(s.charAt(i) == ')') {
        		if(!stack.isEmpty()) {
            		char top = stack.peek();
            		if(top == '(') {
            			stack.pop();
        				cur += 2;
            			if(cur>max)
        					max = cur;
            		}
            	} else {
            		if(cur>max)
    					max = cur;
            		cur = 0;
            	}
        	}
        }
        return max;
    }
    
    /*
     * 思路2：用数组couples[]存下所有配对的下标,
     * i,j下标代表[i,j]的元素是连续的，判断标准是couples[j]-couples[i]=j-i,
     * 当couples[j]-couples[i]>j-i时，说明[i,j-1]是连续配对元素，couples[j]开始断开，
     * j-i>max更新max=j-i
     * 
     */
    public int longestValidParentheses1(String s) {
    	Stack<Integer> left = new Stack<Integer>();
        ArrayList<Integer> couples = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                left.push(i);
            }
            else if (c == ')'){
                if (!left.isEmpty()){
                    int l = left.pop();
                    couples.add(l);
                    couples.add(i);
                }
            }
        }
        if (couples.size() < 2){
            return 0;
        }
        Collections.sort(couples);
//        for(int i = 0 ; i < couples.size(); i++) {
//        	System.out.print(couples.get(i) + " ");
//        }
//        System.out.println();
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < couples.size()){
            if(couples.get(j) - couples.get(i) > j - i){
                max = (max > (j - i))? max : j-i;
                i = j;
            }
            else{
                j ++;
            }
        }
        max = (max > (j - i))? max : j-i;
        return max;
    }
    
    public static void main(String[] args) {
    	LongestValidParentheses lvp = new LongestValidParentheses();
    	//String s = "()()(()()()()";
    	String s = "()((()()()";
    	System.out.println(lvp.longestValidParentheses1(s));
	}
}
