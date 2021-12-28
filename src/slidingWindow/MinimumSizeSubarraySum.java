/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class MinimumSizeSubarraySum {
	/*
	 * Leetcode 209
	 * In this problem, we made use of variable sliding window algorithm to get the window size of sum >= target.
	 * 
	 */
	public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE, sum = 0;
        int start = 0, end = 0;
        while((end < nums.length) && (start <= end)) {
        	sum += nums[end];
        	if(sum >= target) {
        		while(sum >= target) {//variable window algorithm
        			int tmpSize = (end - start + 1);
            		if(tmpSize < size)
            			size = tmpSize;
        			sum -= nums[start++];
        		}
        		
        	}
        	end++;
        }
        if(size == Integer.MAX_VALUE)
        	return 0;
        return size;
    }
}
