/**
 * 
 */
package slidingWindow;

import java.util.HashSet;

/**
 * @author fSociety
 *
 */
public class ContainsDuplicate2 {
	/*
	 * Leetcode 219
	 * In This problem, we will use hashset set to keep track of element inside the given window.
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean containsDuplicate = false;
        HashSet<Integer> set = new HashSet<Integer>();
        if(k >= nums.length)
        	k = nums.length - 1;
        
        int i = 0, j = 0;
        for(j = 0; j <= k; j++) {
        	if(set.contains(nums[j])) {
        		containsDuplicate = true;
        		break;
        	}
        	set.add(nums[j]);
        }
        
        if((k > nums.length) || (containsDuplicate))
        	return containsDuplicate;
        
        while(j < nums.length) {
            set.remove(nums[i]);
        	if(set.contains(nums[j])) {
        		containsDuplicate = true;
        		break;
        	}
        	set.add(nums[j]);
        	i++;
        	j++;
        }
        
        return containsDuplicate;
    }
}
