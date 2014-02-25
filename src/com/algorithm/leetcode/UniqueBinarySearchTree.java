package com.algorithm.leetcode;

/**
 * 1-n���ִ洢�ڶ����������ڵ��У��ж����ֲ�ͬ�Ķ����������ṹ
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *   2     1         2                 3
 * @author xiefei
 *
 */
public class UniqueBinarySearchTree {
	/*
	 * ����˼·��
	 * ѭ��ִ��k=1,...,n
	 * 1,2,3,...,k-1  k  k+1,...,n
	 * �ۼ�nums += numTrees[k-1] * numsTrees[n-k]
	 */
    public int numTrees(int n) {
        if(n == 0 || n == 1)
        	return 1;
        if(n == 2)
        	return 2;
        int nums = 0;
        for(int i = 1; i <= n; i++) {
        	nums += numTrees(i-1)*numTrees(n-i);
        }
        return nums;
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
    	int n = 4;
    	System.out.println(ubst.numTrees(n));
	}
}
