/**
 * 
 */
package slidingWindow;

/**
 * @author fSociety
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE, sum = 0;
        int start = 0, end = 0;
        while(start <= end) {
        	sum += nums[end];
        	if(sum >= target) {
        		int tmpSize = (end - start + 1);
        		if(tmpSize < size)
        			size = tmpSize;
        		sum -= nums[start];
        		start++;
        	} 
        	end++;
        }
        if(size == Integer.MAX_VALUE)
        	return 0;
        return size;
    }
}
