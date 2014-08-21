package com.algorithm.basic;

/**
 * øÏÀŸ≈≈–Ú
 * @author xiexiefei
 *
 */
public class QuickSort {
	
	public void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public int partition(int a[], int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true) {
			while(a[++i] < a[lo]) {
				if(i == hi)break;
			}
			while(a[lo] < a[--j]) {
				if(j == lo)break;
			}
			if(i >= j)break;
			swap(a, i, j);
		}
		swap(a , lo, j);
		return j;
	}
	
	public void sort(int a[]){
		sort(a, 0, a.length - 1);
	}
	
	public void sort(int a[], int lo, int hi) {
		if(hi <= lo)return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public static void main(String[] args) {
		int a[] = {10, 2, 8, 5, 3};
		System.out.println("before sort...");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		QuickSort quickSort = new QuickSort();
		quickSort.sort(a);
		System.out.println();
		System.out.println("after sort...");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
}
