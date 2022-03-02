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
	/*
	 * In this problem, we have to use Sliding window technique to find subarray(Atleast 2 elements) whose sum is divisible by k.
	 * Leetcode problem 523
	 */
	public boolean checkSubarraySum(int[] nums, int k) {
        boolean flag = false;
        int[] sum = new int[nums.length]; //Creating a prefix sum array having sum of values indexwise.
        sum[0] = (nums[0] % k); // Since we want divisible by k, we will use modulo operator.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //map to store till k - 1 value in it. If for the given index value, sum's modulo value is already present, then we know that subarray with given k is present.
        for(int i = 1; i < nums.length; i++) {
        	sum[i] = (((sum[i - 1] % k) + (nums[i] % k)) % k); // Good use of modulo operator for divisibility.
        }
        map.put(0, 1);// initialise it to zero sum
        for(int i = 1; i < nums.length; i++) {
            if(i > 1)
            	map.put(sum[i - 2], 1); //To maintain subarray size of atleast two.
			if(map.containsKey(sum[i])) {
				flag = true; //Whenever we get hold of same key value in map, we know that subarray sum is divisible by K & is atleast size of 2 because of top condition.
				break;
			}
		}
        return flag;
    }
	
	public boolean checkSubarraySumImproved(int[] nums, int k) {
		boolean flag = false;
		int i = 0, j = 1, sum = nums[0] % k, lastSum = sum;
		/*while((i < j) && (j < nums.length)) {
			sum = (sum + (nums[j] % k)) % k;
			if(sum == 0) {
				return true;
			}
			else if(sum > lastSum) {
				j++;
				lastSum = sum;
			}
			else {
				sum = (sum - (nums[i] % k)) % k;
			}
		}*/
		
		return flag;
	}
}
