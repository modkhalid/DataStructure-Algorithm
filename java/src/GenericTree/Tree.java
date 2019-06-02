package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.LinkedList;

public class Tree {
	Node root;
	private int size;

	class Node {
		ArrayList<Node> children = new ArrayList<Tree.Node>();
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public Tree() {
		Scanner sc = new Scanner(System.in);
		this.root = Tree(null, sc, 0);
	}

	private Node Tree(Node root, Scanner sc, int count) {
		if (root == null) {
			System.out.println("DATA :");
		} else {
			System.out.println("DATA (" + count + "," + root.data + ")");
		}
		int data = sc.nextInt();
		Node nn = new Node(data);
		System.out.println("Num " + data);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			nn.children.add(Tree(nn, sc, i + 1));
		}
		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node root) {
		String str = root.data + "->";
		for (Node child : root.children) {
			str += " " + child.data;
		}
		System.out.println(str);
		for (Node child : root.children) {
			display(child);
		}

	}

//	5 3 12 0 13 0 14 3 12 0 18 0 65 0
	public int size() {
		return size(this.root);
	}

	private int size(Node root) {
//		if (root.children.size() == 0)
//			return 1;
		int ans = 0;
		for (Node child : root.children)
			ans += size(child);
		return ans + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node root) {
		int max = Integer.MIN_VALUE;

		for (Node child : root.children) {
			int ans = max(child);
			if (max < ans)
				max = ans;
		}
		return Math.max(root.data, max);
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	/*
	 * 
	 * 5 12 13 14 12 18 65
	 * 
	 * 
	 */

	private boolean find(Node root, int data) {
		if (root.data == data)
			return true;
		for (Node child : root.children) {
			if (find(child, data)) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node root) {
		int height = -1;
		for (Node child : root.children) {
			int temp = height(child);
			if (height < temp)
				height = temp;
		}
		return height + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node root) {

		int n = root.children.size();
		for (int i = 0; i < n / 2; i++) {
			Node first = root.children.get(i);
			Node last = root.children.get(n - 1 - i);
			root.children.set(i, last);
			root.children.set(n - 1 - i, first);
		}
		for (Node child : root.children) {
			mirror(child);
		}
	}

	public boolean structuralySimilar(Tree t) {
		return structuralySimilar(this.root, t.root);
	}

	private boolean structuralySimilar(Node tr, Node or) {
		if (tr.children.size() != or.children.size())
			return false;
		boolean flag = true;
		for (int i = 0; i < tr.children.size(); i++) {
			flag = structuralySimilar(tr.children.get(i), or.children.get(i));
			if (!flag)
				return flag;
		}
		return flag;
	}

	public void preorder() {
		preorder(this.root, null);
	}

	private void preorder(Node root, Node ch) {
		if (ch == null)
			System.out.println(root.data);
		else
			System.out.print(ch.data + " -> " + root.data + " \\");

		for (Node child : root.children) {
			preorder(child, root);
		}
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node root) {
		for (Node child : root.children) {
			postorder(child);
		}
		System.out.print(root.data + " ");
	}

	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<Tree.Node>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node nn = queue.removeFirst();
			System.out.print(nn.data + " ");
			for (Node child : nn.children) {
				queue.addLast(child);
			}
		}
	}

	public void levelOrderLine() {
		LinkedList<Node> queue = new LinkedList<Tree.Node>();
		queue.addLast(this.root);
		LinkedList<Node> sl = new LinkedList<Tree.Node>();
		while (!queue.isEmpty()) {
			Node nn = queue.removeFirst();
			System.out.print(nn.data + " ");
			for (Node child : nn.children) {
				sl.addLast(child);
			}
			if(queue.isEmpty()) {
				queue=sl;
				sl=new LinkedList<Tree.Node>();
				System.out.println();
			}
		}
	}
	
	public void levelOrderZicZac() {
		LinkedList<Node> queue = new LinkedList<Tree.Node>();
		queue.addLast(this.root);
		LinkedList<Node> sl = new LinkedList<Tree.Node>();
		while (!queue.isEmpty()) {
			Node nn = queue.removeFirst();
			System.out.print(nn.data + " ");
			for (Node child : nn.children) {
				sl.addLast(child);
			}
			if(queue.isEmpty()) {
				queue=sl;
				sl=new LinkedList<Tree.Node>();
				System.out.println();
			}
		}
	}

	// 1 5 2 1 3 0 4 1 56 1 57 1 98 1 23 2 78 0 79 1 68 1 55 0 16 0 17 0 18 0
	public static void main(String[] args) {
		Tree t = new Tree();
		t.display();
//		Tree t2 = new Tree();
//		t2.display();
//		System.out.println(t.size());
//		System.out.println(t.max());
//		System.out.println(t.find(6545));
//		System.out.println(t.height());
//		t.mirror();
//		System.out.println();
//		t.display();
//		System.out.println(t.structuralySimilar(t2));
//		t.preorder();
//		System.out.println();
//		Queue<Node> que=new Queue<>();
//		LinkedList<Node> ll=new LinkedList<>();
//		t.levelorder();
//		System.out.println();
//		t.levelOrderLine();
//		System.out.println(t.height());
//		t.postorder();
	}
}
