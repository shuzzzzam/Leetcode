/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class BinaryTreeRightSideView {
	/*
	 * Leetcode 199
	 * In this problem, we will use level order traversal and print the last node in that level
	 */
	 public List<Integer> rightSideView(TreeNode root) {
	        
	        Queue<TreeNode> objectQueue = new LinkedList<TreeNode>();
	        Queue<Integer> levelQueue = new LinkedList<Integer>();
	        List<Integer> list = new ArrayList<Integer>();
	        if(root == null)
	            return list;
	        objectQueue.add(root);
	        levelQueue.add(1);
	        while(!objectQueue.isEmpty()) {
	        	TreeNode getOut = objectQueue.poll();
	        	int level = levelQueue.poll();
	        	
	        	if(getOut.left != null) {
	        		objectQueue.add(getOut.left);
	        		levelQueue.add(level + 1);
	        	}
	        	if(getOut.right != null) {
	        		objectQueue.add(getOut.right);
	        		levelQueue.add(level + 1);
	        	}
	        	
	        	if(!(levelQueue.isEmpty()) && levelQueue.peek() != level) {
	        		list.add(getOut.val);
	        	}
	        	
	        	if(levelQueue.isEmpty())
	        		list.add(getOut.val);
	        }
	        
	        return list;
	    }
}
