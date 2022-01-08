/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class LongestSubarrayofOnesAfterDeletingOneElement {
	/*
	 * Leetcode 1493
	 * This problem is related to variable sliding window question.
	 * In this problem, we have to find the largest subarray with only one zero.
	 */
	public int longestSubarray(int[] nums) {
        int zeroPosition = -1, countZero = 0;//for checking count of zero and it's position.
        int length = 0, maxLength = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 1) {
        		length++;
        	}
        	else {
        		if(countZero == 0) {
        			countZero = 1;
        			zeroPosition = i;
        			length++;
        		}
        		
        		if(countZero == 1) {
        			if(length > maxLength)
        				maxLength = length;
        			length = (i - zeroPosition);//When we encounter second zero, we change zeroPosition and change length
        			zeroPosition = i;
        			countZero = 1;
        		}
        	}
        }
        return maxLength - 1;
    }
}
