package com.algorithm.leetcode;

/**
 * 在二维数组组成的2D网格中搜索单词是否存在
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 *  where "adjacent" cells are those horizontally or vertically neighboring. 
 *  The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * @author xiefei
 *
 */
public class WordSearch {
	/*
	 * 解题思路：
	 * used[i][j]数组记录是否使用过,step记录DFS的步数
	 * x,y记录第一个字符入口位置，上下左右搜索
	 */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0)return false;
        int n = board[0].length;
        int len = word.length();
        //System.out.println(len);
        if(len > m*n)return false;
        boolean used[][] = new boolean[m][n];
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		used[i][j] = false;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == word.charAt(0)) {
        			//System.out.println(i + " " + j);
        			if(search(board, word, used, i, j, 0))
        				return true;
        		}
        	}
        }
		return false;
    }
    
    public boolean search(char[][] board, String word, 
    		boolean used[][], int x, int y, int step) {
    	int m = board.length;
    	int n = board[0].length;
        int len = word.length();
        if(!used[x][y] && board[x][y] == word.charAt(step)) {
        	//System.out.println("step: " + step + ",i: " + x + ",j:" + y);
        	if(step == len -1)return true;
        	used[x][y] = true;
        }else 
        	return false;
        if(y+1<n && search(board, word, used, x, y+1, step+1))return true;
        if(x+1<m && search(board, word, used, x+1, y, step+1))return true;
        if(x-1>=0 &&search(board, word, used, x-1, y, step+1))return true;
        if(y-1>=0 && search(board, word, used, x, y-1, step+1))return true;
        used[x][y] = false;
        return false;
    }
    public static void main(String[] args) {
    	WordSearch ws = new WordSearch();
    	//char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	//String word = "SEE";
    	char board[][] = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
    	String word  = "AAB";
    	System.out.println(ws.exist(board, word));
	}
}
