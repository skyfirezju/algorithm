package com.algorithm.leetcode;
/**
 * 找两个已排序的数组的中位数
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author xiefei
 *
 */
public class MedianOfTwoSortedArrays {
	/**
	 * 解题思路：
	 * 思路1：A和B合并排序，直接找中位数，时间复杂度O((m+n)log(m+n))
	 * 
	 * 思路2：类似归并排序的思想，2个指针pA,pB分布指向数组A，B的第1个元素，count计数，如果pA小，pA++，count++,
	 * 如果pB小，pB++,count++。当count=(m+n)/2时，即中位数,时间复杂度为O(m+n)
	 * 
	 * 思路3：m+n为奇数的时候，中位数是(m+n)/2，偶数的时候，中位数是(m+n)/2-1和(m+n)/2的均值。
	 * 在A中二分查找第(m+n)/2小的元素median，二分的方法是设置2个下标，A中i下标遍历，B中j下标遍历，
	 * 且初始时i=(start+end)/2,j=mid-i。关键是A的下标元素与B中第mid-i小元素比较。A[i]如果比B[j]更大，
	 * 选择前半个分支（end=i-1），如果比B[j-1]还更小，选择后半个分支(start=i+1)，如果B[j-1]<=A[i]<=B[j]，
	 * 找到median退出。如果没找到，在B中找。最坏情况时间复杂度是O(logm+logn)=o(log(m*n))
	 * 
	 * 思路4：寻找中位数，即找第(m+n)/2小的元素，转化为求第K小问题.
	 * 假设数组A元素个数大于k/2(如果小于取更小值)，比较A[k/2-1]和B[k/2-1]。
	 * 如果A[k/2-1]<B[k/2-1],A[0]到A[k/2-1]都是比第k小值还要小，所以抛弃，下标startA=startA+pa，递归寻找第k-pa小的值；
	 * 如果A[k/2-1]>B[k/2-1],把B[0]到B[k/2-1]抛弃，下标startB=startB+pb,递归寻找第k-pb小的值。
	 * 如果A[k/2-1]=B[k/2-1]，A[k/2-1]是第k小的值.
	 * 边界情况，A、B为空，直接返回A[startA+k-1]或B[startB+k-1]。
	 * k=1返回A[startA]或B[startB]中的最小值
	 * A[k/2-1]=B[k/2-1]返回其中一个
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int m = A.length;
       int n = B.length;
       int total = m + n;
       if(total % 2 != 0) {
    	   return findKth(A, 0, B, 0, total/2 + 1); 
       } else {
    	   return (findKth(A, 0, B, 0, total/2) + 
    			   findKth(A, 0, B, 0, total/2 + 1)) / 2; 
       }
    }
	
	public double findKth(int A[], int startA, int B[], int startB, int k) {
		int m = A.length - startA;
		int n = B.length - startB;
		if(m > n) {
			return findKth(B, startB, A, startA, k);
		}
		if(m == 0) {
			return B[startB + k-1];
		}
		if(k == 1) {
			return Math.min(A[startA], B[startB]);
		}
		int pa = Math.min(k/2, m);
		int pb = k - pa;
		if(A[startA + pa -1] < B[startB + pb - 1]) {
			return findKth(A, startA + pa, B, startB, k-pa);
		} else if(A[startA + pa -1] > B[startB + pb - 1]) {
			return findKth(A, startA, B, startB + pb, k-pb);
		} else {
			return A[startA + pa -1];
		}
	}
}
