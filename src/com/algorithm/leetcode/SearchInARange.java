package com.algorithm.leetcode;

/**
 * ������������Ѱ��Ԫ�ص���ʼ����ֹ�±�
 * Given a sorted array of integers, 
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * @author xiefei
 *
 */
public class SearchInARange {
	/*
	 * ����˼·�����ֲ��ң��ҵ�target�����ұ��������ұ߽磬
	 * �����������target������ȣ�O(n)
	 */
    public int[] searchRange(int[] A, int target) {
        int result[] = {-1,-1};
        int low = 0, high = A.length -1;
        while(low <= high) {
        	int mid = (low+high)>>1;
	        if(A[mid]<target){
	        	low = mid+1;
	        } else if(A[mid]>target){
	        	high = mid-1;
	        } else {
	        	int start = mid, end = mid;
	        	while(start >= low && A[start] == A[mid]) 
	        		start--;
	        	while(end <= high && A[end] == A[mid])
	        		end++;
	        	result[0] = start+1;
	        	result[1] = end-1;
	        	break;
	        }
        }
        return result;
    }
    
    /*
     * ˼·2��������ߵ�target��start=0 A[mid]<targetʱ,start=mid+1,
     * A[mid]>=targetʱ��end=mid-1.����ж�A[start]==target,ע��start������Խ�磬
     * �Ƿ���start������-1
     * �����ұߵ�targetͬ��
     */
    public int[] searchRange1(int[] A, int target) {
    	int result[] = {-1,-1};
    	int n = A.length;
    	result[0] = findL(A,target);
    	result[1] = findR(A,target);
        return result;
    }
    
    int findL(int A[], int target) {
    	int n = A.length;
    	int start = 0, end = n-1;
    	while(start<=end){
    		int mid = start + (end-start)/2;
    		if(A[mid]>=target) {
    			end = mid-1;
    		} else {
    			start = mid+1;
    		}
    	}
    	if(start < n && A[start] == target)
    		return start;
    	return -1;
    }
    
    int findR(int A[], int target) {
    	int n = A.length;
    	int start = 0, end = n-1;
    	while(start<=end){
    		int mid = start + (end-start)/2;
    		if(A[mid]<=target) {
    			start = mid+1;
    		} else {
    			end = mid-1;
    		}
    	}
    	if(end >=0 && A[end]==target)
    		return end;
    	return -1;
    }
    
    public static void main(String[] args) {
    	SearchInARange sa = new SearchInARange();
    	int A[] =  {7};
    	int target = 0;
    	//System.out.println(sa.findL(A,0,4,7));
    	int result[] = sa.searchRange1(A, target);
    	System.out.println(result[0] + " " + result[1]);
	}
}
