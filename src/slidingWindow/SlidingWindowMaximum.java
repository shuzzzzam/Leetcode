/**
 * 
 */
package slidingWindow;

import java.util.PriorityQueue;

/**
 * @author fSociety
 *
 */
public class SlidingWindowMaximum {
	/*
	 * Leetcode 239
	 * In below Naive solution, we will use two heaps two keep track of current Max heap elements and in PastHeap we will have all those past elements who are outside of sliding window.
	 */
	public int[] maxSlidingWindowNaiveSolution(int[] nums, int k) {
		int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> currentHeap = new PriorityQueue<Integer>((a,b) -> b.intValue() - a.intValue());//Current heap elements in the sliding window. 
        PriorityQueue<Integer> pastHeap = new PriorityQueue<Integer>((a,b) -> b.intValue() - a.intValue());//Past Heap elements in which all the remaining elements which are outside of heap is present.
        for(int i = 0; i < k; i++) {
        	currentHeap.add(nums[i]);
        }
        
        ans[0] = currentHeap.peek();
        
        for(int i = k; i < nums.length; i++) {
        	pastHeap.add(nums[i - k]);
        	while((!pastHeap.isEmpty()) && (!currentHeap.isEmpty()) && currentHeap.peek().equals(pastHeap.peek())) {//When both peek() value is same , we know that element which is outside of sliding window is present in current heap. We have to remove this inconsistent value.
        		/*
        		 * Removing the inconsistent element on top.
        		 */
        		currentHeap.poll();
        		pastHeap.poll();
        	}
        	currentHeap.add(nums[i]);
        	
        	ans[i - k + 1] = currentHeap.peek();
        }
        
        return ans;
    }
	
	
	public int[] maxSlidingWindowBestAlternative(int[] nums, int k) {
        int[] max_left = new int[nums.length];
        int[] max_right = new int[nums.length];
        max_left[0] = nums[0];
        max_right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);
            int j = nums.length - i - 1;
            max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
        }
        int[] sliding_max = new int[nums.length - k + 1];
        for (int i = 0; i + k <= nums.length; i++) {
            sliding_max[i] = Math.max(max_right[i], max_left[i + k - 1]);
        }
        return sliding_max;
    }

}
