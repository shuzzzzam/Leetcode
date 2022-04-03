/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class WildcardMatching {
	/*
	 * Leetcode 44
	 * Below we will have solved the issue with memoization.
	 */
	public int[][] dp = null;//memoized array.
    public boolean isMatch(String s, String p) {
		dp = new int[s.length() + 1][p.length() + 1];
		for(int i = 0; i <= s.length(); i++) {
			for(int j = 0; j <= p.length(); j++) {
				dp[i][j] = -1;//Inizialization of dp array.
			}
		}
		extracted(s, p);//start recusive call
		if(dp[s.length()][p.length()] == 1)
			return true;
		else
			return false;
    }

	private int extracted(String s, String p) {
		if(dp[s.length()][p.length()] != -1)
			return dp[s.length()][p.length()];//memoization call is prevented.
		if(s.length() == 0 && p.length() == 0) {
			dp[s.length()][p.length()] = 1;
			return dp[s.length()][p.length()];//base condition.
		}
        	
        if((s.length() != 0 && p.length() == 0)) {
            //return 0;
        	dp[s.length()][p.length()] = 0;//base condition.
        	return dp[s.length()][p.length()];
            
        }
        if(s.length() == 0 && p.length() != 0) {
            if(check(p)) {//check if it contains only "*" in the pattern.
            	dp[s.length()][p.length()] = 1;
            }
            else {
            	dp[s.length()][p.length()] = 0;
            }
            
            return dp[s.length()][p.length()];
        }
        	
        if(p.charAt(0) == '*' || p.charAt(0) == '?') {
        	if(p.charAt(0) == '*') {
        		dp[s.length()][p.length()] = Math.max(extracted(s, p.substring(1)), Math.max(extracted(s.substring(1), p.substring(1)), extracted(s.substring(1), p)));
                return dp[s.length()][p.length()];//Recursive call for three condition(1. map "*" to zero occurence, 2. map "*" to only one character, 3. map "*" to current character and stay at same level.)
        	}
        	else {
        		dp[s.length()][p.length()] = extracted(s.substring(1), p.substring(1));
                return dp[s.length()][p.length()];//Map only one character.
        	}
        }
        else {
        	if(s.charAt(0) != p.charAt(0)) {
        		dp[s.length()][p.length()] = 0;
        		return dp[s.length()][p.length()];//If character mismatches, then return false;
        	}
        		
        	else {
                dp[s.length()][p.length()] = extracted(s.substring(1), p.substring(1));
                return dp[s.length()][p.length()];//If matches, match the character and go to next character.
            }
        		
        }
	}
    
    private boolean check(String p) {
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) != '*')
                return false;
        }
        
        return true;
    }
    
    
    /*
     * To do top-down approach
     * 
     */
}
