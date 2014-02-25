package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 实现word的英文排版自动对齐功能，每行固定L个单词。
 * 单词和单词间的空隙尽量均匀，左边的要大于右边的
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * @author xiefei
 *
 */
public class TextJustification {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.isEmpty();
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(1);
		q.poll();
	}
}
