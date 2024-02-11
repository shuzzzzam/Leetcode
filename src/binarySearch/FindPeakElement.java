package binarySearch;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1;
		
		while(start < end) {
			if(end - start == 1) {
				if(nums[start] > nums[end])
					return start;
				else
					return end;
			}
			int mid = (start + end) / 2;
			
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			}
			
			if(nums[mid] > nums[mid - 1]) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		return 0;
    }
}
