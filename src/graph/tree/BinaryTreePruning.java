/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class BinaryTreePruning {
	/*
	 * Leetcode 814
	 * In this method , we use recusrion to get subtree nodes which have atleast one One;
	 */
	public TreeNode pruneTree(TreeNode root) {
        if(!containsOne(root))//Recursive call
        	return null;
        return root;
    }

	private boolean containsOne(TreeNode root) {
		// TODO Auto-generated method stub
		boolean isPresentOneWhole = false;
		if(root == null)
			return isPresentOneWhole;
		
		boolean isPresentOneLeftSubtree = containsOne(root.left);
		if(!isPresentOneLeftSubtree)
			root.left = null;//Delete the subtree node
		boolean isPresentOneRightSubtree = containsOne(root.right);
		if(!isPresentOneRightSubtree)
			root.right = null; //Delete the subtree node.
		if(root.val == 1)
			isPresentOneWhole &= true;
		
		return isPresentOneWhole & isPresentOneLeftSubtree & isPresentOneRightSubtree;
			
	}
}
