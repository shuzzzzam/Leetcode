/**
 * 
 */
package graph.bfs;

/**
 * @author fSociety
 *
 */
public class MergeTwoBinaryTrees {
	/*
	 * Leetcode 617
	 * This is a bfs question solved using recursion.
	 */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
        	return null;
        TreeNode node = new TreeNode();
        if((root1 != null) && (root2!= null)) {
        	node.val = (root1.val + root2.val);
        	node.left = mergeTrees(root1.left, root2.left);//Level order wise
        	node.right = mergeTrees(root1.right, root2.right);
        }
        else {
        	if(root1 != null) {
        		node.val = root1.val;
        		node.left = mergeTrees(root1.left, null);
        		node.right = mergeTrees(root1.right, null);
        	}
        	else {
        		node.val = root2.val;
        		node.left = mergeTrees(null, root2.left);
        		node.right = mergeTrees(null, root2.right);
        	}
        }
        return node;
        
    }
}
