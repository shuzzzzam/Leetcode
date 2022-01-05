/**
 * 
 */
package slidingWindow;

import java.util.Arrays;

/**
 * @author fSociety
 *
 */
public class SubstringsOfSizeThreewithDistinctCharacters {
	/*
	 * Leetcode 1876
	 * This problem requires simple knowledge of fixed slidind window approach.
	 */
	public int countGoodSubstrings(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        int distictCharacterCount = 0, ans = 0;
        int i = 0, j = 0;
        while(j < s.length()) {
        	if((j - i) < 3) {
        		//
                //distictCharacterCount++;
        		if(hash[s.charAt(j) - 'a'] == 0) {
        			distictCharacterCount++;//To track record of distinct character
        		}
        		hash[s.charAt(j) - 'a'] += 1;
        		if(distictCharacterCount == 3)//If it matches 3, then we find the solution.
        			ans++;
        		j++;
        	}
        	else {
        		hash[s.charAt(i) - 'a'] -= 1;
        		if(hash[s.charAt(i) - 'a'] == 0)
        			distictCharacterCount--;//decrement from left side window sliding
        		i++;
        	}
        }
        return ans;
    }
}
