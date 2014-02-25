package com.algorithm.leetcode;

import java.util.ArrayList;

import com.datastructure.util.Interval;

/**
 * 给定一个没有交叉的间隔的集合，插入一个间隔
 * Given a set of non-overlapping intervals, 
 * insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were 
 * initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as 
 * [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * @author xiefei
 *
 */
public class InsertInterval {
	/*
	 * 解题思路：
	 * 注意intervals长度为0的时候,flag=false标志newInterval是否添加进去
	 * 没有的时候判断，intervals[i]与newInterval是否相交，相交更新intervals[i]，添加intervals[i]，flag=true
	 * newInterval完全在intervals[i]的左边，newInterval和intervals[i]都添加,flag=true
	 * 当flag=true,即newInterval已经添加后，就执行合并操作
	 */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        boolean flag = false;
        for(int i = 0; i < n; i++) {
        	if(flag) {
        		Interval interval = result.get(result.size()-1);
        		if(interval.end < intervals.get(i).start) {
        			result.add(intervals.get(i));
        		} else {
        			int end = Math.max(interval.end, intervals.get(i).end);
        			interval.end = end;
        		}
        	} else {
        		if(intervals.get(i).end >= newInterval.start &&
        				intervals.get(i).start <= newInterval.end) {
    				int end = Math.max(intervals.get(i).end, newInterval.end);
            		int start = Math.min(intervals.get(i).start, newInterval.start);
            		intervals.get(i).end = end;
            		intervals.get(i).start = start;
    				flag = true;
            	} else if(intervals.get(i).start > newInterval.end){
            		result.add(newInterval);
            		flag = true;
            	}
            	result.add(intervals.get(i));
        	}
        }
        if(!flag) {
        	result.add(newInterval);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	InsertInterval ii = new InsertInterval();
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	Interval i1 = new Interval(1,5);
//    	Interval i2 = new Interval(3,5);
//    	Interval i3 = new Interval(6,7);
//    	Interval i4 = new Interval(8,10);
//    	Interval i5 = new Interval(12,16);
    	intervals.add(i1);
//    	intervals.add(i2);
//    	intervals.add(i3);
//    	intervals.add(i4);
//    	intervals.add(i5);
    	Interval newInterval = new Interval(0,0);
    	result = ii.insert(intervals, newInterval);
    	System.out.println(result);
	}
}
