/**
 * 
 */
package binarySearch;

/**
 * @author fSociety
 *
 */
public class FindMinimumInRotatedSortedArray {
	/*
	 * Leetcode 153
	 * This problem is similar to Leetcode 33. In this we have to find minimum element of all distinct elements present in array.
	 */
	public int findMin(int[] nums) {
        return getMin(nums, 0, nums.length - 1);
    }

	private int getMin(int[] nums, int start, int end) {
		if(nums[start] <= nums[end]) {
			return nums[start];//If it is sorted, then we know the first element is smallest.
		}
		
		int midValue = nums[(start + end) / 2];
		
		if(midValue >= nums[start]) {
			return getMin(nums, (start + end) / 2 + 1, end);//In this case, right subarray will have smallest element
		}
		else {
			return getMin(nums, start, (start + end) / 2);//In this, we will take left subarray but including the mid elemnt because it is smaller than nums[end] but we still don't know is it smallest element.
		}
	}
}
