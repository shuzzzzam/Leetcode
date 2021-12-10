/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class maxSubarray {
	public int maxSubArray(int[] nums) {
        int minSumValue = 0, max = Integer.MIN_VALUE;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++) {
        	sum[i] = (sum[i - 1] + nums[i - 1]);
        }
        minSumValue = sum[0];
        for(int i = 1; i < sum.length; i++) {
        	int diff = (sum[i] - minSumValue);
        	if(sum[i] < minSumValue)
        		minSumValue = sum[i];
        	if(max < diff)
        		max = diff;
        }
        return max;
        
    }
}
