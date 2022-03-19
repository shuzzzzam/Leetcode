/**
 * 
 */
package slidingWindow;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author fSociety
 *
 */
public class SlidingWindowMedian {
	/*
	 * Leetcode 480;
	 * In this problem, we will use Fixed Sliding window with sorted array. In This to remove element, we will use Binary search & to add element we will use binary search.
	 */
	public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        ArrayList<Long> sortedList = new ArrayList<Long>();
        for(int i = 0; i < k; i++) {
        	sortedList.add((long) nums[i]);//initialize sorted array
        }
        Collections.sort(sortedList);
        
        ans[0] = getMedian(sortedList);//get Median
        
        int i = 0;
        for(int j = (k); j < nums.length; j++) {
        	removeElement(sortedList, nums[i]);//Use Binary search  to remove element
        	i++;
        	addElement(sortedList, nums[j]);//Use Binary search to add element.
        	ans[i] = getMedian(sortedList);
        }
        
        return ans;
    }

	private void addElement(ArrayList<Long> sortedList, int addValue) {
		if(sortedList.size() == 0) {
            sortedList.add((long) addValue);
            return;
        }
		int start = 0, end = sortedList.size() - 1;
		
		while(start <= end) {
			
			int midIndex = (start + end) / 2;
			
			if(addValue == sortedList.get(midIndex)) {
				sortedList.add(midIndex, (long) addValue);
				break;
			}
			
			if(start == end) {
				if(addValue <= sortedList.get(start)) {
					sortedList.add(start, (long) addValue);
				}
				else {
					sortedList.add(start + 1, (long) addValue);
				}
				
				break;
			}
			
			
			if(addValue > sortedList.get(midIndex)) {
				start = midIndex + 1;
			}
			else {
				end = midIndex - 1;
			}
			
		}
		
		if(end < start) {
			if(addValue <= sortedList.get(start)) {
				sortedList.add(start, (long) addValue);
			}
			else {
				sortedList.add(start + 1, (long) addValue);
			}
		}
		
	}

	private void removeElement(ArrayList<Long> sortedList, int removeValue) {
		int start = 0, end = sortedList.size() - 1;
		while(start <= end) {
			int midIndex = (start + end) / 2;
			if(removeValue == sortedList.get(midIndex)) {
				sortedList.remove(midIndex);
				break;
			}
			if(removeValue < sortedList.get(midIndex)) {
				end = midIndex - 1;
			}
			else {
				start = midIndex + 1;
			}
		}
		
	}

	private double getMedian(ArrayList<Long> sortedList) {
		double median = 0;
		if(sortedList.size() % 2 == 1) {
			median = (double) sortedList.get(sortedList.size() / 2);
		}
		else {
			median = (double) ((double)(sortedList.get(sortedList.size() / 2) + sortedList.get((sortedList.size() - 1) / 2)) / 2);
		}
		return median;
	}
}
