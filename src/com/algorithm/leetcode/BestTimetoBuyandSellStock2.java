package com.algorithm.leetcode;

/**
 * ����һ�����飬 prices[i]��ʾ��i��Ĺ�Ʊ��Ǯ�������ν��ף���������������ͬһʱ�䲻��Ӵ��ν��ף�����������
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times).
 *  However, you may not engage in multiple transactions at the same time 
 *  (ie, you must sell the stock before you buy again).
 * @author xiefei
 *
 */
public class BestTimetoBuyandSellStock2 {
	//��������ɨ�裬��¼����Transaction�����ֵprofit>0,maxProfit+=profit,ͬʱ����minValue
    public int maxProfit(int[] prices) {
    	int length = prices.length;
    	if(length == 0)return 0;
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++) {
        	if(minValue > prices[i])
        		minValue = prices[i];
        	int profit = prices[i] - minValue;
        	if(profit > 0) {
        		maxProfit += profit;
        		minValue = prices[i];
        	}
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
    	BestTimetoBuyandSellStock2 b = new BestTimetoBuyandSellStock2();
    	int prices[] = {7, 9, 8, 5, 10};
    	int result = b.maxProfit(prices);
		System.out.println(result);
	}
}
