package com.algorithm.math;
/**
 * 全排列生成算法，递归与非递归（字典序）
 * @author xiefei
 *
 */
public class Permutation {
	/**
	 * 递归生成全排列，
	 * 0到s是已经选择好的元素，s到e是待选择的元素
	 * 现在从s到e中选择一个i与s交换（s本身则还是不变），代表选择了i元素
	 * 剩下递归调用从s+1到e中生成全排列，一直到s>e结束递归
	 * @param list 元素集合
	 * @param s    生成排列的开始位置
	 * @param e    生成排列的结束位置
	 */
	void perm(int list[], int s, int e){	
		if(s > e) {
			for(int i = 0; i < list.length; i++)
			{
				System.out.print(list[i]);
				if(i == list.length - 1)
					System.out.println();
				else
					System.out.print(",");
			}
		}
		for(int i = s; i <= e; i++) 
		{
			swap(list, s, i);
			perm(list, s+1, e);
			swap(list, s, i);
		}
		
	}
	
	void swap(int list[], int a, int b)
	{
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	/**
	 * 下一个字典序:123->132->213->231->312->321
	 * 先从右向左扫描到第一个比右边小的数A，再从右向左扫描到第一个比A大的数B
	 * 交换A和B，然后将A后面的（不包括A）全部逆转
	 * @param a 元素集合
	 * @param n  元素个数
	 * @return
	 */
	boolean nextPerm(int a[], int n)
	{
		int j;
		for(j = n - 1; j >= 1; j--)
		{
			if(a[j-1] < a[j])
				break;
		}
		int start = j - 1;
		//System.out.println("start = " + start);
		if(start < 0) {
			//System.out.println("out");
			return false;
		}
		for(j = n-1 ; j >= start + 1; j--)
		{
			if(a[j] > a[start])
				break;
		}
		int end = j;
		swap(a, start, end);
		reverse(a, start + 1, n -1);
		//System.out.println("end = " + end);
		return true;
	}
	/**
	 * 将数组a[n] 从start到end逆转
	 * @param a      待逆转数组
	 * @param start  逆转起始位置
	 * @param end    逆转结束位置
	 */
	void reverse(int a[], int start, int end)
	{
		while(start < end)
		{
			swap(a, start, end);
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3};
		Permutation per = new Permutation();
		//per.perm(a, 0, a.length - 1);
		do{
			for(int i = 0; i < a.length; i++)
			{
				System.out.print(a[i]);
				if(i == a.length - 1)
					System.out.println();
				else
					System.out.print(",");
			}
		}while(per.nextPerm(a, a.length));
	}
	
}
