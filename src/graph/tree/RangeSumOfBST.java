/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class RangeSumOfBST {
	/*
	 * Leetcode 938
	 * In this problem, we are making use of BST concepts to traverse to only those nodes having value in range(low-high)
	 */
	public int rangeSumBST(TreeNode root, int low, int high) {
        int rangeValue = 0;
        rangeValue = recursion(root, low, high);
        return rangeValue;
    }

	private int recursion(TreeNode root, int low, int high) {
		int sum = 0;
		if(root.val >= low && root.val <= high) {//if root is in the range of (low-high), we can go to both subtree part
			sum += root.val;
			if(root.left != null) {
				sum += recursion(root.left, low, high);
			}
			if(root.right != null)
				sum += recursion(root.right, low, high);
		}
		else if(root.val < low) {//Making use of BST property
			if(root.right != null)
				sum = recursion(root.right, low, high);
		}
		else {//Making use of BST property
			if(root.left != null)
				sum = recursion(root.left, low, high);
		}
		return sum;
		
	}
}
