import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Utilities {
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,5,null,3};
		System.out.println(TreeNode.deSerializeTree(arr));
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
	public TreeNode parent; // for 4.5
	public TreeNode (int data) {
		this.data = data;
	}
	
	
	public static TreeNode deSerializeTree(Integer[] arr) {
		if (arr == null) return null;
		return popNode(arr, 0);
	}
	
	private static TreeNode popNode(Integer[] arr, int i) {
		if (i >= arr.length) return null;
		TreeNode node = arr[i] == null ? null : new TreeNode(arr[i]);
		if (node == null) {
			// shift everything to the right one
			for (int k = i; k < arr.length-1; k++) {
				Integer temp = arr[k];
				arr[k] = arr[k+1];
				arr[k+1] = temp;
			}
			return node;
		}
		node.left = popNode(arr, 2*i+1);
		node.right = popNode(arr, 2*i+2);
		return node;
	
	}
	
	public String toString() {
		return toString(this);
	}
	
	public String toString(TreeNode node) {
		if (node == null) return "";
		String ans = ""+node.data+"\n";
		boolean temp = false;
		if (node.left != null) {
			ans += node.left.data+" ";
			temp = true;
		}
		if (node.right != null) {
			ans += node.right.data+" ";
			temp = true;
		}
		ans +=(!temp)?"NO CHILDREN\n":"\n";
		ans += toString(node.left);
		ans += toString(node.right);
		return ans;
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