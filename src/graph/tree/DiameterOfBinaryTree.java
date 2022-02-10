/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class DiameterOfBinaryTree {
	
	/*
	 * Leetcode 543
	 * In this problem we use DP to get the diameter of the tree.
	 * 
	 */
	public int diameter = 0;//This variable tracks of diameter in each recursion call
	public int diameterOfBinaryTree(TreeNode root) {
		recursion(root);//Start the recursion
        return diameter;
    }
	private int recursion(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null)//Base condition
			return 0;
		int leftHeight = recursion(root.left);//Store the value in variable
		int rightHeight = recursion(root.right);//Store the value in variable
		if(leftHeight + rightHeight > diameter)
			diameter = (leftHeight + rightHeight);//keep track of diameter by adding both value.
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
