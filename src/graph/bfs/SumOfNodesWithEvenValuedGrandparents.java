/**
 * 
 */
package graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author fSociety
 *
 */
public class SumOfNodesWithEvenValuedGrandparents {
	/*
	 * Leetcode 1315
	 */
	//This approach is Brute force and wastes computation on calculating grandchildren by calculating 1st gen parents.
	public int sumEvenGrandparentBruteForce(TreeNode root) {
		int sum = 0;
		// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<TreeNode> nodesQueue = new ArrayList<TreeNode>();
		ArrayList<Integer> nodesValue = new ArrayList<Integer>();
		nodesQueue.add(root);
		nodesValue.add(0);
		while (!nodesQueue.isEmpty()) {
			TreeNode node = nodesQueue.remove(0);
			int value = nodesValue.remove(0);
			if ((node.val % 2) == 0) {
				// map.put(value + 2, 1);
				sum += calculate(node);
			}
			// if(map.containsKey(value))
			// sum += node.val;
			if (node.left != null) {
				nodesQueue.add(node.left);
				nodesValue.add(value + 1);
			}
			if (node.right != null) {
				nodesQueue.add(node.right);
				nodesValue.add(value + 1);
			}
		}
		return sum;
	}

	private int calculate(TreeNode node) {
		// TODO Auto-generated method stub
		int sum = 0;
		ArrayList<TreeNode> nodesQueue = new ArrayList<TreeNode>();
		ArrayList<Integer> nodesValue = new ArrayList<Integer>();
		nodesQueue.add(node);
		nodesValue.add(0);
		while (!nodesQueue.isEmpty() && (nodesValue.get(0) < 3)) {
			TreeNode tmp_node = nodesQueue.remove(0);
			int value = nodesValue.remove(0);
			if (value == 2)
				sum += tmp_node.val;
			if (tmp_node.left != null) {
				nodesQueue.add(node.left);
				nodesValue.add(value + 1);
			}
			if (tmp_node.right != null) {
				nodesQueue.add(node.right);
				nodesValue.add(value + 1);
			}
		}
		return sum;
	}
	
	//In this approach, this is small and concise and makes use of recursion
	public int sumEvenGrandparent(TreeNode root) {
        if(root==null)return 0;
        int sum = 0;
        
        if(root.val % 2 == 0){
            if(root.left != null && root.left.left != null){
                sum += root.left.left.val;
            }
            if(root.left != null && root.left.right != null){
                sum += root.left.right.val;
            }
            if(root.right != null && root.right.left != null){
                sum += root.right.left.val;
            }
            if(root.right != null && root.right.right != null){
                sum += root.right.right.val;
            }
        }
        
        sum += sumEvenGrandparent(root.left);
        sum += sumEvenGrandparent(root.right);
        
        return sum;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}