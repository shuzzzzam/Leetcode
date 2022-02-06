/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class TargetSum {
	//Leetcode 494
	
	public int findTargetSumWaysWithPureRecursion(int[] nums, int target) {
        return recursion(nums, target, 0, 0);
    }

	private int recursion(int[] nums, int target, int index, int sum) {
		if(index == nums.length) {
			if(sum == target)
				return 1;
			else
				return 0;
		}
		return recursion(nums, target, index + 1, sum + nums[index]) + recursion(nums, target, index + 1, sum - nums[index]);
	}
	
	
	/*
	 * Below is using optimization using DP
	 */
	public int findTargetSumWays(int[] nums, int target) {
        
    }
}
