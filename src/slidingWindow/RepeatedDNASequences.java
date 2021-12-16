/**
 * 
 */
package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class RepeatedDNASequences {
	/*
	 * In this problem , we will use sliding window technology for the repeated 10 letter's long string.
	 * It is a fixed sliding window question
	 * Problem 187 
	 */
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();//List containing answers.
        HashMap<String, Integer> map = new HashMap<String, Integer>();//map to track repeated characters.
        if(s.length() < 10)
        	return ans;
        for(int i = 9; i < s.length(); i++) {//fixed window sliding
        	String part = s.substring(i - 9, i + 1);
        	if(map.containsKey(part)) {
        		int count = map.get(part);
        		if(count == 1)//if it is 1, then only add the element, otherwise don't because it can add repeated elements.
        			ans.add(part);
        		map.put(part, 2);
        	}
        	else {
        		map.put(part, 1);
        	}
        }
        return ans;
    }
}
