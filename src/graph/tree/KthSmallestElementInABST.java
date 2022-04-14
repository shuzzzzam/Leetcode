/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class KthSmallestElementInABST {
	/*
	 * Leetcode 230
	 * In this problem, we will use Recursion to get the kth smallest element;
	 */
	int ans;//get answer
	int count;//counter value to check recursion level;
	public int kthSmallest(TreeNode root, int k) {
        count = k;//initialise the counter
        recursion(root);
        return ans;
    }
	private void recursion(TreeNode root) {
		if(root == null)
			return;
		recursion(root.left);//recursion tree which inorder
		count--;
		if(count == 0) {
			ans = root.val;
			return;
		}
		recursion(root.right);
		
	}
}
