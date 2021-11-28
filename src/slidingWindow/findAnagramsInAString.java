package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class findAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		/*
		 * The Logic behind this solution is to maintain the hashmap of pattern string and compare with the fixed slide window of size(Length of pattern string) in source string.
		 */
        List<Integer> list = new ArrayList<Integer>();
        if(p.length() > s.length())
            return list;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        
        //pattern hashmap created to be compared
        for(int i = 0; i < p.length(); i++) {
        	if(map1.containsKey(p.charAt(i))) {
        		int val = map1.get(p.charAt(i));
        		map1.put(p.charAt(i), val + 1);
        	}
        	else {
        		map1.put(p.charAt(i), 1);
        	}
        }
        
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>(map1);
        int count = map2.size();
        //go in the fixed window size and compare the map2
        for(int i = 0; i < p.length(); i++) {
        	Character ch = s.charAt(i);
        	if(map2.containsKey(ch)) {
        		int val = map2.get(ch);
        		val -= 1;
        		if(val <= 0) {
        			count--;
        		}
        		map2.put(ch, val);
        	}
        }
        if(count == 0)
        	list.add(0);
        
        for(int i = 1; i < (s.length() - p.length() + 1); i++) {
        	Character ch1 = s.charAt(i - 1);
        	Character ch2 = s.charAt(i + p.length() - 1);
        	if(map2.containsKey(ch1)) {
        		int val = map2.get(ch1);
        		val += 1;
        		if(val > 0) {
        			count++;
        		}
        		map2.put(ch1, val);
        	}
        	
        	if(map2.containsKey(ch2)) {
        		int val = map2.get(ch2);
        		val -= 1;
        		if(val <= 0) {
        			count--;
        		}
        		map2.put(ch2, val);
        	}
        	
        	if(count == 0)
        		list.add(i);
        }
        return list;
    }
}
