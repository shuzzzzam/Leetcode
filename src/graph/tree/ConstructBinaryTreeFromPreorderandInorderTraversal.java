/**
 * 
 */
package graph.tree;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class ConstructBinaryTreeFromPreorderandInorderTraversal {
	/*
	 * Leetcode 105
	 * In this problem , we make use of basic concept of inorder and postorder traversal to build the tree.
	 */
	public int rootIndex = 0; //This is to track the index for root tree, we know that preOrder will have root node for left & right subTree.
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return buildTreeStructure(preorder, inorder, 0, inorder.length - 1, map);//recursive call to build tree
    }
	private TreeNode buildTreeStructure(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
		if(!(start <= end) || rootIndex == preorder.length)
			return null;
		TreeNode root = new TreeNode();
		root.val = preorder[rootIndex];//We can deduce that preOrder will have root node value.
		rootIndex++;
		int inorderIndex = map.get(root.val);
		root.left = buildTreeStructure(preorder, inorder, start, inorderIndex - 1, map);
		root.right = buildTreeStructure(preorder, inorder, inorderIndex + 1, end, map);
		
		return root;
	}
}
