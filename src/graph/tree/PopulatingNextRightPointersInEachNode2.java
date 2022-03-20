/**
 * 
 */
package graph.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class PopulatingNextRightPointersInEachNode2 {
	/*
	 * Leetcode 117.
	 * In this problem, we used level order traversal to connect the nodes.
	 */
	
	public Node connectWithLevelOrderTraversal(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> queueLevel = new LinkedList<Integer>();
        
        queue.add(root);
        queueLevel.add(0);
        int currentLevel = 0;
        while(!queue.isEmpty()) {
        	Node currentNode = queue.poll();
        	int level = queueLevel.poll();
        	if(level == currentLevel) {
        		if((!queueLevel.isEmpty()) && queueLevel.peek() == level) {
        			currentNode.next = queue.peek();
        		}
        		else {
        			currentNode.next = null;
        		}
        	}
        	else {
        		currentLevel = level;
        		if((!queueLevel.isEmpty()) && queueLevel.peek() == level) {
        			currentNode.next = queue.peek();
        		}
        		else {
        			currentNode.next = null;
        		}
        	}
        	
        	if(currentNode.left != null) {
        		queue.add(currentNode.left);
        		queueLevel.add(level + 1);
        	}
        	
        	if(currentNode.right != null) {
        		queue.add(currentNode.right);
        		queueLevel.add(level + 1);
        	}
        }
        
        return root;
    }
}
