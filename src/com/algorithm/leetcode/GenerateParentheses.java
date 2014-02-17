package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * ������Ч���ŵ��������
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author xiefei
 *
 */
public class GenerateParentheses {
	/*
	 * ����˼·��ֻ�뵽���ݣ����ߵݹ飬�����벻������ⷨ
	 */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }
    
    /*
     * ˼·1���ݹ飬left=0�������е�'(',right=0�������е�')'
     * left+right�պ��ǵ�ǰԪ�ص��±꣬left=right=n�ݹ����
     * left<n����paren[left+right]='('����right<left,paren[left+right]=')'�ݹ�ִ��
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
    		//paren += "(";�����ֵ��ı�paren��ɴ���
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
