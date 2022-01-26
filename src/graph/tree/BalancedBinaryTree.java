/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class BalancedBinaryTree {
	/*
	 * Leetcode 110
	 * Using recursion to calculate isBalanced.
	 */
	public boolean isBalanced(TreeNode root) {
        int val = recursion(root);
        if(val == -1)
        	return false;
        return true;
    }
	private int recursion(TreeNode root) {
		//Base condition
		if(root == null)
			return 0;
		
		//Left subtree
		int leftTreeSize = recursion(root.left);
		if(leftTreeSize == -1)
			return -1;
		//Right subtree
		int rightTreeSize = recursion(root.right);
		if(rightTreeSize == -1)
			return -1;
		if(Math.abs(rightTreeSize - leftTreeSize) > 1)
			return -1;
		return 1 + Math.max(leftTreeSize, rightTreeSize);
	}
}
