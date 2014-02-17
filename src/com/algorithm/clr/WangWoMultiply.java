package com.algorithm.clr;

public class WangWoMultiply {
	static int[] getB(int A[]){
		int n = A.length;
		int B[] = new int[n];
		B[0] = A[0];
		for(int i = 1; i < n-1; i++) {
			B[i] = B[i-1]*A[i];
		}
		B[n-1] = B[n-2];
		int C = A[n-1];
		for(int i = n-2; i >= 1; i--) {
			B[i] = B[i-1]*C;
			C = C*A[i];
		}
		B[0] = C;
		return B;
	}
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5};
		int B[] = getB(A);
		for(int i = 0; i < B.length; i++)
			System.out.println(B[i]);	
	}
}
