/**
 * 
 */
package recursion;

/**
 * @author fSociety
 *
 */
public class ReverseLinkedList {
	/*
	 * Leetcode 206
	 * This problem is a classic example of recursion using IBH principle
	 */
	ListNode newHead = null;
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
		recursion(head);
        return newHead;
    }
	private ListNode recursion(ListNode head) {
		 
		if(head.next == null) {//Base Condition
            newHead = head;
            return head;
        }
			
		ListNode node = recursion(head.next);//Induction Phase
		node.next = head;
		head.next = null;
		return head;
		
	}
}
