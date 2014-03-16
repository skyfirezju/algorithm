package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author xiefei
 *
 */
public class RestoreIPAddress {
	/*
	 * 解题思路：
	 * 递归搜索，1个，2个，3个依次列举
	 * 注意010010 =>0.1.0.010
	 */
    public ArrayList<String> restoreIpAddresses(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<String>();
        if(n > 12 || s.equals(""))
        	return result;
        ArrayList<String> ipList = new ArrayList<String>();
        search(0, result, s, 0, ipList);
        return result;
    }
    
    public void search(int step, ArrayList<String> result, String s, int from, ArrayList<String> ipList) {
    	if(step == 4) {
    		String res = "";
    		for(int i = 0; i < ipList.size(); i++) {
    			if(i != ipList.size() - 1)
    				res += (ipList.get(i) + ".");
    			else
    				res += ipList.get(i);
    		}
    		result.add(res);
    	}
    	if(step == 3) {
    		if(from >= s.length())return;
    		Integer i = Integer.parseInt(s.substring(from, s.length()));
    		if(from + 1 == s.length() || (from + 2 == s.length() && s.charAt(from) != '0')
    				|| (from + 3 == s.length() && s.charAt(from) != '0' && i <= 255)) {
    			ipList.add(s.substring(from, s.length()));
    			search(step+1, result, s, s.length(), ipList);
    			ipList.remove(ipList.size()-1);
    		} else {
    			return;
    		}
    	} else {
    		if(from < s.length()) {
    			ipList.add(s.substring(from, from + 1));
				search(step+1, result, s, from+1, ipList);
				ipList.remove(ipList.size()-1);
    			if(from + 2 <= s.length() && s.charAt(from) != '0') {
    				ipList.add(s.substring(from, from + 2));
    				search(step+1, result, s, from+2, ipList);
    				ipList.remove(ipList.size()-1);
    			}
    			if(from + 3 <= s.length() && s.charAt(from) != '0') {
    				Integer i3 = Integer.parseInt(s.substring(from, from+3));
            		if(i3 <= 255) {
            			ipList.add(s.substring(from, from + 3));
        				search(step+1, result, s, from+3, ipList);
        				ipList.remove(ipList.size()-1);
            		}
    			}
    		} else {
    			return;
    		}
    	}
    }
    public static void main(String[] args) {
    	RestoreIPAddress r = new RestoreIPAddress();
    	String s = "010010";
    	ArrayList<String> result = r.restoreIpAddresses(s);
    	System.out.println(result); 
	}
}
