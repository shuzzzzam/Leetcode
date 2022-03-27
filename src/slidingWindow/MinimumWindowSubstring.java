/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class MinimumWindowSubstring {
	/*
	 * Leetcode 76
	 * In this problem, we used variable length sliding window protocol to get 
	 */
	public String minWindow(String s, String t) {
        if(s.length() < t.length())
        	return "";//corner cases
        if(s.length() == t.length()) {
        	if(s.equals(t))
                return s;//corner cases.
        }
        String ans = s;//initialized to original string.
        HashMap<String, Integer> map = new HashMap<String, Integer>();//keep track of character count map.
        int distictChar = 0;//Distinct char count.
        for(int i = 0; i < t.length(); i++) {
        	String Ichar = t.substring(i, i + 1);
        	if(!map.containsKey(Ichar)) {
        		map.put(Ichar, 1);
        		distictChar++;
        	}
        	else {
        		int val = map.get(Ichar);
        		map.put(Ichar, val + 1);
        	}
        }
        boolean flag = false;
        int start = 0, end = 0;
        while(start <= end && end < s.length()) {//sliding window.
        	String currentChar = s.substring(end, end + 1);
        	if(map.containsKey(currentChar)) {
        		int count = map.get(currentChar);
        		count--;
        		map.put(currentChar, count);
        		if(count == 0) {
        			distictChar--;
        		}
        		if(distictChar == 0) {//when ditinct becomes to zero, then get the smaller substring.
        			if((end - start + 1) < ans.length()) {
        				ans = s.substring(start, end + 1);
        			}
        			while(distictChar == 0) {
                        flag = true;//To keep check whether the distinct count became zero so that we know that there was a smaller window created.
        				String startChar = s.substring(start, start + 1);
        				if(map.containsKey(startChar)) {
        					int val = map.get(startChar);
        					val++;
        					map.put(startChar, val);
        					if(val == 1)
        						distictChar++;
                            if((end - start + 1) < ans.length()) {//still go on checking the small substring.
                                 ans = s.substring(start, end + 1);
                            }
        				}
        				start++;
        			}
        		}
        	}
        	end++;
        }
        if(ans.equals(s) && (!flag))
            return "";
        return ans;
    }
}
