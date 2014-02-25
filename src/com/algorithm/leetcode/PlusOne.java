package com.algorithm.leetcode;

/**
 * �Ǹ���������洢����һ
 * Given a non-negative number represented as an array of digits,
 * plus one to the number.
 * The digits are stored such that the most significant 
 * digit is at the head of the list.
 * @author xiefei
 *
 */
public class PlusOne {
	/*
	 * ����˼·:
	 * add��־��λ,add=0,��ĩβ��ǰ��
	 * result[n]���飬����н�λadd=1,���λΪ1������������
	 * ����ֱ�ӷ���
	 */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(n == 0) return null;
        int[] result = new int[n];
        int add = 0;
        for(int i = n - 1; i >= 0; i--) {
        	int num;
        	if(i == n-1) {
        		num = digits[i] + 1 + add;
        	} else {
        		num = digits[i] + add;
        	}
        	add = num >= 10 ? 1 : 0;
    		num = num % 10;
    		result[i] = num;
        }
        if(add != 0) {
        	int res[] = new int[n+1];
        	res[0] = 1;
        	for(int i = 1; i <= n; i++) 
        		res[i] = result[i-1];
        	return res;
        } else {
        	return result;
        }
    }
    public static void main(String[] args) {
    	PlusOne po = new PlusOne();
    	int digits[] = {9};
    	int result[] = po.plusOne(digits);
    	for(int i = 0; i < result.length; i++) 
    		System.out.print(result[i]);
	}
}
