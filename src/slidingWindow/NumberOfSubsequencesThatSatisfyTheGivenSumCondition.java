/**
 * 
 */
package slidingWindow;

import java.util.Arrays;

/**
 * @author fSociety
 *
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
	public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int i = 0, j = 1;
        double sum = 0;
        
        while((i <= j) && (j < nums.length)) {
        	if(nums[i] + nums[j] <= target) {
        		sum = (sum % (1000000007)) + (Math.pow(2, (j - i - 1)) % (1000000007));
        	}
        	else {
        		while(nums[i] + nums[j] > target) {
        			i++;
        		}
        	}
        }
    }
}
