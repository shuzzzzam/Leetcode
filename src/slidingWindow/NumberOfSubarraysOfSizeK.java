/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class NumberOfSubarraysOfSizeK {
	/*
	 * Leetcode 1343
	 * In this problem, we will keep track of average value over fixed sliding window of size k
	 */
	public int numOfSubarrays(int[] arr, int k, int threshold) {
        int barrierValue = (k * threshold);
        int count = 0, sum = 0,  start = 0, end = 0;
        while(end < arr.length) {
        	sum += arr[end];
        	if((end - start + 1) == k) {
        		if(sum >= barrierValue)
        			count++;
        		sum -= arr[start++];
        		
        	}
        	end++;
        }
        return count;
    }
}
