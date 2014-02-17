package com.algorithm.leetcode;

/**
 * �ж������Ƿ����
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author xiefei
 *
 */
public class PalindromeNumber {
	/*
	 * ����˼·��������ת�Ƿ��뱾�����
	 * ˼��1��-121�Ƿ�����ģ��������ǻ���
	 * ˼��2��������ת�������OJ��ͨ���ˣ�
	 * ԭ������ת����������ӣ���1000000003�϶����ǻ��ģ�ǡ���ɶ���
	 */
	public boolean isPalindrome(int x) {
        int reverse = 0;
        int original = x;
        if(x < 0)return false;
        while(x > 0) {
        	reverse = reverse*10 + x%10;
        	x = x/10;
        }
        return reverse == original;
    }
	
	/*
	 * ˼·2��ѭ�����αȽ����λ�����λ���֣�������ȣ��Ͳ��ǻ���
	 * ÿ��ȥ�����λ�����λ
	 */
	public boolean isPalindrome1(int x) {
		if(x < 0)
			return false;
		int div = 1;
		//div�Ǹ�λģ,x/div�����λ
		while(x/div >= 10) {
			div = div *10;
		}
		while(x > 0) {
			int high = x/div;
			int low = x%10;
			if(high != low)
				return false;
			x = (x%div)/10;//ȥ����λ�͵�λ����
			div = div/100;//ȥ��2λ
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromeNumber pn = new PalindromeNumber();
		int x = 13100;
		System.out.println(pn.isPalindrome1(x));
	}
}
