/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class IncreasingOrderSearchTree {
	/*
	 * Leetcode 897
	 * In this problem, we will use recursion to get inorder traversal
	 */
	public TreeNode ans = null;
	public List<Integer> InOrder = new ArrayList<Integer>();
	public TreeNode increasingBST(TreeNode root) {
        recursion(root);
        TreeNode ans = new TreeNode();
        ans.val = InOrder.get(0);
        ans.left = null;
        ans.right = null;
        TreeNode start = ans;
        for(int i = 1; i < InOrder.size(); i++) {
        	TreeNode temp = new TreeNode();
        	temp.val = InOrder.get(i);
        	temp.left = temp.right = null;
        	start.right = temp;
        	start = start.right;
        }
        
        return ans;
    }
	private void recursion(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		recursion(root.left);
		InOrder.add(root.val);
		recursion(root.right);
	}
}
