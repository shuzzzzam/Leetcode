/**
 * 
 */
package dp;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author fSociety
 *
 */
public class LongestPalindromicSubstring {
	/*
	 * leetcode 5
	 * In this problem, we solved using memoization and bottom up method.
	 */
	public String longestPalindromeWithMemoization(String s) {
        if(s.length() == 1){return s;}
        
        String[][] dp = new String[s.length()][s.length()];
        return util(s,0,s.length() - 1,dp);
    }
    
    String util(String s,int start,int end,String[][] dp){
        if(start > end){return "";}
        if(dp[start][end] != null){return dp[start][end];}
        
		/**
		* Only checking if it's a palindrome if the start and end characters of the substring 
		* are equal
		**/
        if(s.charAt(start) == s.charAt(end) && isPalindrome(s,start + 1,end - 1)){
            return s.substring(start, end + 1);
        }
        /**
		* Names are based on the direction the substring will be moving to
		**/
        String right = util(s,start + 1,end,dp);
        String left = util(s,start,end - 1,dp);
        
        return dp[start][end] = right.length() > left.length()?right:left;
    }
    
    boolean isPalindrome(String s,int start,int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){return false;}
        }
        return true;
    }
    
    public String longestPalindromeWithBottomUp(String s) {
    	String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];//To keep result in bottom up fashion
        for(int i = 0; i < s.length(); i++) {
        	dp[i][i] = true;
        	if(i + 1 < s.length()) {
        		if(s.charAt(i) == s.charAt(i + 1)) {
        			dp[i][i + 1] = true;
        			ans = s.substring(i, i + 2);
        		}
        			
        		else
        			dp[i][i + 1] = false;
        	}
        }
        
        /*
         * Generate all substring and check if it is palindrome.
         */
        for(int i = 2; i < s.length(); i++) {
        	for(int j = i; j < s.length(); j++) {
        		if(s.charAt(j - i) == s.charAt(j)) {
        			dp[j - i][j] = dp[j - i + 1][j - 1];
        			if(dp[j - i][j] && (i + 1 > ans.length()))
        				ans = s.substring(j - i, j + 1);
        		}
        		else
        			dp[j - i][j] = false;
        	}
        }
        
        return ans;
        
    }
	
}
