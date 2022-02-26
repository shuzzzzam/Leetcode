/**
 * 
 */
package dp.memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		int[] dp = new int[s.length()+1]; //For memoization
        Arrays.fill(dp, -1);
        List<String> ans = new ArrayList<String>();
        String str = "";
        int index = 0;
        boolean result = false;
        result = getRecursive(s, str, index, wordDict, dp, ans);
        return ans;
    }

	private boolean getRecursive(String s, String str, int index, List<String> wordDict, int[] dp, List<String> ans) {
		// TODO Auto-generated method stub
		boolean result = false;
		for(int i = 0; i < wordDict.size(); i++) {
			String word = wordDict.get(i);
			if((index + word.length() < s.length()) && (s.substring(index,  index + word.length()).equals(word))) {
				result = (result | getRecursive(s, str + word + " ", index + word.length(), wordDict, dp, ans));
			}
		}
		return result;
		
	}
}
