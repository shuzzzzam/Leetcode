/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
	/*
	 * Leetcode 1008
	 * To do next 
	 */
	
	public TreeNode bstFromPreorder(int[] preorder) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < preorder.length; i++) {
			queue.add(preorder[i]);
		}
        return recursion(queue, 1001);
    }

	private TreeNode recursion(Queue<Integer> queue, int parentValue) {
		TreeNode root = new TreeNode();
		root.val = queue.poll();
		//index++;
		if((!queue.isEmpty()) &&  queue.peek() < root.val) {
			root.left = recursion(queue, root.val);
		}
		else {
			root.left = null;
		}
		
		if(root.val > parentValue) {
			if((!queue.isEmpty()) && queue.peek() > root.val) {
				root.right = recursion(queue, root.val);
			}
			else {
				root.right = null;
			}
		}
		else {
			if((!queue.isEmpty()) && queue.peek() < parentValue) {
				root.right = recursion(queue, root.val);
			}
			else {
				root.right = null;
			}
		}
		
		return root;
	}
}
