package com.algorithm.leetcode;

/**
 * 数组红白蓝,分别用数字0,1,2存储，按红白蓝顺序排序
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color 
 * red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * @author xiefei
 *
 */
public class SortColors {
	/*
	 * 解题思路：
	 * red标志red左边的都是0，blue右边的都是2
	 * 从左往有扫描，再加些判断进行交换
	 */
    public void sortColors(int[] A) {
    	int n = A.length;
    	if(n == 0)return;
        int red = 0, blue = n-1;
        int i = 0;
        while(i < n) {
        	int temp = -1;
        	if(A[i] == 0 && i >= red) {
        		temp = A[red];
        		A[red] = A[i];
        		A[i] = temp;
        		red++;
        	} else if(A[i] == 2 && i <= blue) {
        		temp = A[blue];
        		A[blue] = A[i];
        		A[i] = temp;
        		blue--;
        	} else {
        		i++;
        	}
        }
    }
    public static void main(String[] args) {
		int A[] = {1,2,0,1,1,0,2};
		SortColors sc = new SortColors();
		sc.sortColors(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
