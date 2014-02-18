package com.algorithm.leetcode;
/**
 * 最长无重复字母子串
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author xiefei
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	/*
	 * 解题思路：curCount计数，下标current扫描，start到end是不重复的子串，初始时start=end=0,maxCount=1。注意s为空串。
	 * 如果s[current]与s[start:end]不重复，end=current,curCount++,如果curCount>maxCount,更新maxCount。
	 * 如果s[current]与s[start:end]重复,假设s[i]=s[current],说明s[i]及之前的都可以排除，因为长度肯定小于maxCount。
	 * 可以保证i+1到current是不重复的，所以curCount=current-(i+1)+1
	 */
	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if(length == 0)
			return 0;
		int start = 0, end = 0, current = 1;
		int curCount = 1, maxCount = 1;
		while(current <= length - 1) {
			int i;
			for(i = start; i <= end; ++i) {
				if(s.charAt(i) == s.charAt(current))
					break;
			}
			if(i <= end) {
				start = i+1;
				curCount = current - i;
			} else {
				curCount++;
				if(curCount > maxCount)
					maxCount = curCount;
			}
			end = current;
			current++;
		}
		return maxCount;
    }
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		int len = lswrc.lengthOfLongestSubstring(s);
		System.out.println(len);
	}
}
