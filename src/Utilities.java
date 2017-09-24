import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Utilities {
	
	static class Node {
		
	}

}

class DirectedNode {
	public int data;
	public List<DirectedNode> neighbors;
	public DirectedNode(int data) {
		this.data = data;
		neighbors = new ArrayList<DirectedNode>();
	}
	
	public void addNeighbor(DirectedNode d) {
		if (this.neighbors.contains(d)) return;
		this.neighbors.add(d);
	}
	
	public String toString() {
		String s = this.data+"->\n";
		for (DirectedNode d : neighbors) {
			s = s+"   "+d.data+"\n";
		}
		return s;
	}
	
	public String toString(DirectedNode node) {
		String s = node.data+"->\n";
		for (DirectedNode d : node.neighbors) {
			s = s+"   "+d.data+"\n";
		}
		return s;
	}
	
	private String getTree(DirectedNode node, Set<DirectedNode> set) {
		String ans = toString(node);
		set.add(node);
		for ( DirectedNode d : node.neighbors) {
			if (set.add(d))
				ans += getTree(d, set);
			else continue;
		}
		return ans;
	}
	
	public String getTree() {
		return getTree(this,new HashSet<DirectedNode>());
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