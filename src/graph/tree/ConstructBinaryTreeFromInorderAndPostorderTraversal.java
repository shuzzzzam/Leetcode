/**
 * 
 */
package graph.tree;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public int rootIndex = 0; //This is to track the index for root tree, we know that postorder will have root node for left & right subTree.
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        rootIndex = postorder.length - 1;
        return buildTreeStructure(postorder, inorder, 0, inorder.length - 1, map);//recursive call to build tree
    }
	private TreeNode buildTreeStructure(int[] postorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
		if(!(start <= end) || rootIndex == -1)
			return null;
		TreeNode root = new TreeNode();
		root.val = postorder[rootIndex];//We can deduce that postorder will have root node value.
		rootIndex--;
		int inorderIndex = map.get(root.val);
		root.right = buildTreeStructure(postorder, inorder, inorderIndex + 1, end, map);
		root.left = buildTreeStructure(postorder, inorder, start, inorderIndex - 1, map);

		
		return root;
	}
}
