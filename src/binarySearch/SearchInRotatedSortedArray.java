/**
 * 
 */
package binarySearch;

/**
 * @author fSociety
 *
 */
public class SearchInRotatedSortedArray {
	/*
	 * Leetcode 33
	 * In this problem, we will use binary search to divide the given array into two array(one is perfectly sorted & another Rotated sorted array.)
	 */
	public int search(int[] nums, int target) {
        return getIndex(nums, target, 0, nums.length - 1);
    }

	private int getIndex(int[] nums, int target, int i, int j) {
		if(nums[i] <= nums[j])
			return binarySearch(nums, target, i, j);//If the array is perfectly sorted, do binary Search
		int midValue = nums[(i + j) / 2];//Get middle element
		if(midValue == target)
			return (i + j) / 2;
		if(midValue >= nums[i]) {//If left subarray of middle element is sorted from left to right, then we have below two choices.
			if(target >= nums[i] && target < midValue) {
				return binarySearch(nums, target, i, ((i + j) / 2 - 1));//if target falls in the range of left subarray, then do binary search.
			}
			else {
				return getIndex(nums, target, ((i + j) / 2) + 1, j);//Otherwise recursively call getIndex() for right side subarray as it is rotated subarray.
			}
		}
		else {//Similar operation if right side subarray is sorted.
			if(target > midValue && target <= nums[j]) {
				return binarySearch(nums, target, ((i + j) / 2 + 1), j);
			}
			else {
				return getIndex(nums, target, i, ((i + j) / 2) - 1);
			}
		}
	}

	private int binarySearch(int[] nums, int target, int i, int j) {
		int start = i, end = j;
		int ans = -1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(nums[mid] == target) {
				ans = mid;
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
