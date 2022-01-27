/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class MaxConsecutiveOnes {
	/*
	 * Leetcode 485
	 * This problem is an example of variable size window to calculate consecutive ones.
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0, length = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	
        	if(nums[i] == 1) {
        		length++;
        		if(length > maxLength)
        			maxLength = length;//Variable size window
        	}
        	else {
        		length = 0;
        	}
        }
        
        return maxLength;
    }
}
