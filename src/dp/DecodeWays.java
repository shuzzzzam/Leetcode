/**
 * 
 */
package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author fSociety
 *
 */
public class DecodeWays {
	/*
	 * Leetcode 91
	 * In this problem, we will use memoization to solve the below DP question.
	 */
	public HashSet<String> set = null;//contains Alphabet to number string mapping.
	public HashMap<String, Integer> memoize = new HashMap<String, Integer>();//stores decodeways value of a particular substring.
	public int numDecodingsWithMemoization(String s) {
        set = new HashSet<String>();
        for(int i = 1; i <= 26; i++) {
        	set.add(Integer.toString(i));//adding the mapping.
        }
        
        return recursion(s);//recursive call to get decodeways.
    }
	private int recursion(String s) {
		if(memoize.containsKey(s)) {
			int val = memoize.get(s);//memoization in action
            return val;
		}
		
		//Base Condition of size 1 substring
		if(s.length() == 1) {
			if(set.contains(s)) {
                int val = 1;
                memoize.put(s, val);
				return val;
            }
				
			else {
                int val = 0;
                memoize.put(s, val);
				return val;
            }
				
		}
		
		//base condition of size 2 substring
		if(s.length() == 2) {
			if(set.contains(s.substring(0, 1)) && set.contains(s.substring(0, 2))) {
				int val =  recursion(s.substring(1)) + 1;
				memoize.put(s, val);
				return val;
			}
			else {
				if(set.contains(s.subSequence(0, 1))) {
					int val = recursion(s.substring(1));
					memoize.put(s, val);
					return val;
				}
				else if(set.contains(s.substring(0, 2))) {
					int val = 1;
                    memoize.put(s, val);
					return val;
				}
				else {
					int val = 0;
                    memoize.put(s, val);
					return val;
				}
			}
		}
		
		//Below is the recursive call structure
		if(s.length() > 2) {
			if(set.contains(s.substring(0, 1)) && set.contains(s.substring(0, 2))) {//checking if first and first two letters present in our alphabet to integer string mapping.
				int val =  recursion(s.substring(1)) + recursion(s.substring(2));
				memoize.put(s, val);
				return val;
			}
			else {
				if(set.contains(s.subSequence(0, 1))) {//following only valid number string
					int val =  recursion(s.substring(1));
					memoize.put(s, val);
					return val;
				}
				else if(set.contains(s.substring(0, 2))) {
					int val =  recursion(s.substring(2));
					memoize.put(s, val);
					return val;
				}
				else {
					int val =  0;
                    memoize.put(s, val);
					return val;
				}
			}
		}
		
		int val = 0;
        memoize.put(s, val);
		return val;
	}
	/*
	 * Below we will do this code with top-down approach
	 */
	
	public int numDecodings(String s) {
		set = new HashSet<String>();
        for(int i = 1; i <= 26; i++) {
        	set.add(Integer.toString(i));//adding the mapping.
        }
        if(s.length() == 1) {
        	if(set.contains(s))
        		return 1;
        	else
        		return 0;
        }
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        if(set.contains(s.substring(s.length() - 1))) {
        	dp[s.length() - 1] = 1;
        }
        else {
        	dp[s.length() - 1] = 0;
        }
        
        if(set.contains(s.substring(s.length() - 2)) && set.contains(s.substring(s.length() - 2, s.length() - 1))) {
        	dp[s.length() - 2] = 1 + dp[s.length() - 1];
        }
        else {
        	if(set.contains(s.substring(s.length() - 2, s.length() - 1))) {
        		dp[s.length() - 2] = dp[s.length() - 1];
        	}
        	else if(set.contains(s.substring(s.length() - 2))) {
        		dp[s.length() - 2] = 1;
        	}
        	else {
        		dp[s.length() - 2] = 0;
        	}
        	
        }
        
        
        for(int i = s.length() - 3; i >= 0; i--) {
        	if(set.contains(s.substring(i, i + 1)) && set.contains(s.substring(i, i + 2))) {
        		dp[i] = dp[i + 2] + dp[i + 1];
        	}
        	else {
        		if(set.contains(s.subSequence(i, i + 1))) {
        			dp[i] = dp[i + 1];
        		}
        		else if(set.contains(s.substring(i, i + 2))) {
        			dp[i] = dp[i + 2];
        		}
        		else {
        			dp[i] = 0;
        		}
        	}
        }
        
        return dp[0];
        
    }
}
