package com.algorithm.leetcode;

/**
 * 字典序的下一个排列
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @author xiefei
 *
 */
public class NextPermutation {
	/*
	 * 解题思路：
	 * 错误1：从右往左，找到第一个比右边大的元素，firstAsc，然后把firstAsc+1与n-1交换，
	 * 再firstAsc与firstAsc+1交换，错误例子：231-》123，其实正确的应该是312
	 * 更正后：想到从后面找第一个比firstAsc大的元素k,与firstAsc交换，然后在把剩下的按小到大排序。
	 * 其实交换后，剩下的元素一定是由大到小排列，只需要倒转下剩下的元素。
	 */
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
    
    /*
     * 思路2：规范化代码
     */
    public void nextPermutation1(int[] num) {
    	int n = num.length;
    	if(n==0||n==1)return;
    	for(int i = n-1; i >= 1; i--) {
    		if(num[i]>num[i-1]) {
    			for(int j = n-1; j >= i; j--) {
    				if(num[j] > num[i-1]){
    					swap(num, i-1, j);
    					break;
    				}
    			}
    			swapRange(num,i,n-1);
    			return;
    		}
    	}
    	swapRange(num,0,n-1);
    }
    
    public void swapRange(int[] num, int start, int end) {
    	for(int i = start, j = end; i < j; i++,j--) {
    		swap(num, i, j);
    	}
    }
    
    public void swap(int[] num, int i, int j) {
    	if(num[i] == num[j])return;
    	num[i] = num[i]^num[j];
    	num[j] = num[i]^num[j];
    	num[i] = num[i]^num[j];
    }
    
    public static void main(String[] args) {
    	NextPermutation np = new NextPermutation();
    	int num[] = {1,2,3,4,5};
    	for(int i = 0; i < num.length; i++)
    		System.out.print(num[i] + " ");
    	System.out.println();
    	np.nextPermutation1(num);
    	for(int i = 0; i < num.length; i++)
    		System.out.print(num[i] + " ");
	}
}
