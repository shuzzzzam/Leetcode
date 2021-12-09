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
        int ans = 0, min = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++) {
        	sum[i] = (sum[i - 1] + nums[i - 1]);
        }
        min = sum[1];
        for(int i = 0; i < nums.length; i++) {
        	int diff = (nums[i] - min);
        }
        return ans;
        
    }
}
