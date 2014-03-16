package com.algorithm.leetcode;

/**
 * 在S中寻找子序列等于T，求子序列的个数
 * Given a string S and a string T, count the number of 
 * distinct subsequences of T in S.
 * A subsequence of a string is a new string which is 
 * formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * @author xiefei
 *
 */
public class DistinctSubsequence {
	/*
	 * 解题思路：
	 * 设置dp[m+1][n+1] S="rabbbit" m=7 T="rabbit" n = 6
	 * 举例说明 ，当S="rabbb" T="rabb",S[i-1]=T[j-1]时，  dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
	 * 即dp[5][4] = dp[4][4] + dp[4][3] => "rabb" 和 "rabb" ; "rabb" "rab"
	 * 当S[i-1]!=T[j-1],dp[i][j]=dp[i-1][j]
	 */
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        if(m < n)return 0;
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
        	dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
        	dp[0][i] = 0;
        }
        for(int j = 1; j <= n; j++) {
        	for(int i = 1; i <= m; i++) {
            	dp[i][j] = dp[i-1][j] + 
            			(S.charAt(i-1) == T.charAt(j-1) ? dp[i-1][j-1] : 0);
            }
    	}
        return dp[m][n];
    }
    public static void main(String[] args) {
    	DistinctSubsequence ds = new DistinctSubsequence();
    	String S = "rabbbit";
    	String T = "rabbit";
    	System.out.println(ds.numDistinct(S, T));
	}
}
