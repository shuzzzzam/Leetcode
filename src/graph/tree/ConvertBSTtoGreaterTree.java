/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class ConvertBSTtoGreaterTree {
	/*
	 * Leetcode 538
	 * This problem is solved using brute force method making use of BST concepts.
	 */
	public TreeNode convertBST(TreeNode root) {
        return recursion(root, 0);
    }

	private TreeNode recursion(TreeNode root, int i) {
		int moreKeyValueSum = 0;
		if(root.right != null)
			moreKeyValueSum = countSum(root.right); 
		
		TreeNode node = new TreeNode(i + moreKeyValueSum + root.val);
		if(root.left != null) {
			node.left = recursion(root.left, i + moreKeyValueSum + root.val);
		}
		if(root.right != null) {
			node.right = recursion(root.right, 0);
		}
		return node;
	}

	private int countSum(TreeNode root) {
		int sum = root.val;
		if(root.left != null)
			sum += countSum(root.left);
		if(root.right != null)
			sum += countSum(root.right);
		return sum;
	}
}
