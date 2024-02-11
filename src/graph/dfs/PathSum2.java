/**
 * 
 */
package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graph.tree.TreeNode;

/**
 * @author fSociety
 *
 */
public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		int sum = root.val;
		TreeNode start = root;
		if (start.right != null)
			stack.add(start.right);
		List<Integer> list = new ArrayList<Integer>();
		list.add(start.val);

		while (!stack.isEmpty() || (start != null)) {
			if (start.left != null) {
				if (start.right != null) {
					stack.add(start.right);
				}
				start = start.left;
				sum += start.val;
				list.add(start.val);
			} else if (start.right != null) {
				start = start.right;
				sum += start.val;
				list.add(start.val);
			} else {
				if (sum == targetSum) {
					List<Integer> newList = new ArrayList<Integer>(list);
					ans.add(newList);
				}

				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);

				if (stack.isEmpty())
					break;

				start = stack.pop();
			}
		}

		return ans;

	}

}
