/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class SameTree {
	/*
	 * Leetcode 100
	 * This solves the issue of identifying if two tree are same with recursion
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)//Base conditon
			return true;
		if ((p != null) && (q != null)) {
			if (p.val == q.val) {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
		return false;

	}
}
