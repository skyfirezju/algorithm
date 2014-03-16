package com.algorithm.leetcode;

/**
 * �����������ʵı༭���룬����3�в�����ʽ�����룬ɾ�������滻
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author xiefei
 *
 */
public class EditDistance {
	/*
	 * ����˼·��
	 * �ʼ���뷨�ǣ�ֱ���滻������2���ַ��������Ӧλ����ȫ��ͬ�ģ�ʣ�µĽ����滻
	 * [����]�� "sea" "eat" => 2
	 * �Ľ�Ѱ��������Ӵ�����same,�����ɾ��len1-same + ���len2 -same
	 * [����]"sea" "ate" => 3
	 */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0)return len2;
        if(len2 == 0)return len1;
        int sameCount = 0;
        String word = word1 + word2;
        String suffix[] = new String[word.length()];
        for(int i = 0; i < word.length(); i++) {
        	suffix[i] = word.substring(i);
        }
        for(int i = 0; i < word.length(); i++) {
        	for(int j = i + 1; j < word.length(); j++) {
        		int same = 0;
        		for(; same < suffix[i].length() && same < suffix[j].length(); same++) 
        			if(suffix[i].charAt(same) != suffix[j].charAt(same))break;
        		if(same > sameCount)sameCount = same;
        	}
        }
        if(sameCount == 0)return Math.max(len1, len2);
        return len1 + len2 - 2*sameCount;
    }
    
    /*
     * ˼·2��
     * dp[i][j]����word1����Ϊi,word2����Ϊj�ı༭����
     * ��word[i-1]==word[j-1]ʱ��dp[i][j]=dp[i-1][j-1]
     * ����,dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
     * �����ֱ��Ӧ�����Ӻ��滻
     */
    public int minDistance1(String word1, String word2) {
    	int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++)
        	dp[i][0] = i;
        for(int i = 0; i <= len2; i++)
        	dp[0][i] = i;
        for(int i = 1; i <= len1; i++) {
        	for(int j = 1; j <= len2; j++) {
        		if(word1.charAt(i-1) == word2.charAt(j-1)) {
        			dp[i][j] = dp[i-1][j-1];
        		} else {
        			int min = Math.min(dp[i-1][j], dp[i][j-1]);
        			dp[i][j] = Math.min(min, dp[i-1][j-1])+1;
        		}
        		//System.out.print(dp[i][j] + " ");
        	}
        	//System.out.println();
        }
        return dp[len1][len2];
    }
    
    public static void main(String[] args) {
    	EditDistance ed = new EditDistance();
    	String word1 = "sea";
    	String word2 = "ate";
    	System.out.println(ed.minDistance1(word1, word2));
	}
}
