/**
 * 
 */
package dp;

/**
 * @author fSociety
 *
 */
public class PartitionEqualSubsetSum {
	/*
	 * Leetcode 416
	 * In this problem we will make use of memoization technique in DP
	 * Variation of 0/1 Knapsack
	 */
	Boolean[][] dp;//For Memoization
    public boolean canPartition(int[] nums) {
        boolean result = false;
        int sumValue = 0;
        for(int i = 0; i < nums.length; i++) {
        	sumValue += nums[i];
        }
        if(sumValue % 2 == 1)
        	return false;
        dp = new Boolean[nums.length + 1][(sumValue/2) + 1];
        result = recursion(nums, sumValue/2, nums.length);//recursive call
        return result;
    }

	private boolean recursion(int[] nums, int sumValue, int length) {
		if(sumValue == 0)//base condition
			return true;
		if((length == 0 || (sumValue < 0)))//base condition
			return false;
		if(dp[length][sumValue] != null) {
			return dp[length][sumValue];//if value already present, don't go for further recursion
		}
		
		return dp[length][sumValue] = recursion(nums, sumValue - nums[length - 1],  length - 1) || recursion(nums, sumValue, length - 1);
	}
}
