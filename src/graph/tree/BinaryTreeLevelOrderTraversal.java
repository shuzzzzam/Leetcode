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
public class BinaryTreeLevelOrderTraversal {
	/*
	 * Leetcode 102
	 * It is a standard queue implementaton to get Level order traversal.
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        int currentLevel = 0;
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueLevel = new LinkedList<Integer>();
        queueLevel.add(0);
        queueNode.add(root);
        
        List<Integer> list = new ArrayList<Integer>();
        while(!queueNode.isEmpty()) {
        	TreeNode node = queueNode.poll();
        	int level = queueLevel.poll();
        	if(level == currentLevel) {
        		list.add(node.val);
        	}
        	else {
        		ans.add(list);
        		list = new ArrayList<Integer>();
        		currentLevel = level;
        		list.add(node.val);
        	}
        	
        	if(node.left != null) {
        		queueNode.add(node.left);
        		queueLevel.add(level + 1);
        	}
        	
        	if(node.right != null) {
        		queueNode.add(node.right);
        		queueLevel.add(level + 1);
        	}
            
            
        }
        
        ans.add(list);
        return ans;
    }
}
