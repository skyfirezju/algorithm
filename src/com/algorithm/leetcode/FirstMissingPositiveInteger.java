package com.algorithm.leetcode;

/**
 * δ������������ҵ�һ��ȱʧ����������ʱ�临�Ӷ�Ҫ��O(n),�ռ临�Ӷ�O(1)
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author xiefei
 *
 */
public class FirstMissingPositiveInteger {
	/*
	 * ����˼·��ʱ��O(n),�ռ�O(n)
	 * n��Ԫ�ص����飬result���Ҳ��n+1�����ʱ��������1,2,...,n��
	 * ��������һ������hash[n]�洢����i��Ԫ���Ƿ���A�����д���
	 * Ȼ��ɨ���ҵ���һ�������ڵ�Ԫ�ص��±�
	 */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if(n==0)
        	return 1;
        int hash[] = new int[n];
        for(int i = 0; i < n; i++)
        	hash[i] = 0;
        for(int i = 0; i < n; i++) {
        	if(A[i] >= 1 && A[i] <= n) {
        		hash[A[i]-1] = 1;
        	}
        }
        int i;
        for(i = 0; i < n; i++) {
        	if(hash[i] == 0) 
        		break;
        }
        return i+1;
    }
    
    /*
     * ����˼·��
     * count�ǲ�����[1,n]��Ԫ�ظ���
     * n+1-count
     */
    public int firstMissingPositive1(int[] A) {
    	int n = A.length;
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		if(!(A[i] >=1 && A[i] <= n))
    			count++;
    	}
    	return n+1-count;
    }
    
    /*
     * ˼·2���ƶ�Ԫ�أ�ʹ��A[i]=i+1�����ɨ��A[i]��=i+1
     */
    public int firstMissingPositive2(int[] A) {
    	int n = A.length;
    	if(n==0)
    		return 1;
    	for(int i = 0; i < n; i++) {
    		while(A[i]>=1 && A[i]<=n && A[i]!=i+1 && A[A[i]-1] != A[i]) {
    			int temp = A[i];
    			A[i] = A[temp-1];
    			A[temp-1] = temp;
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		if(A[i] != i+1)
    			return i+1;
    	}
    	return n+1;
    }
    
    public static void main(String[] args) {
    	FirstMissingPositiveInteger fmpi = new FirstMissingPositiveInteger();
    	int A[] = {3,4,-1,1};
    	System.out.println(fmpi.firstMissingPositive2(A));
	}
}
