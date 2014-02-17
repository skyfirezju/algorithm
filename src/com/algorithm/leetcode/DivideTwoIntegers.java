package com.algorithm.leetcode;

/**
 * 两个整数相除，不用乘、除和取模运算
 * Divide two integers without using multiplication, division and mod operator.
 * @author xiefei
 *
 */
public class DivideTwoIntegers {
	
	/*
	 * 解题思路：
	 * 先算符号
	 * dividend一直减divisor,result++
	 * OJ超时，2147483647, 1
	 */
    public int divide(int dividend, int divisor) {
    	if(dividend == 0)
    		return 0;
        boolean neg1 = dividend < 0;
        if(neg1)
        	dividend = -dividend;
        boolean neg2 = divisor < 0;
        if(neg2)
        	divisor = -divisor;
        boolean neg = neg1^neg2;
        int result = 0;
        while(dividend>=divisor) {
        	dividend -= divisor;
        	result++;
        }
        return neg ? -result:result;
    }	
    
    /*
     * 思路2：用2分的思想，发现对于特例2147483647, 1来说还是O(n)，慢的无法忍受
     */
    public int divide1(int dividend, int divisor) {
    	if(dividend == 0)
    		return 0;
        boolean neg1 = dividend < 0;
        if(neg1)
        	dividend = -dividend;
        boolean neg2 = divisor < 0;
        if(neg2)
        	divisor = -divisor;
        boolean neg = neg1^neg2;
        int left = 0,right = dividend;
        int result = 0;
        while(left<=right){
        	int mid = (left+right)>>1;
        	if(mid*divisor< dividend - divisor){
        		left = mid+1;
        	} else if(mid*divisor>dividend+divisor){
        		right = mid-1;
        	} else {
        		result = mid;
        		break;
        	}
        }
        return neg?-result:result;
    }
    
    /*
     * 思路3： 注意MIN_VALUE=-2147483648
     */
    public int divide2(int dividend, int divisor) {
    	int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (neg) {
                return -1 + divide(dividend + b, b);
            }
            else {
                return 1 - divide(dividend + b, b);
            }
        }
        int result = 0;
        while(a>=b) {
        	int num = b;
        	int shift = 0;
        	while(a - num >= num){
        		num = num <<1;
        		shift++;
        	}
        	a -= num;
        	result += 1<<shift;
        }
        return neg ? -result:result;
    }
    
    public int divide3(int dividend, int divisor) {
    	int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (neg) {
                return -1 + divide(dividend + b, b);
            }
            else {
                return 1 - divide(dividend + b, b);
            }
        }
        int product = b, result = 0;
        while (a >= b) {
            int q = 1;
            while (a - product >= product) {
                q = q << 1;
                product = product << 1;
            }
            a = a - product;
            product = b;
            result += q;
        }
        return (neg) ? -result : result;
    }
    
    public static void main(String[] args) {
    	DivideTwoIntegers dti = new DivideTwoIntegers();
    	int dividend = -2147483648;
    	int divisor = -2147483647;
    	//System.out.println(-divisor);
    	System.out.println(dti.divide2(dividend, divisor));
	}
}
