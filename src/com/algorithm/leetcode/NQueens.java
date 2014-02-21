package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * N�ʺ����⣬�������еĽ�
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
  *  "...Q",
  *  ".Q.."]
 * ]
 * @author xiefei
 *
 */
public class NQueens {
	/*
	 * ����˼·��������
	 * columnForRows[i]�洢i�ж�Ӧ���е��±꣬step�����У�
	 * �ӵ�0�п�ʼ��ֱ��step==n�ݹ��˳���
	 * �������±�i��0��n-1������Ƿ���Ϲ�����ǰ��<step�������ж�Ӧ��λ�������
	 * �������columnForRows[step]=i,����step+1
	 */
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if(n == 0)return result;
        int columnForRows[] = new int[n];
        solve(result, n, 0, columnForRows);
        return result;
    }
    
    public void solve(ArrayList<String[]> result, int n, int step, int columnForRows[]) {
    	if(step == n) {
    		String res[] = new String[n];
    		for(int i = 0; i < n; i++) {
    			String str = "";
    			for(int j = 0; j < n; j++) {
    				if(j != columnForRows[i]) {
    					str += ".";
    				} else {
    					str += "Q";
    				}
    			}
    			res[i] = str;
    		}
    		result.add(res);
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
    			solve(result,n,step+1,columnForRows);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	NQueens nq = new NQueens();
    	int n = 4;
    	ArrayList<String[]> result = nq.solveNQueens(n);
    	//System.out.println(result);
    	for(String[] res : result) {
    		for(int i = 0; i < res.length; i++)
    			System.out.println(res[i]);
    		System.out.println();
    	}
	}
    
}
