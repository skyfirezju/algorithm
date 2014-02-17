package com.algorithm.leetcode;

/**
 * �ַ���ת���������������������룬��������ִ�еķ���0
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 *  please do not see below and ask yourself what are the possible input cases.
 * @author xiefei
 *
 */
public class StringToInteger {
	/*
	 * ����˼·��
	 * ˼·1��  ����ȥ��ǰ��հ��ַ���Ȼ��ɨ�裬��1����ѡ��'+'����'-'
	 * ����������ж�������м���ֲ������ֵ��������-0012a42
	 * ԭ��ֱ�ӷ��أ�-0012a42 ������������ȥ��output��0��expected:-12
	 */
	public int atoi(String str) {
        long result = 0;
        str = str.trim();
        int n = str.length();
        if(n==0)
        	return 0;
        boolean neg = false;
        for(int i = 0; i < n; i++) {
        	if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        		result = 10*result + (str.charAt(i)- '0');
        	} else {
        		if(i == 0) {
        			if(str.charAt(i) == '+')
        				neg = false;
        			else if(str.charAt(i) == '-')
        				neg = true;
        			else
        				//return 0;//ԭ��ֱ�ӷ���
        				break;
        		} else {
        			//return 0;//ԭ��ֱ�ӷ���
        			break;
        		}
        	}
        }
        if(neg)
        	result = -result;
        if(result > Integer.MAX_VALUE)
        	result = Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
        	result = Integer.MIN_VALUE;
        return (int)result;
    }
	
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		String str = "  +";
		int result= sti.atoi(str);
		System.out.println(result);
	}
}
