/**
 * 
 */
package array;

import java.util.HashSet;

/**
 * @author fSociety
 *
 */
public class ContainsDuplicate {
	/*
	 * Leetcode 217
	 * Basic Operation of having hashSet to keep track of elements repeatation in list.
	 */
	public boolean containsDuplicate(int[] nums) {
        boolean containsDuplicate = false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(set.contains(nums[i])) {
        		containsDuplicate = true;
        		break;
        	}
        	set.add(nums[i]);
        }
        
        return containsDuplicate;
    }
}
