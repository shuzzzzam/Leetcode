/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class BinarySearchTreeToGreaterSearchTree {
	/*
	 * Leetcode 1038
	 * In this problem we will make use of inorder traversal.
	 */
	public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }
    int sum=0;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.right);
        sum+=root.val;
        root.val=sum;
        inorder(root.left);
    }
}
