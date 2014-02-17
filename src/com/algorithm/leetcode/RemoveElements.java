package com.algorithm.leetcode;

/**
 * �Ƴ�������ָ����Ԫ��
 * Given an array and a value, remove all instances of that value in place 
 * and return the new length.
 * The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.
 * @author xiefei
 *
 */
public class RemoveElements {
	/*
	 * ����˼·��length����ǰ���ظ���Ԫ�ظ�����
	 * A[i]==elemʱpass
	 * ����ʱ��A[length=A[i],length++
	 */
	public int removeElement(int[] A, int elem) {
		int n = A.length;
		if(n == 0)return 0;
		int length = 0;
        for(int i = 0; i < n; i++) {
        	if(A[i] == elem)
        		continue;
        	A[length++] = A[i];
        }
        return length;
    }
	public static void main(String[] args) {
		RemoveElements re = new RemoveElements();
    	int A[] = {1,1,1};
    	int result = re.removeElement(A,1);
    	System.out.println(result);
    	for(int i = 0; i < result; i++)
    		System.out.print(A[i] + " ");
	}
}
