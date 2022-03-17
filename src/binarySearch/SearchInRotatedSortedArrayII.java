/**
 * 
 */
package binarySearch;

/**
 * @author fSociety
 *
 */
public class SearchInRotatedSortedArrayII {
	/*
	 * Leetcode 81
	 * This Problem is similar to Leetcode 33. Go check it's content. We just added another condition for checking in case of repeated element.
	 */
	public boolean search(int[] nums, int target) {
        return isPresent(nums, target, 0, nums.length - 1);
    }

	private boolean isPresent(int[] nums, int target, int start, int end) {
        if(start > end)//Base condition.
            return false;
		if(nums[start] < nums[end]) {
			return binarySearch(nums, target, start, end);
		}
		
		int midValue = nums[(start + end) / 2];
		if(midValue == target) {
			return true;
		}
		
		if(midValue > nums[start]) {//If left subarray of middle element is sorted from left to right, then we have below two choices.
			if(target >= nums[start] && target < midValue) {
				return binarySearch(nums, target, start, ((start + end) / 2 - 1));//if target falls in the range of left subarray, then do binary search.
			}
			else {
				return isPresent(nums, target, ((start + end) / 2) + 1, end);//Otherwise recursively call isPresent() for right side subarray as it is rotated subarray.
			}
		}
		else if(midValue < nums[end]) {//Similar operation if right side subarray is sorted.
			if(target > midValue && target <= nums[end]) {
				return binarySearch(nums, target, ((start + end) / 2 + 1), end);
			}
			else {
				return isPresent(nums, target, start, ((start + end) / 2) - 1);
			}
		}
		else {//Extra added operation in case we can't decide which of both side subarray is sorted.
			return isPresent(nums, target, start, ((start + end) / 2) - 1) || isPresent(nums, target, ((start + end) / 2 + 1), end);
		}
	}

	private boolean binarySearch(int[] nums, int target, int i, int j) {
		int start = i, end = j;
		boolean ans = false;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				ans = true;
				break;
			}
			
			if(target < nums[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return ans;
	}
}
