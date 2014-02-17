package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * ������
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * @author xiefei
 *
 */
public class SudokuSolver {
	/*
	 * ����˼·�����������ö�٣����ܵ��������ȥ�������ִ����ʱ�������һ����ֱ�����ȫ�����꣬�ҵ�һ����.
	 * �������ڲ�֪����ô����
	 */
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		int x = board[i][j];
        		if(x == '.') {
        			for(int k = 0; k < 9; k++) {
        				char candidate = (char)(48 + k);
        				if(validate(board,candidate,i,j)) {
        					board[i][j] = candidate;
        					continue;
        				}
        			}
        		} else {
        			continue;
        		}
        	}
        }
    }
    
    boolean validate(char[][] board, char cell, int row, int col) {
    	for(int i = 0; i < 9; i++) {
    		if(cell == board[row][i]|| cell == board[i][col])
    			return false;
    	}
    	int startX = row%3;
		int startY = col%3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(cell == board[startX+i][startY+j])
					return false;
			}
		}
    	return true;
    }
    
    /*
     * ˼·2��row��colת��Ϊstep=9*row+col���ݹ�ִ��
     * 
     */
    boolean visited_region[][] = new boolean[20][20];
    boolean visited_row[][] = new boolean[20][20];
    boolean visited_col[][] = new boolean[20][20];
    public void solveSudoku1(char[][] board) {
    	for(int i = 0; i < 20; i++) {
    		for(int j = 0; j < 20; j++) {
    			visited_region[i][j] = false;
    			visited_row[i][j] = false;
    			visited_col[i][j] = false;
    		}
    	}
    	for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++) {
        		if(board[i][j] != '.') {
        			int x = board[i][j] - '0';
            		int region = (i/3)*3 + (j/3);
            		visited_region[region][x] = true;
            		visited_row[i][x]=visited_col[j][x]=true;
        		} 
        	}
    	}
    	solve(board, 0);
    }
    
    boolean solve(char[][] board, int step) {
    	if(step == 81)
    		return true;
    	int row = step/9;
    	int col = step%9;
    	int region = (row/3)*3 + (col/3);
    	
    	if(board[row][col] != '.') {
    		return solve(board, step+1);
    	}
    	for(int i = 1; i <= 9; i++) {
    		if(!visited_region[region][i] && !visited_row[row][i]
    				&& !visited_col[col][i]) {
    			visited_region[region][i] = true;
    			visited_row[row][i] = visited_col[col][i] = true;
    			board[row][col] = (char)(48 + i);
    			boolean flag = solve(board, step+1);
    			if(flag) 
    				return true;
    			board[row][col] = '.';
    			visited_region[region][i] = false;
    			visited_row[row][i] = visited_col[col][i] = false;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		System.out.println((char)(48 + 1));
	}
}
