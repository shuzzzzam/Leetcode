/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class LowestCommonAncestorOfABinaryTree {
	/*
	 * Leetcode 236
	 * This problem is solved using Recursion to find Common Ancestor.
	 */
	TreeNode LCA = null;//It is declared null
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		recursion(root, p, q);
        return LCA;
    }
	private int recursion(TreeNode root, TreeNode p, TreeNode q) {
		int count = 0;
		if(root.val == p.val || root.val == q.val) 
			count = 1;
		if(root.left != null) {
			count += recursion(root.left, p, q);//Go to left subtree
		}
		if(root.right != null) {
			count += recursion(root.right, p, q);//Go to right subtree
		}
		
		if(count == 2) {
			if(LCA == null)//When first common ancestor is found, We have found the LCA
				LCA = root;
		}
		
		return count;
	}
}
