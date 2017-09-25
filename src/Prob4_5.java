import java.util.Stack;

public class Prob4_5 {

	/*
	 * 4.5: Find the inorder successor of a node in a BST if every node has 
	 * a link to its parent
	 * inorder: left, self, right
	 * 
	 * if node.right is valid then node.right is the answer right?
	 * 
	 * 		5
	 * 	2		8
	 * 1  3   6
	 *     4
	 * 
	 * Inorder of the above is: 1,2,3,4,5,6,8
	 * 
	 * keep going to the parent until parent is null.
	 * That is your root. Do a simple inorder traversal from then until u
	 * get to the node u are looking for. the next node is the answer
	 * 
	 * A better solution is to: 
	 * find the parent of node
	 * node = parent
	 * do inorder from the node
	 * if node's prev is given_node then node is the ans.
	 * else node = parent.parent
	 * recurse
	 */
	public static void main(String[] args) {
		
	}
	
	public TreeNode inOrderSuccessor(TreeNode node) {
		if (node == null) return null;
		TreeNode parent = node.parent;
		while (parent != null) {
			parent = parent.parent;
		}
		
		return inOrder(parent, node);
	}
	
	public TreeNode inOrder(TreeNode node, TreeNode given) {
		
	}
}