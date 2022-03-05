/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fSociety
 *
 */
public class BinaryTreeLevelOrderTraversal2 {
	/*
	 * Leetcode 107
	 * In this Problem we will use queue to get levelOrderTraversal value of each node and then stack to keep in the order from bottom to top depending on the order asked in the question.
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();
        List<Integer> levelList = new ArrayList<Integer>();
        
        queueNode.add(root);
        levelQueue.add(0);
        int previousLevel = 0;
        while(!queueNode.isEmpty()) {
        	TreeNode presentNode = queueNode.poll();
        	int presentLevel = levelQueue.poll();
        	
        	if(presentLevel == previousLevel) {
        		levelList.add(presentNode.val);
        	}
        	else {
        		previousLevel = presentLevel;
        		stack.push(levelList);
        		levelList = new ArrayList<Integer>();
        		levelList.add(presentNode.val);
        	}
        	
        	if(presentNode.left != null) {
        		queueNode.add(presentNode.left);
        		levelQueue.add(presentLevel + 1);
        	}
        	
        	if(presentNode.right != null) {
        		queueNode.add(presentNode.right);
        		levelQueue.add(presentLevel + 1);
        	}
        }
        stack.push(levelList);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(!stack.isEmpty()) {
        	ans.add(stack.pop());
        }
        
        return ans;
    }
}
