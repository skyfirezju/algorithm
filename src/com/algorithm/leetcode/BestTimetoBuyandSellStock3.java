package com.algorithm.leetcode;

/**
 * ����һ�����飬 prices[i]��ʾ��i��Ĺ�Ʊ��Ǯ���������2�ν��ף�����������������������
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * @author xiefei
 *
 */
public class BestTimetoBuyandSellStock3 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0)
        	return 0;
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        int dp[] = new int[length];
        int rdp[] = new int[length];
        for(int i = 0; i < length; i++) {
        	if(prices[i] < minValue) 
        		minValue = prices[i];
        	if(maxProfit < prices[i] - minValue)
        		maxProfit = prices[i] - minValue;
        	dp[i] = maxProfit;
        }
        int maxValue = 0;
        maxProfit = 0;
        for(int i = length -1; i >= 0; i--) {
        	if(prices[i] > maxValue) {
        		maxValue = prices[i];
        	}
        	if(maxProfit < maxValue - prices[i]) {
        		maxProfit = maxValue - prices[i];
        	}
        	rdp[i] = maxProfit;
        }
        int result = 0;
        for(int i = 0; i < length; i++) {
        	if(result < dp[i] + rdp[i])
        		result = dp[i] + rdp[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
		int prices[] = {7, 9, 8, 5, 10};
		BestTimetoBuyandSellStock3 b = new BestTimetoBuyandSellStock3();
		int result = b.maxProfit(prices);
		System.out.println(result);
	}
}
