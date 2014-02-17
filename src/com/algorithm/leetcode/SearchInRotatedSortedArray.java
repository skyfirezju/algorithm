package com.algorithm.leetcode;

/**
 * 在旋转过的已排序数组中查找元素
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author xiefei
 *
 */
public class SearchInRotatedSortedArray {
	/*
	 * 解题思路:
	 * 4,5,6,7,0,1,2 mid=3,A[mid]=7,如果target=5,A[mid]>target,
	 * 考虑A[mid:high]是否递增，A[mid]<=high[注意等号]是的话直接另一半high=mid-1,
	 * 不是递增，如果target>A[high]，那么右边一半可以排除。
	 * 4,5,7,0,1,2,3
	 * 1,,3
	 */
    public int search(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high) {
        	int mid = (low+high)>>1;
        	if(A[mid]>target) {
        		if(A[mid] <= A[high]){
        			high = mid-1;
        		} else if(target>A[high]){
        			high = mid-1;
        		} else {
        			low = mid+1;
        		}
        	} else if(A[mid]<target){
        		if(A[mid] >= A[low]) {
        			low = mid+1;
        		} else if(target<A[low]) {
        			low = mid+1;
        		} else {
        			high = mid-1;
        		}
        	} else {
        		return mid;
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	SearchInRotatedSortedArray sa = new SearchInRotatedSortedArray();
    	int A[] = {1,3};
    	int target = 3;
    	System.out.println(sa.search(A, target));
	}
}
