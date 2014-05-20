package com.algorithm.leetcode;

/**
 * ����һ�����飬 prices[i]��ʾ��i��Ĺ�Ʊ��Ǯ������һ�ν��ף�����������������������
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @author xiefei
 *
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2)return 0;
        int maxProfit = 0;
        int minval = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++) {
        	if(minval > prices[i])minval = prices[i];
        	if(maxProfit < prices[i] - minval) {
        		maxProfit = prices[i] - minval;
        	}
        }
        return maxProfit;
    }
    public static void main(String[] args) {
		int prices[] = {7, 9, 8, 5, 10};
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		int result = b.maxProfit(prices);
		System.out.println(result);
	}
}
