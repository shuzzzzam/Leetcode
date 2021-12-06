/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class continuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        boolean flag = false;
        int[] sum = new int[nums.length];
        sum[0] = (nums[0] % k);
        //HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] map = new int[k];
        for(int i = 0; i < map.length; i++)
        	map[i] = 0;
        for(int i = 1; i < nums.length; i++) {
        	sum[i] = (((sum[i - 1] % k) + (nums[i] % k)) % k);
        }
        
        for(int i = 2; i <= nums.length; i++) {
			map[i - 2] = 1;
			if(map[sum[i]] == 1) {
				flag = true;
				break;
			}
		}
        return flag;
    }
}
