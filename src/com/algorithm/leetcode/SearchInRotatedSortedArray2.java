package com.algorithm.leetcode;

/**
 * 在已排序旋转的数组里面寻找目标元素，允许重复
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * @author xiefei
 *
 */
public class SearchInRotatedSortedArray2 {
	/*
	 * 解题思路：
	 * 无法分辨有序，有极端情况都是相同的，如1,1,1,1,3,1
	 * 这个时候只能l++不断的右移，最坏情况是O(n)
	 */
    public boolean search(int[] A, int target) {
    	int n = A.length;
    	int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (A[m] == target) return true; //return m in Search in Rotated Array I
            if (A[l] < A[m]) { //left half is sorted
                if (A[l] <= target && target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (A[l] > A[m]) { //right half is sorted
                if (A[m] < target && target <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else l++;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	SearchInRotatedSortedArray2 s = new SearchInRotatedSortedArray2();
    	int A[] = {1,3,1,1,1};
    	int target = 3;
    	System.out.println(s.search(A, target));
	}
}
