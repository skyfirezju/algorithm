package com.algorithm.leetcode;

/**
 * Implement pow(x, n).
 * @author xiefei
 *
 */
public class Power {
	/*
	 * ����˼·��
	 * x^5 = xa^2 * x^2 * x;
	 * �԰�ݼ���������ʱ�����x
	 * ע�⿼��nΪ�������
	 */
    public double pow(double x, int n) {
    	double result = 1.0;
    	boolean neg = n < 0 ? true : false;
        while(n != 0) {
        	if(n%2 != 0) {
        		result = result*x;
        	} 
        	x = x*x;
        	n = n/2;
        }
        return neg ? (1.0/result) : result;
    }
    public static void main(String[] args) {
    	Power p = new Power();
    	int x = 2;
    	int n = -2;
    	System.out.println(p.pow(x, n));
	}
}
