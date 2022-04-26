/**
 * 
 */
package dp;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class InterleavingString {
	/*
	 * Leetcode 97
	 * Below we will solve the interleaving string with memoization
	 */
	//Below is an example of 3dimensional hashmap.
	public HashMap<String, HashMap<String, HashMap<String, Boolean>>> dpMemo = new HashMap<String, HashMap<String,HashMap<String,Boolean>>>();
	public boolean isInterleave(String s1, String s2, String s3) {
		if(dpMemo.containsKey(s3) && dpMemo.get(s3).containsKey(s1) && dpMemo.get(s3).get(s1).containsKey(s2)) {
			return dpMemo.get(s3).get(s1).get(s2);//memoization
		}
		//base condition
        if(s3.length() == 0) {
        	if(s1.length() == 0 && s2.length() == 0) {
        		setValue(s3, s1, s2, true);
        		return true;
        	}
        		
        	else {
        		setValue(s3, s1, s2, false);
        		return false;
        	}
        		
        }
        
      //base condition
        if(s1.length() == 0) {
        	if(s3.equals(s2)) {
        		setValue(s3, s1, s2, true);
        		return true;
        	}
        		
        	else {
        		setValue(s3, s1, s2, false);
        		return false;
        	}	
        }
        
      //base condition
        if(s2.length() == 0) {
        	if(s3.equals(s1)) {
        		setValue(s3, s1, s2, true);
        		return true;
        	}	
        	else {
        		setValue(s3, s1, s2, false);
        		return false;
        	}
        		
        }
        
        //recursive tree
        String topS1 = s1.substring(0, 1), topS2 = s2.substring(0, 1), topS3 = s3.substring(0, 1);
        if(topS3.equals(topS1) && topS3.equals(topS2)) {
        	 
        	boolean val = isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));//main logic(recursion tree)
        	setValue(s3, s1, s2, val);//memoization
        	return val;
        }
        else {
        	if(topS3.equals(topS1)) {
        		boolean val = isInterleave(s1.substring(1), s2, s3.substring(1));
        		setValue(s3, s1, s2, val);
            	return val;
        	}
        	else if(topS3.equals(topS2)) {
        		boolean val = isInterleave(s1, s2.substring(1), s3.substring(1));
        		setValue(s3, s1, s2, val);
            	return val;
        	}
        	else {
        		setValue(s3, s1, s2, false);
        		return false;
        	}
        }
        
    }
	private void setValue(String s3, String s1, String s2, boolean value) {
		// TODO Auto-generated method stub
		if(!dpMemo.containsKey(s3)) {
			HashMap<String, HashMap<String, Boolean>> map = new HashMap<String, HashMap<String,Boolean>>();
			HashMap<String, Boolean> map2 = new HashMap<String, Boolean>();
			map2.put(s2, value);
			map.put(s1, map2);
			dpMemo.put(s3, map);
		}
		else {
			HashMap<String, HashMap<String, Boolean>> map = dpMemo.get(s3);
			if(!map.containsKey(s1)) {
				HashMap<String, Boolean> map2 = new HashMap<String, Boolean>();
				map2.put(s2, value);
				map.put(s1, map2);
				dpMemo.put(s3, map);
			}
			else {
				HashMap<String, Boolean> map2 = map.get(s1);
				if(!map2.containsKey(s2)) {
					map2.put(s2, value);
					
				}
				map.put(s1, map2);
				dpMemo.put(s3, map);
			} 
		}
	}
}
