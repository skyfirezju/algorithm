package com.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 简化路径
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * @author xiefei
 *
 */
public class SimplyPath {
	/*
	 * 解题思路:
	 *  '/..' => '/'
	 *  '/../c' => '/c'
	 *  不需要考虑前面的'..'计数
	 */
    public String simplifyPath(String path) {
        ArrayList<String> pathList = new ArrayList<String>();
        String result = "";
        String[] paths = path.split("/");
        for(int i = 0; i < paths.length; i++) {
        	if(paths[i].equals("..")) {
        		if(pathList.size() > 0){
        			pathList.remove(pathList.size()-1);
        		} 
        	} else if(!(paths[i].equals(".") || paths[i].equals(""))) {
        		pathList.add(paths[i]);
        	}
        }
        for(int i = 0; i < pathList.size(); i++) {
        	result = result +  "/" + pathList.get(i);
        }
        if(result.equals(""))return "/";
        return result;
    }
    public static void main(String[] args) {
    	SimplyPath sp = new SimplyPath();
    	String path = "/a/./b/../../c/";
    	System.out.println(sp.simplifyPath(path));
	}
}
