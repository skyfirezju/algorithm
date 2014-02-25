package com.datastructure.util;

public class Interval {
	public int start;
	public int end;
	public Interval(){};
	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
	@Override
	public String toString(){
		return "[" + start + "," + end +  "]";
	}
}
