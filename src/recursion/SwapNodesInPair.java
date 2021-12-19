/**
 * 
 */
package recursion;

/**
 * @author fSociety
 *
 */
public class SwapNodesInPair {
	public ListNode swapPairs(ListNode head) {
		/*
		 * This problem can be solved using recursion. In this problem, the recursion tree is linear and easy.
		 * Leetcode 24
		 */
        return recursion(head);
        
        
    }

	private ListNode recursion(ListNode head) {
		// TODO Auto-generated method stub
		ListNode p1 = head;
        if(head == null || p1.next == null)
			return head;
        ListNode p2 = p1.next;
        p1.next = p2.next;
        p2.next = p1;
        p1.next = recursion(p1.next);
        return p2;
	}
}