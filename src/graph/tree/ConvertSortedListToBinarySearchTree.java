/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class ConvertSortedListToBinarySearchTree {
	/*
	 * Leetcode 109;
	 * In this problem, we will use Divide & conquer to divide it into two left hand & right Hand sorted array & it satisfies with Mid Node to get BST.
	 */
	public TreeNode sortedListToBST(ListNode head) {
        return recursion(head);
    }

	private TreeNode recursion(ListNode head) {
		if(head == null)
			return null;
		ListNode leftPartStart = null, leftPartEnd = null, midNode = head, midFastSpeed = head;
		
		/*
		 * Below method is fastest way to get to the middle element;
		 */
		while(midFastSpeed.next != null && midFastSpeed.next.next != null) {
			leftPartEnd = midNode;
			midNode = midNode.next;
			midFastSpeed = midFastSpeed.next.next;
		}
		
		TreeNode treeNode = new TreeNode(midNode.val);//After getting midNode, create Node with the same value & recursively call for left hand side & right hand side BST.
		if(leftPartEnd != null) {
            leftPartEnd.next = null;
            leftPartStart = head;
        }
			
		treeNode.left = recursion(leftPartStart);
		treeNode.right = recursion(midNode.next);
		
		return treeNode;
	}
}
