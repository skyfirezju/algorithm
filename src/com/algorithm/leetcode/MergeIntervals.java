package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.datastructure.util.Interval;

/**
 * 给定n个间隔，合并所有重复的间隔
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author xiefei
 *
 */
public class MergeIntervals {
	/*
	 * 解题思路：
	 * 先排序，start第一顺序，end第二顺序
	 * 然后循环遍历，result为空直接添加
	 * 否则取最后1个元素interval，根据interval.end<intervals[i].start判断是否相交，
	 * 相交更新interval.end,不相交直接add
	 */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        if(n == 0|| n == 1)
        	return intervals;
        InterCompartor comparator = new InterCompartor();
        Collections.sort(intervals, comparator);
        for(int i = 0; i < intervals.size(); i++) {
        	if(result.size() == 0) {
        		result.add(intervals.get(i));
        	} else {
        		Interval interval = result.get(result.size()-1);
        		if(interval.end < intervals.get(i).start) {
        			result.add(intervals.get(i));
        		} else {
        			int end = Math.max(interval.end, intervals.get(i).end);
        			interval.end = end;
        		}
        	}
        }
        return result;
    }
    class InterCompartor implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start < o2.start) {
				return -1;
			} else if(o1.start > o2.start) {
				return 1;
			} else {
				return o1.end - o2.end;
			}
		}
    	
    };
    
    public static void main(String[] args) {
    	MergeIntervals mi = new MergeIntervals();
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	Interval i1 = new Interval(2,4);
    	Interval i2 = new Interval(7,8);
    	Interval i3 = new Interval(3,10);
    	Interval i4 = new Interval(1,12);
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	intervals.add(i4);
    	result = mi.merge(intervals);
    	System.out.println(result);
	}
}
