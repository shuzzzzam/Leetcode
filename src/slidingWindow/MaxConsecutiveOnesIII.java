/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class MaxConsecutiveOnesIII {
	/*
	 * Leetcode 1004
	 * This is the variable sliding window example. We have to maintain the size of variable window with 'K' size zeroes.
	 */
	public int longestOnes(int[] nums, int k) {
        int maxOnes = 0;//To keep track of max Ones
        if(k == 0) {//For corner case of zero "K", we have to just return max count of consecutive ones.
        	int count = 0;
        	for(int i = 0; i < nums.length; i++) {
        		if(nums[i] == 1) {
        			count++;
        			if(count > maxOnes)
        				maxOnes = count;
        		}
        		else
        			count = 0;
        	}
        	return maxOnes;
        }
        
        int i = 0, j= 0;
        int count = 0;
        while(j < nums.length) {
        	if(nums[j] == 1) {//If it is one, no issue, go on increasing window.
        		count++;
        		j++;
        		if(count > maxOnes)
        			maxOnes = count;
        	}
        	else {
        		if(k > 0) {//if K is positive, go on increasing widow size till it becomes zero.
        			k--;
        			count++;
        			j++;
        			if(count > maxOnes)
            			maxOnes = count;
        		}
        		else {
        			while(k == 0) {//If there is no room to increase window, go on increasing left side of window to get the room.
        				if(nums[i] == 0) {
        					k++;
        				}
        				i++;
        			}
        			
        			count = (j - i);
        			j++;
        		}
        	}
        }
        
        return maxOnes;
    }
}
