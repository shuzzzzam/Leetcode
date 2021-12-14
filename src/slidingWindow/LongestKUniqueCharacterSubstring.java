/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class LongestKUniqueCharacterSubstring {
	/*
	 * In this problem, we will solve the longest K Unique Characters substring using sliding window mechanism.
	 * We will maintain a map for unique characters count and do sliding window;
	 * */
	
	public int longestkSubstr(String s, int k) {
        // code here
		int i = 0, j = 0, maxLength = 0, length = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();//Put Unique characters
		while((j < s.length()) && (i <= j)) {//Sliding window
			if(map.containsKey(s.charAt(j))) {
				int tmp = map.get(s.charAt(j));
				map.put(s.charAt(j), tmp + 1);
			}
			else {
				map.put(s.charAt(j), 1);
			}
			
			if(map.size() <= k) {
				length++;
				j++;
			}
			else {
				if(length > maxLength)
					maxLength = length;
				while(map.size() > k) {
					int tmp2 = map.get(s.charAt(i));
					if(tmp2 == 1)
						map.remove(s.charAt(i));
					else {
						map.put(s.charAt(i), tmp2 - 1);
					}
					
					i++;
					length--;
				}
				length++;
				j++;
			}
		}
		if(map.size() != k)//To check if map has k unique character's or not.
		    return -1;
		if(length > maxLength)
		    maxLength = length;
		return maxLength;
    }
}
