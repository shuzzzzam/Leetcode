/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class MinimumOperationsToReduceXToZero {
	/*
	 * Leetcode 1658
	 * This question is a good example on how to twist a question.
	 * If we read the problem statement, We wil be confused to find solution through recursion using elements at both ends.
	 * But we have to solve this by finding the subarray which has maximum length of sum (SumOfArray - x).
	 */
	public int minOperations(int[] nums, int x) {
		int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        }
        int sumR = (sum - x), maxSize = -1;//This is the sum for which we have to find the maximum length window
        int i = 0, j = 0;
        sum = 0;
        while(i < nums.length) {
        	sum += nums[i];
        	if(sum >= sumR) {
        		if(sum == sumR) {
        			int size = (i - j + 1);
            		if(size > maxSize)
            			maxSize = size;
        		}
        		while(sum >= sumR && (j <= i)) {
        			sum -= (nums[j]);
        			j++;
        			if(sum == sumR) {
        				int size = (i - j + 1);
                		if(size > maxSize)
                			maxSize = size;
        			}
        		}
        		
        	}
        	i++;
        }
        if(maxSize == -1)
            return -1;
        return nums.length - maxSize;
    }
}
