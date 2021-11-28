/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class countSubarraySumOfKInTheArray {
	public int subarraySum(int[] nums, int k) {
		/*
		 * This question uses variable sliding window techniques to solve.
		 */
		
        int count = 0;
        int head = 0, tail = 0, sum = 0;
        while((head <= tail) && (tail < nums.length)) {
        	sum += nums[tail];
        	if(sum < k) {
        		tail++;
        	}
        	else if(sum == k) {
        		count++;
        		sum -= nums[head];
        		head++;
        		tail++;
        		sum += nums[tail];
        	}
        	else {
        		sum -= nums[head];
        		head++;
        	}
        }
        return count;
    }
}
