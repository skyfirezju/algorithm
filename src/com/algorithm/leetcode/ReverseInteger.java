package com.algorithm.leetcode;

import java.math.BigInteger;

/**
 * ������ת
 * ��Ҫע������⣺
 * 1.�������1��������0����ת���������10,100
 * 2.��ת������ֿ��ܻ��������1000000003����������������׳��쳣����
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author xiefei
 *
 */
public class ReverseInteger {
	/*
	 * ����˼·��������ģ���Ǹ���������ȡģ�õ���λ���֣�
	 * Ȼ��ѭ����ӣ�OJ�Ͽ���ͨ��������û�п������
	 */
	public int reverse(int x) {
        int result = 0;
        while(x != 0) {
        	result = result*10 + x%10;
        	x = x/10;
        }
        return result;
    }
	
	/*
	 * ˼·1�����Ѱ汾������������ð汾�Ǵ���ģ�
	 * ��Ϊint���ͱ��������ܴ洢>Integer.MAX_VALUE
	 */
	public int reverse1(int x) {
        int result = 0;
        boolean neg = x < 0;
        if (neg) x = -x;
        while(x > 0){
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (neg) result = - result;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return result;
    }
	
	/*
	 * ˼·2����long�������ʹ洢,���Դ洢���λ����64�������ε�32λ
	 */
	public int reverse2(int x) {
		long result = 0;
        while(x != 0) {
        	result = result*10 + x%10;
        	x = x/10;
        }
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int)result;
        /*
		long result = 0;
        boolean neg = x < 0;
        if (neg) x = -x;
        while(x > 0){
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (neg) result = - result;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return (int)result;*/
    }
	
	public static void main(String[] args) {
		int x = 0;
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse2(x));
	}

}
