/**
 * 
 */
package dp;

import java.util.Arrays;

/**
 * @author fSociety
 *
 */
public class JumpGame2 {
	/*
	 * Leetcode 45
	 * This problem is solved by using basic Dp. Using two loops and a dp array to store result.
	 */
	public int jumpNaive(int[] nums) {
        int[] dp = new int[nums.length];//initialize the dp array
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;//base condition
        for(int i = (nums.length - 2); i >= 0; i--) {
            
        	int min = Integer.MAX_VALUE;
        	int jump = nums[i];
        	for(int j = 1; j <= jump; j++) {
        		if((i + j) >= nums.length)
        			break;
				if (dp[i + j] != -1) {
					if (min > dp[i + j]) {
						min = dp[i + j];
					}
				}
        		
        	}
            if(min != Integer.MAX_VALUE)
        	    dp[i] = 1 + min; 
        }
        
        return dp[0];
    }
}
