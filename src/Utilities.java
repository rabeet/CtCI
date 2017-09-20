import java.util.Random;

public class Utilities {
	
	static class Node {
		
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
		Random random = new Random();
		Node node = new Node(random.nextInt(limit));
		Node ret = node;
		for (int i = 1; i < limit; i++) {
			node.next = new Node(random.nextInt(limit));
			node = node.next;
		}
		return ret;
	}
}