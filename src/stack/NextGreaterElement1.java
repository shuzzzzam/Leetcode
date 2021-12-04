/**
 * 
 */
package stack;

/**
 * @author fSociety
 *
 */
public class NextGreaterElement1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		/* Problem 496 Leetcode
		 * This problem is solved using stack implementation from right side, since we want next greater from right side
		 * */
		
		int[] hash = new int[10001];
		for(int i = 0; i < 10001; i++) {
			hash[i] = -1;
		}
		int[] stack = new int[nums2.length];
		int head = -1;
		//Stack Implementation for putting large value from right hand side.
		stack[++head] = nums2[nums2.length - 1];
		hash[nums2.length - 1] = -1;
		for(int i = (nums2.length - 2); i >= 0; i--) {
			if(stack[head] > nums2[i]) {
				hash[nums2[i]] = stack[head];
				stack[++head] = nums2[i]; 
			}
			else {
				while((head >= 0) && stack[head] < nums2[i]) {
					head--;
				}
				if(head == -1)
					hash[nums2[i]] = -1;
				else
					hash[nums2[i]] = stack[head];
				
				stack[++head] = nums2[i];
			}
		}
		int[] res = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			res[i] = hash[nums1[i]];
		}
		return res;
    }
}
