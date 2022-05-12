/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class CountSortedVowelStrings {
	/*
	 * Leetcode 1641
	 * In this problem, we used Top-down approach to solve the DP problem.
	 */
	public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];//Top down approach.
        for(int i = 0; i < 5; i++) {
        	dp[0][i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
        	int sum = 1;
        	dp[i][4] = 1;
        	for(int j = 3; j >= 0; j--) {
        		sum += dp[i - 1][j];
        		dp[i][j] = sum;
        	}
        }
        
        int ans = 0;
        for(int i = 0; i < 5; i++) {
        	ans += dp[n - 1][i];
        }
        
        return ans;
    }
}
