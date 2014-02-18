package com.algorithm.math;

import java.util.ArrayList;

/**
 * 组合生成算法：递归与非递归（01置换法）
 * @author xiefei
 *
 */
public class Combination {
	/**
	 * 从n个元素里面选择k个，
	 * 从集合里面最后面选出a[n-1],放进待选集合的最后面b[k-1]
	 * 剩下从n-1个元素里面取k-1个，是同样问题，递归调用
	 * 最后只剩下1个元素取1个的时候打印退出
	 * @param a 总共元素集合
	 * @param b 选择集合
	 * @param n 总共元素个数
	 * @param k 选择个数
	 */
	void combine(int a[], int b[], int n, int k)
	{
		for(int i = n; i >= k; i--)
		{
			b[k-1] = a[i-1];
			if(k > 1) {
				combine(a, b, i - 1, k - 1);
			} else {
				for(int j = 0; j < b.length; j++)
				{
					System.out.print(b[j]);
					if(j == b.length - 1)
						System.out.println();
					else
						System.out.print(",");
				}
			}
		}
		
	}
	/**
	 * 01交换法生成n个元素里选k个的组合，设置标志数组1代表选择0代表不选择，初始11...100...0其中k个1
	 * 从左到有扫描遇到第一个10，然后将它变为01，然后将10前面的1全部移到左边，重复直到没有10出现
	 * @param a 全部元素
	 * @param b 组合元素
	 * @param n 全部元素的个数
	 * @param k 组合元素的个数
	 */
	void combineNoRecursion(int a[], int b[], int n, int k)
	{
		//ArrayList<Integer> vec = new ArrayList();
		int vec[] = new int[n];
		int i, j;
		for(i = 0; i < n; i++)
		{
			if(i < k) 
				vec[i] = 1;
			else
				vec[i] = 0;
		}
		boolean hasNext = true;
		while(hasNext)
		{
			j = 0;
			for(i = 0; i < n; i++)
			{
				if(vec[i] != 0)
				{
					b[j++] = a[i];
				}
			}
			for(i =0 ; i < b.length; i++)
			{
				System.out.print(b[i]);
				if(i == b.length - 1)
					System.out.println();
				else
					System.out.print(",");
			}
			hasNext = false;
			for(i = 0; i < n - 1; i++)
			{
				if(vec[i] == 1 && vec[i+1] == 0)
				{
					vec[i] = 0;
					vec[i+1] = 1;
					int count = 0;
					for(j = 0; j < i; j++)
					{
						if(vec[j] == 1)
							count++;
					}
					for(j = 0; j < count; j++)
						vec[j] = 1;
					for(j = count; j < i; j++)
						vec[j] = 0;
					hasNext = true;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Combination com = new Combination();
		int a[] = {1, 2, 3, 4, 5};
		int b[] = new int[3];
		com.combine(a, b, 5, 3);
		//com.combineNoRecursion(a, b, 5, 3);
	}
}
