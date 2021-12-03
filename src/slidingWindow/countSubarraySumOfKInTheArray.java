/**
 * 
 */
package slidingWindow;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class countSubarraySumOfKInTheArray {
	public int subarraySum(int[] nums, int k) {
		/* problem 556(leetcode)
		 * This question uses variable sliding window techniques to solve.
		 */
		
		int[] sum = new int[nums.length + 1];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int val = 0;
		int count = 0;
		sum[0] = 0;
		for(int i = 1; i <= nums.length; i++) {
			sum[i] = (val + nums[i - 1]);
			
		}
		
		for(int i = 0; i <= nums.length; i++) {
			int searchValueMap = sum[i] - k;
			if(map.containsKey(searchValueMap))
				count += (map.get(searchValueMap));
			if(!map.containsKey(sum[i])) {
				map.put(sum[i], 1);
			}
			else {
				int tmp = map.get(sum[i]);
				map.put(sum[i], tmp + 1);
			}
		}
		
		return count;
    }
}
