
public class Prob4_6 {

	/*
	 * 4.6: Find the first common ancestor of two nodes in a bin tree. Avoid
	 * using additional nodes in a DS. A node can be an ancestor of itself
	 * right? YES.
	 */
	private static TreeNode found = null;
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		TreeNode node = TreeNode.serializeTree(arr);
		firstCommonAncestor(node, node.left, node.left.left);
		System.out.println(found.data);
	}

	public static void firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) return;
		

		firstCommonAncestor(root.left, a, b);
		firstCommonAncestor(root.right, a, b);
		if (found != null) return;
		boolean fa = find(root,a), fb = find(root,b);
		if (fa && fb) found = root;
	}

	private static boolean find(TreeNode root, TreeNode a) {
		if (root == null) return false;
		if (a == null) return false;
		return (root == a)? true: find(root.left, a) || find(root.right, a);
	}

}
