package com.algorithm.leetcode;

/**
 * 给定一个数组， prices[i]表示第i天的股票价钱，允许多次交易（买入卖出），但同一时间不能哟多次交易，求最大的利润
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
	//从左往右扫描，记录单次Transaction的最大值profit>0,maxProfit+=profit,同时更新minValue
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
