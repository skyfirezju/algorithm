package com.algorithm.leetcode;

/**
 * ʵ�ֿ�����
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author xiefei
 *
 */
public class Sqrt {
	/*
	 * ����˼·��
	 * ���ֲ��ң���������e=0.0000001��Ϊ�˳�����
	 * sqrt(1)=0.999����������=��1
	 * ����sqrt(3)=1.732 =>2��OJ�д�Ӧ��Ϊ1
	 */
    public int sqrt(int x) {
    	double lo = 0;
        double hi = x;
        double e = 0.000001;
        while(true) {
        	double mid = (lo + hi)/2.0;
        	if(Math.abs(mid*mid -x) <= e) {
        		return (int)Math.round(mid);
        	} else if(mid*mid - x > e) {
        		hi = mid;
        	} else {
        		lo = mid;
        	}
        }
    }
    
    /*
     * ����˼·��
     * ֱ�Ӷ��֣�return hi
     * ע��mid*mid�ᳬ�����η�Χ����long�洢
     */
    public int sqrt1(int x) {
    	long lo = 0;
    	long hi = x;
    	while(lo <= hi) {
    		long mid = (lo + hi) >> 1;
    		long sq = mid*mid;
    		if(sq == (long)x) {
    			return (int)mid;
    		} else if(sq < (long)x) {
    			lo = mid + 1;
    		} else {
    			hi = mid - 1;
    		}
    	}
    	return (int)hi;
    }
    
    public static void main(String[] args) {
    	Sqrt s = new Sqrt();
    	int x = 2147395599;
    	System.out.println(s.sqrt1(x));
	}
}
