package GenericTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

//  25 3 18 3 1 0 2 0 3 0 19 0 20 2 7 2 9 0 8 1 11 0 25 0
public class Trees {
	class Node {
		int data;
		ArrayList<Node> children;

		public Node(int data) {
			this.data = data;
			children = new ArrayList<Trees.Node>();
		}

	}

	Node root;
	int size;

	public Trees() {
		this.root = construct(new Scanner(System.in), null, -1);
	}

	private Node construct(Scanner sc, Node parent, int ith) {
		/*
		 * if(ith==-1) System.out.println("Pleas Enter data for Root Node"); else
		 * System.out.println("Enter data for  of "+ith+" child of "+parent.data+" ");
		 */int n = sc.nextInt();

		Node nn = new Node(n);
		// System.out.println("Enter Number of children");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			nn.children.add(construct(sc, nn, i + 1));
		}

		return nn;

	}

	public void display() {
		display(this.root);
	}

	public int size() {
		return size(this.root);
	}

	private int size(Node root) {
		int size = 0;
		for (Node child : root.children)
			size += size(child);
		return size + 1;
	}

	private void display(Node root) {
		String str = root.data + " -> ";
		for (Node child : root.children)
			str += child.data + ", ";

		System.out.println(str);
		for (Node child : root.children)
			display(child);

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node root) {
		int max = root.data;
		for (Node child : root.children) {
			int x = max(child);
			if (x > max)
				max = x;
		}

		return max;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node root, int data) {
		if (root.data == data)
			return true;
		boolean flag = false;
		for (Node child : root.children) {
			flag = find(child, data);
			if (flag)
				return true;
		}
		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node root) {
		int ht = -1;
		for (Node child : root.children) {
			int th = height(child);
			if (th > ht)
				ht = th;
		}
		return ht + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node root) {
		int x = root.children.size();
		for (int i = 0; i < x / 2; i++) {
			Node temp = root.children.get(i);
			root.children.set(i, root.children.get(x - 1 - i));
			root.children.set(x - 1 - i, temp);

		}

		for (Node child : root.children) {
			mirror(child);
		}
	}

	public boolean structurallySimilar(Trees t) {
		return structurallySimilar(this.root, t.root);
	}

	private boolean structurallySimilar(Node root, Node other) {
		if (root.children.size() != other.children.size())
			return false;
		for (int i = 0; i < root.children.size(); i++) {
			if (!structurallySimilar(root.children.get(i), other.children.get(i)))
				return false;
		}
		return true;
	}

	public void preorder() {
		System.out.println("preorder of the tree is : ");
		preorder(this.root);
	}

	private void preorder(Node root) {
		System.out.print(root.data + " ");
		for (Node child : root.children)
			preorder(child);
	}

	public void postorder() {
		System.out.println("preorder of the tree is : ");
		postorder(this.root);
	}

	private void postorder(Node root) {

		for (Node child : root.children)
			postorder(child);
		System.out.print(root.data + " ");
	}

	public void levelOrder() {
		LinkedList<Node> stack = new LinkedList<Trees.Node>();
		stack.addFirst(this.root);

		while (!stack.isEmpty()) {
			Node pop = stack.removeFirst();
			System.out.print(pop.data + " ");
			for (Node child : pop.children) {
				stack.addLast(child);
			}
		}

	}

	public void levelOrderZicZac() {
		LinkedList<Node> st = new LinkedList<Trees.Node>();
		LinkedList<Node> temp = new LinkedList<Trees.Node>();
		st.addFirst(this.root);
		int count = 1;
		while (!st.isEmpty()) {
			Node pop = st.removeFirst();
			System.out.print(pop.data + " ");

			if (count == 0) {
				for (int i = 0; i < pop.children.size(); i++) {
					temp.addFirst(pop.children.get(pop.children.size() - 1 - i));
				}
			} else {
				for (Node child : pop.children)
					temp.addFirst(child);
			}

			if (st.isEmpty()) {
				st = temp;
				temp = new LinkedList<Trees.Node>();
				System.out.println();
				count = (count + 1) % 2;
			}
		}
	}

	public void levelOrderLine() {
		LinkedList<Node> st = new LinkedList<Trees.Node>();
		LinkedList<Node> temp = new LinkedList<Trees.Node>();
		st.addFirst(this.root);
		while (!st.isEmpty()) {
			Node pop = st.removeFirst();
			System.out.print(pop.data + " ");

			for (Node child : pop.children)
				temp.addLast(child);

			if (st.isEmpty()) {
				st = temp;
				temp = new LinkedList<Trees.Node>();
				System.out.println();
			}
		}
	}

	static int ans = -1;

	public int predessor(int item) {
		return predessor(this.root, item);
	}

	private int predessor(Node root, int item) {
		if (root.data == item)
			return ans;
		ans = root.data;
		for (Node child : root.children) {
			int sol = predessor(child, item);
			if (sol != -1)
				return sol;
		}
		return -1;

	}

	public int succedor(int item) {
		ans = -1;
		return succedor(this.root, item);
	}

	private int succedor(Node root, int item) {
		if (ans == 0)
			return root.data;
		if (root.data == item)
			ans = 0;
		for (Node child : root.children) {
			int sl = succedor(child, item);
			if (sl != -1)
				return sl;
		}
		return -1;
	}

	private class NodePair {
		Node node;
		boolean selfDone;
		boolean childrenDone;

		public NodePair(Node node) {
			this.node = node;
			this.selfDone = false;
			this.childrenDone = false;
		}

		public void setSelf() {
			this.selfDone = true;
		}

		public void setChild() {
			this.childrenDone = true;
		}

		public boolean isSelfDone() {
			return this.selfDone;
		}

		public boolean isChildDone() {
			return this.childrenDone;
		}
	}

	public void preorderItratively() {
		LinkedList<NodePair> stack = new LinkedList<Trees.NodePair>();
		stack.addFirst(new NodePair(this.root));

		while (!stack.isEmpty()) {
			NodePair top = stack.getFirst();

			if (!top.isSelfDone()) {
				System.out.print(top.node.data + " ");
				top.setSelf();
			} else if (!top.isChildDone()) {
				ArrayList<Node> child = top.node.children;
				for (int i = child.size() - 1; i >= 0; i--) {
					stack.addFirst(new NodePair(child.get(i)));
				}
				top.setChild();
			} else {
				stack.removeFirst();
			}

		}
	}

	public static void main(String[] args) {
		Trees t = new Trees();
		t.display();
//		System.out.println("the size of tree is " + t.size());
//		System.out.println(t.max());
//		System.out.println(t.find(856));
//		System.out.println(t.height());
//		t.mirror();
//		t.display();
//		System.out.println(t.structurallySimilar(t));
//		t.preorder();
//		t.postorder();
//		t.levelOrder();
//		t.levelOrderLine();
//		t.levelOrderZicZac();
//		System.out.println(t.predessor(3));
//		System.out.println(t.succedor(11));
		t.preorderItratively();

	}

}
