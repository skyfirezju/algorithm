package com.algorithm.leetcode;

import java.util.Stack;

/**
 * �ж��ַ��������Ƿ���Ч��ƥ��
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
	 * ����˼·����ջ���洢������'(','[','{'��ջ��
	 * ����')',']','}'���ջ����Ԫ������ƥ��ͳ�ջ�����򷵻�false
	 * ��һ���뷨�ǣ����ֱ�ӷ���true
	 * [ע��һ]û�п���ջ����δƥ���Ԫ�����
	 * [ע���]ȡջ��Ԫ��ǰҪ�ж�ջ�Ƿ�Ϊ��
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
