/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class checkIfPermutationOfString {
	public boolean checkInclusion(String s1, String s2) {
		/*Leetcode prob 567
		 * The Logic behind this solution is to maintain the hashmap of pattern string and compare with the fixed slide window of size(Length of pattern string) in source string.
		 */
		if(s2.length() < s1.length())
			return false;
		boolean isPresent = false;
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); i++) {
        	if(map1.containsKey(s1.charAt(i))) {
        		int val = map1.get(s1.charAt(i));
        		map1.put(s1.charAt(i), val + 1);
        	}
        	else {
        		map1.put(s1.charAt(i), 1);
        	}
        }
		
		int count = map1.size();
        //go in the fixed window size and compare the map1
        for(int i = 0; i < s1.length(); i++) {
        	Character ch = s2.charAt(i);
        	if(map1.containsKey(ch)) {
        		int val = map1.get(ch);
        		val -= 1;
        		if(val == 0) {
        			count--;   //For this mechanism refer this https://www.youtube.com/watch?v=MW4lJ8Y0xXk&t=1391s
        		}
        		map1.put(ch, val);
        	}
        }
        if(count == 0)
        	return true;
        
        for(int i = 1; i < (s2.length() - s1.length() + 1); i++) {
        	Character ch1 = s2.charAt(i - 1);
        	Character ch2 = s2.charAt(i + s1.length() - 1);
        	if(map1.containsKey(ch1)) {
        		int val = map1.get(ch1);
        		val += 1;
        		if(val == 1) {
        			count++;
        		}
        		map1.put(ch1, val);
        	}
        	
        	if(map1.containsKey(ch2)) {
        		int val = map1.get(ch2);
        		val -= 1;
        		if(val == 0) {
        			count--;
        		}
        		map1.put(ch2, val);
        	}
        	
        	if(count == 0)
        		return true;
        }
		return isPresent;
    }
}
