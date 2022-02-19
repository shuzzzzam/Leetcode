/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class LongestCommonSubsequence {
	/*
	 * Leetcode 1143
	 * In this problem, we used top-down approach to solve problem dynamatically.
	 * 
	 */
	public int longestCommonSubsequenceTopDownApproach(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < text2.length(); i++) {
        	dp[0][i] = 0;//set the base condition.
        }
        
        for(int i = 0; i < text1.length(); i++) {
        	dp[i][0] = 0;//set the base condition.
        }
        
        for(int i = 1; i <= text1.length(); i++) {
        	for(int j = 1; j <= text2.length(); j++) {
        		/*
        		 * Below is the choice diagram code.if two characters are same, then increment count otherwise have recursive call with 2 sets of strings.
        		 */
        		if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
