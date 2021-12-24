/**
 * 
 */
package dp.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class WordBreak {
	/*
	 * In this problem , we will deal with the recursive question with memoization.
	 */
	
	//This deals with memoization with respect to word creation from word dictionary, which is the wrong approach
	public boolean wordBreakRecursive(String s, List<String> wordDict) {
        return canFormRecursive(s, "", wordDict);
    }

	private boolean canFormRecursive(String s, String string, List<String> wordDict) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(s.equals(string))
			return true;
		if(s.length() < string.length())
			return false;
		for(int i = 0; i < wordDict.size(); i++) {
			result = (result || canFormRecursive(s, string + wordDict.get(i), wordDict));
		}
		return result;
	}
	
	public boolean wordBreakMemoization(String s, List<String> wordDict) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return canFormMemoization(s, "", wordDict, map);
    }
	
	private boolean canFormMemoization(String s, String string, List<String> wordDict, HashMap<String,Integer> map) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(s.equals(string)) {
			map.put(string, 1);
			return true;
		}
			
		if(s.length() < string.length())
			return false;
		for(int i = 0; i < wordDict.size(); i++) {
			if(map.isEmpty())
				result = (result || canFormMemoization(s, string + wordDict.get(i), wordDict, map));
			else {
				result = true;
				break;
			}
		}
		return result;
	}
	
	//This is correct approach
	/*
	 * In this approach, we use recursion for word match at index i and do memoization for 
	 */
	
	public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1]; //For memoization
        Arrays.fill(dp, -1);
        return wordBreak(s, wordDict, 0, dp);        
    }
    
    private boolean wordBreak(String s, List<String> wordDict, int i, int[] dp){
        if(i == s.length()) return true;
        if(dp[i] != -1) return dp[i]==1;//benefit of memoization
        
        boolean result = false;
        for(String word: wordDict){
            int l = word.length();
            
            if(i+l <= s.length() && s.substring(i, i+l).equals(word)){
                result = result | wordBreak(s, wordDict, i+l, dp);// recursive call
            }
                
        }
        dp[i] = result? 1:0;
        return result;
    }
	
}
