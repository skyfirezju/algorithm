package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * ��֤�����Ƿ���Ч���հ׵�Ԫ����'.'
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.
 * @author xiefei
 *
 */
public class ValidSudoku {
	/*
	 * �����С��С��������жϣ�HashMap<Character,Integer>���洢���֣������ظ���
	 * ����ظ�����false����󷵻�true
	 */
    public boolean isValidSudoku(char[][] board) {
    	//row
        for(int i = 0; i < 9; i++) {
        	HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        	for(int j = 0; j < 9; j++) {
        		char cell = board[i][j];
        		if(cell != '.') {
        			if(map.containsKey(cell)){
        				return false;
        			} else {
        				map.put(cell, 1);
        			}
        		}
        	}
        }
        //colomn
        for(int i = 0; i < 9; i++) {
        	HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        	for(int j = 0; j < 9; j++) {
        		char cell = board[j][i];
        		if(cell != '.') {
        			if(map.containsKey(cell)){
        				return false;
        			} else {
        				map.put(cell, 1);
        			}
        		}
        	}
        }
        //region
        for(int startX = 0; startX < 9; startX += 3) {
        	for(int startY = 0; startY < 9; startY += 3){
        		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        		for(int i = 0; i < 3; i++) {
        			for(int j = 0; j < 3; j++) {
        				char cell = board[startX+i][startY+j];
                		if(cell != '.') {
                			if(map.containsKey(cell)){
                				return false;
                			} else {
                				map.put(cell, 1);
                			}
                		}
        			}
        		}
        	}
        }
        return true;
    }
}
