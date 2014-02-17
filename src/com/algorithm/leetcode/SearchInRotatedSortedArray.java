package com.algorithm.leetcode;

/**
 * ����ת���������������в���Ԫ��
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
	 * ����˼·:
	 * 4,5,6,7,0,1,2 mid=3,A[mid]=7,���target=5,A[mid]>target,
	 * ����A[mid:high]�Ƿ������A[mid]<=high[ע��Ⱥ�]�ǵĻ�ֱ����һ��high=mid-1,
	 * ���ǵ��������target>A[high]����ô�ұ�һ������ų���
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
