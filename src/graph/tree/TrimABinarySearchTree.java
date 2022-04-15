/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class TrimABinarySearchTree {
	/*
	 * Leetcode 669
	 * In this problem, we will use recursion to trim the trees.
	 */
	TreeNode ans = null;
	public TreeNode trimBST(TreeNode root, int low, int high) {
        
        if(root.val >= low && root.val <= high) {
        	ans = root;//check at root level
        	recursion(root.left, low, high, root, 0);
        	recursion(root.right, low, high, root, 1);
        }
        else {
        	if(root.val < low) {
        		recursion(root.right, low, high, null, -1);//if root is not in the range, then it handles the corner case.
        	}
        	else {
        		recursion(root.left, low, high, null, -1);
        	}
        }
        
        return ans;
    }
	private void recursion(TreeNode currentNode, int low, int high, TreeNode root, int side) {
		if(currentNode == null)
			return;//base condition
		
		if(ans == null) {//If "ans" is not initialised means, there is no nodes with given range till now.
			if(currentNode.val >= low && currentNode.val <= high) {
				ans = currentNode;
				recursion(currentNode.left, low, high, currentNode, 0);//found the ans root node.
	        	recursion(currentNode.right, low, high, currentNode, 1);
			}
			else {
				if(currentNode.val < low) {
	        		recursion(currentNode.right, low, high, null, -1);//otherwise check recursively for ans root node.
	        	}
	        	else {
	        		recursion(currentNode.left, low, high, null, -1);
	        	}
			}
		}
		else {
			if(currentNode.val >= low && currentNode.val <= high) {//decision tree for condition if it has ans root node.
				recursion(currentNode.left, low, high, currentNode, 0);
	        	recursion(currentNode.right, low, high, currentNode, 1);
			}
			else {
				if(currentNode.val < low) {
					if(side == 0) {
						root.left = currentNode.right;
						recursion(root.left, low, high, root, 0);
					}
					else {
						root.right = currentNode.right;
						recursion(root.right, low, high, root, 1);
					}
				}
				else {
					if(side == 0) {
						root.left = currentNode.left;
						recursion(root.left, low, high, root, 0);
					}
					else {
						root.right = currentNode.left;
						recursion(root.right, low, high, root, 1);
					}
				}
			}
		}
		
	}
}
