/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class SymmetricTree {
	/*
	 * Leetcode 101
	 * Using recursion to check if the tree is symmetric
	 */
	public boolean isSymmetric(TreeNode root) {
        return recursion(root.left, root.right);
    }

	private boolean recursion(TreeNode left, TreeNode right) {
		//Checking both the left and right mirror images.
		if(left == null && right == null) {
			return true;
		}
		else {
			if(left == null || right == null)
				return false;
			if(left.val == right.val) {
				return recursion(left.right, right.left) && recursion(left.left, right.right);//Checking right and left mirror images.
			}
			else
				return false;
		}
	}
}
