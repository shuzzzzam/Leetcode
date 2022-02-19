/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class LongestPalindromicSubsequence {
	/*
	 * leetcode 516
	 * This question is a variation of longest common subsequence. In this question we have to find LCS for the given string and its reverse.
	 */
	public int longestPalindromeSubseq(String s) {
		String text1 = s;
		String text2 = "";
        for(int i = 0; i < s.length(); i++) {
            text2 = s.charAt(i) + text2;
        }
        
        char[] charText1 = text1.toCharArray();
        char[] charText2 = text2.toCharArray();
        int m = text1.length();
        int n = m;
		int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < n; i++) {
        	dp[0][i] = 0;//set the base condition.
        }
        
        for(int i = 0; i < m; i++) {
        	dp[i][0] = 0;//set the base condition.
        }
        
        for(int i = 1; i <= m; i++) {
        	for(int j = 1; j <= n; j++) {
        		/*
        		 * Below is the choice diagram code.if two characters are same, then increment count otherwise have recursive call with 2 sets of strings.
        		 */
        		if(charText1[i - 1] == charText2[j - 1]) {
        			dp[i][j] = 1 + dp[i - 1][j - 1];
        		}
        		else {
        			dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        		}
        	}
        }
        
        return dp[text1.length()][text2.length()];
    }
}
