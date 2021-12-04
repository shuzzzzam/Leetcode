/**
 * 
 */
package stack;

/**
 * @author fSociety
 *
 */
public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
        /* Problem 503 Leetcode
         * Here in this problem instead of next Greater Element in Right, I have to find the next Greater Element In a round manner of stack
         */
		int[] res = new int[nums.length];
		int[] stack = new int[2 * nums.length];//For circular array , to maintain the stack we have to make it twice the size of array for only increasing elements.
		int head = -1;
		for(int i = (nums.length - 2); i >= 0; i--) {
			stack[++head] = nums[i];
		}
		for(int i = (nums.length - 1); i >= 0; i--) {
			if(head == -1) {
				res[i] = -1;
				
			}
			else {
				while((head >= 0) && (stack[head] <= nums[i])) {//Stack operations of getting first greater element. It is same in all the variants of these types of questions.
					head--;
				}
				if(head == -1)
					res[i] = -1;
				else {
					res[i] = stack[head];
				}
			}
			stack[++head] = nums[i];
		}
		return res;
    }
}
