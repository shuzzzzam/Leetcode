/**
 * 
 */
package graph.tree;

/**
 * @author fSociety
 *
 */
public class PopulatingNextRightPointersInEachNode {
	/*
	 * Leetcode 116
	 * Use recursion with O(n) time complexity.
	 */
	public Node connect(Node root) {
        if(root == null)
            return root;
        recursion(root);
        return root;
    }

	private void recursion(Node root) {
		
		if(root.left == null)//Base condition for leaf nodes.All the linking operations had been completed by it's predecessor.
			return;
		root.left.next = root.right;//Link left child to right child.
		if(root.next != null)
			root.right.next = root.next.left;//If current root node has next node, then link it's right child to next Node's left child.
		
		//Below is subsequent recursive call.
		recursion(root.left);
		recursion(root.right);
	}
}
