package com.algorithm.leetcode;

import java.util.Stack;

/**
 * 判断字符串括号是否有效的匹配
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * @author xiefei
 *
 */
public class ValidParentheses {
	/*
	 * 解题思路：用栈来存储，遇到'(','[','{'入栈，
	 * 遇到')',']','}'如果栈顶与元素括号匹配就出栈，否则返回false
	 * 第一次想法是：最后直接返回true
	 * [注意一]没有考虑栈内有未匹配的元素情况
	 * [注意二]取栈顶元素前要判断栈是否为空
	 */
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
        	switch(s.charAt(i)) {
        	case '(':
        		stack.push('(');
        		break;
        	case '[':
        		stack.push('[');
        		break;
        	case '{':
        		stack.push('{');
        		break;
        	case ')':
        		if(!stack.isEmpty() &&(char)stack.peek() == '('){
        			stack.pop();
        		} else {
        			return false;
        		}
        		break;
        	case ']':
        		if(!stack.isEmpty() &&(char)stack.peek() == '['){
        			stack.pop();
        		} else {
        			return false;
        		}	
        		break;
        	case '}':
        		if(!stack.isEmpty() &&(char)stack.peek() == '{'){
        			stack.pop();
        		} else {
        			return false;
        		}	
        		break;
        	}
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
    	ValidParentheses vp = new ValidParentheses();
    	String s = "]";
    	System.out.println(vp.isValid(s));
	}
}
