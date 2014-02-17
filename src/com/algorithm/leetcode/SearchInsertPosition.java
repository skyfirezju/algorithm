package com.algorithm.leetcode;

/**
 * 排序数组里面寻找元素下标，否则返回插入位置下标，假设元素不重复
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @author xiefei
 *
 */
public class SearchInsertPosition {
	/*
	 * 解题思路：二分查找，插入位置是比low
	 */
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length -1;
        while(low <= high) {
        	int mid = low + (high-low)/2;
        	if(A[mid] < target) {
        		low = mid +1;
        	} else if(A[mid] > target) {
        		high = mid -1;
        	} else {
        		return mid;
        	}
        }
        return low;
    }
}
