/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class SubtreeOfAnotherTree {
	/*
	 * Leetcode 572
	 * This problem is solved using recursion as soon as two root vertices are same.
	 */
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		boolean isPresent = false;
        if(root.val == subRoot.val) {
        	isPresent = isEqual(root, subRoot);
        }
        if(isPresent) {
        	return isPresent;
        }
        
        if(root.left != null)
        	isPresent = isSubtree(root.left, subRoot);
        
        if(isPresent)
        	return isPresent;
        
        if(root.right != null) {
        	isPresent = isSubtree(root.right, subRoot);
        }
        
        return isPresent;
    }

	private boolean isEqual(TreeNode root, TreeNode subRoot) {
		boolean isEqualValue = false;
		if((root == null) && (subRoot == null))
			return true;
		if((root != null) && (subRoot != null)) {
			if(root.val == subRoot.val) {
				return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
			}
			else {
				return false;
			}
		}
		return false;
	}
}
