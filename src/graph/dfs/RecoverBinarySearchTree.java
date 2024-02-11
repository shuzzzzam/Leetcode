/**
 * 
 */
package graph.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class RecoverBinarySearchTree {

	public void recoverTree(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		List<TreeNode> clone = new ArrayList<TreeNode>();
		inOrder(root, list, clone);
		Collections.sort(list, new Comparator<TreeNode>() {
			@Override
			public int compare(TreeNode o1, TreeNode o2) {
				return o1.val - o2.val;
			}

		});

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).val != clone.get(i).val) {
				list.get(i).val = (list.get(i).val + clone.get(i).val);
				clone.get(i).val = list.get(i).val - clone.get(i).val;
				list.get(i).val -= clone.get(i).val;
				break;
			}
		}
	}

	private void inOrder(TreeNode root, List<TreeNode> list, List<TreeNode> clone) {
		if (root == null)
			return;
		inOrder(root.left, list, clone);
		list.add(root);
		clone.add(root);
		inOrder(root.right, list, clone);
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
}
