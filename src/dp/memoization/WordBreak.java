/**
 * 
 */
package dp.memoization;

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
	
	//This deals with memoization with respect to word creation from word dictionary, which is wrong approach
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
}
