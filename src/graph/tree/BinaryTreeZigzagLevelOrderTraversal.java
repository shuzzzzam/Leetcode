/**
 * 
 */
package graph.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/*
	 * Leetcode 103
	 * Standard implementation of queue to level order traversal and for zig zag patter, use Collections.reverse() at seriallly.
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        int currentLevel = 0;
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueLevel = new LinkedList<Integer>();
        queueLevel.add(0);
        queueNode.add(root);
        
        int cycle = 0;
        List<Integer> list = new ArrayList<Integer>();
        while(!queueNode.isEmpty()) {
        	TreeNode node = queueNode.poll();
        	int level = queueLevel.poll();
        	if(level == currentLevel) {
        		list.add(node.val);
        	}
        	else {
        		if(cycle % 2 == 0)
        			ans.add(list);
        		else {
        			Collections.reverse(list);
        			ans.add(list);
        		}
        		list = new ArrayList<Integer>();
        		currentLevel = level;
        		list.add(node.val);
        		cycle++;
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
        if(cycle % 2 == 0)
        	ans.add(list);
        else {
        	Collections.reverse(list);
        	ans.add(list);
        }
        return ans;
    }
}
