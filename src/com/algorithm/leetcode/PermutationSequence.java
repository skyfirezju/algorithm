package com.algorithm.leetcode;

/**
 * 1到n数字，字典序进行排列，输出第k个
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * @author xiefei
 *
 */
public class PermutationSequence {
	/*
	 * 解题思路:
	 * 参照全排列的思路递归，OJ超时
	 */
	String result = "";
	int count = 0;
    public String getPermutation(int n, int k) {
    	if(n == 0)return "";
    	String str = "";
    	for(int i = 0; i < n; i++) {
    		str += (char)(i+49);
    	}
    	boolean used[] = new boolean[n];
    	for(int i = 0; i < n; i++) {
    		used[i] = false;
    	}
    	char res[] = new char[n];
    	permutation(str, 0, n, used, res, k);
    	return result;
    }
    
    void permutation(String str, int step, int n, boolean used[], char[] res, int k) {
    	if(step == n) {
    		count++;
    		if(count == k)
    			result = new String(res);
    	}
    	for(int i = 0; i < n; i++) {
    		if(!used[i]) {
    			used[i] = true;
    			res[step] = str.charAt(i);
    			permutation(str, step+1, n, used, res, k);
    			used[i] = false;
    		}
    	}
    }
    
    /*
     * 思路2：用字典序NextPermutation方法
     */
    public String getPermutation1(int n, int k) {
    	int num[] = new int[n];
    	for(int i = 0; i < n; i++) 
    		num[i] = i+1;
    	while(--k > 0) {
    		nextPermutation(num);
    	}
    	String str = "";
    	for(int i = 0; i < n; i++) 
    		str += (char)(num[i] + 48);
    	return str;
    }
    
    public void nextPermutation(int[] num) {
        int n = num.length;
        if(n == 0 || n == 1)
        	return;
        int i;
        for(i = n-2; i >= 0; i--) {
        	if(num[i] < num[i+1])
        		break;
        }
        int firstAsc = i;
        if(firstAsc <0) {
        	for(i = 0; i < n/2; i++) {
        		int temp = num[i];
        		num[i] = num[n-i-1];
        		num[n-i-1] = temp;
        	}
        	return;
        }
        for(i = n-1; i >= firstAsc+1; i--) {
        	if(num[i] > num[firstAsc])
        		break;
        }
        int bfirstAsc = i;
        int temp = num[firstAsc];
        num[firstAsc] = num[bfirstAsc];
        num[bfirstAsc] = temp;
        for(i = firstAsc+1; i < firstAsc+1+(n-firstAsc-1)/2; i++) {		
        	temp = num[i];
        	num[i] = num[firstAsc+n-i];
        	num[firstAsc+n-i] = temp;
        }
    }
    
    public static void main(String[] args) {
    	PermutationSequence ps = new PermutationSequence();
    	int n = 9, k = 199269;
    	System.out.println(ps.getPermutation1(n, k));
	}
}
