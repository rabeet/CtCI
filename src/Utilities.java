import java.util.Random;

public class Utilities {
	
	static class Node {
		
	}

}

class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (int data) {
		this.data = data;
	}
	
	public String toString() {
		return toString(this, 0);
	}
	
	public String toString(TreeNode node, int level) {
		if (node == null) return "";
		String spc = " ";
		for (int i = 0; i < level; i++) spc += " ";
		return ""+node.data+spc+toString(node.left,level+1)+toString(node.right, level+1);
	}
}

class Node {
	public int data;
	public Node next;
	public Node(int n) {
		this.data = n;
	}
	
	public String toString() {
		String s = ""+this.data;
		Node n = this;
		while (n.next != null) {
			n = n.next;
			s += "->"+n.data;
		}
		return s;
	}
	
	public static Node populateList(int limit) {
		limit = 9;
		Random random = new Random();
		Node node = new Node((limit));
		Node ret = node;
		for (int i = 1; i < 3; i++) {
			node.next = new Node((limit));
			node = node.next;
		}
		return ret;
	}
}