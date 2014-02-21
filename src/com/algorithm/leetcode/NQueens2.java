package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * N皇后问题，返回不同的解的个数
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author xiefei
 *
 */
public class NQueens2 {
	int result = 0;
    public int totalNQueens(int n) {
        if(n == 0)return 0;
        int columnForRows[] = new int[n];
        solve(n, 0, columnForRows);
        return result;
    }
    
    public void solve(int n, int step, int columnForRows[]) {
    	if(step == n) {
    		result++;
    	}
    	for(int i = 0; i < n; i++) {
    		boolean flag = true;
    		for(int j = 0; j < step; j++) {
    			if(i == columnForRows[j] || (step-j) == i - columnForRows[j] 
    					|| (j-step) == i - columnForRows[j]) {
    				flag = false;
    				break;
    			}
    		}
    		if(flag) {
    			columnForRows[step] = i;
    			solve(n,step+1,columnForRows);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	NQueens2 nq = new NQueens2();
    	int n = 4;
    	System.out.println(nq.totalNQueens(n));
	}
}
