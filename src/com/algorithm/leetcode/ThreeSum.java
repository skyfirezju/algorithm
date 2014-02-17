package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * n����������������3��Ԫ����Ӻ͵���0���ҵ�����3Ԫ�飬3��Ԫ�طǽ������У�û���ظ���3Ԫ��
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * @author xiefei
 *
 */
public class ThreeSum {
	/*
	 * ����˼·����HashMap<Ineger,Ineger>key=-num[i],value=i,key���ܻ����ظ�����������ȡ��1��
	 * ������ӣ�Ȼ�����ж��Ƿ���map����sum������������3��Ԫ����ӵ����飬���򣬰�������ӵ�Set��ȥ�أ�ת�������
	 * ����HashMapʱ��O(n),ɨ��O(n*n)����������O(3*log(3)).���ʱ�临�Ӷ�O(n*n)
	 * OJ�ϳ�ʱ
	 */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();	
        int n = num.length;
        for(int i = 0; i < n; i++)
        	map.put(-num[i], i);
        for(int i = 0; i < n-1; i++)
        {
        	for(int j = 0; j < n; j++)
        	{
        		int sum = num[i] + num[j];
        		if(map.containsKey(sum)) {
        			int other = map.get(sum);
        			if(other != i && other != j) {
        				ArrayList<Integer> triplet = new ArrayList<Integer>();
        				triplet.add(num[i]);
        				triplet.add(num[j]);
        				triplet.add(num[other]);
        				Collections.sort(triplet);
        				set.add(triplet);
        			}
        		}
        	}
        }
        for(ArrayList<Integer> tuple : set)
        {
        	result.add(tuple);
        }
        return result;
    }
    
    /*
     * ˼·2��
     * ������������
     * ����ǰ��first,lastָ��,first=i+1,���sum<0,first++,sum>0,last--
     * ʱ�临�Ӷ�O(n*n)
     * ����setȥ�أ�OJ��ʱ
     */
    public ArrayList<ArrayList<Integer>> threeSum1(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        int n = num.length;
        Arrays.sort(num);
        for(int i = 0; i < n; i++){
        	int first = i+1;
            int last = n-1;
            while(first<last){
            	int sum = num[i] + num[first];
            	if(sum + num[last] < 0) {
            		first++;
            	} else if(sum + num[last] > 0) {
            		last--;
            	} else {
            		ArrayList<Integer> triplet = new ArrayList<Integer>();
            		triplet.add(num[i]);
            		triplet.add(num[first]);
            		triplet.add(num[last]);
            		set.add(triplet);
            		first++;
            		last--;
            	}
            }
        }
        for(ArrayList<Integer> tuple : set)
        {
        	result.add(tuple);
        }
        return result;
    }
    
    /*
     * ˼·3��
     * ��������ȵ�Ԫ�ػ����ڣ�ָ���ƶ���ʱ�򣬹����Ա���ȵ�Ԫ����ȥ��
     */
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int n = num.length;
    	if(n < 3)
    		return result;
        Arrays.sort(num);
        for(int i = 0; i < n;i++){
        	int first = i+1;
            int last = n-1;
            while(first<last){
            	int sum = num[i] + num[first];
            	if(sum + num[last] < 0) {
            		first++;
            	} else if(sum + num[last] > 0) {
            		last--;
            	} else {
            		ArrayList<Integer> triplet = new ArrayList<Integer>();
            		triplet.add(num[i]);
            		triplet.add(num[first]);
            		triplet.add(num[last]);
            		result.add(triplet);
            		while(first+1 < last && num[first+1] == num[first])
            			first++;
            		first++;
            		while(last -1 > first && num[last-1] == num[last])
            			last--;
            		last--;
            	}
            }
            while(i+1<n &&num[i+1]==num[i])
            	i++;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	ThreeSum ts = new ThreeSum();
    	int num[] = {-1,0,1,2,-1,4};
    	ArrayList<ArrayList<Integer>> result = ts.threeSum2(num);
    	for(int i = 0; i < result.size(); i++)
    	{
    		ArrayList<Integer> tuple = result.get(i);
    		System.out.println(tuple);
    	}
	}
}
