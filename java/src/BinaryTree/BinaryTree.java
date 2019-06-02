package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import BinaryTree.BinaryTree.HeapMax;

//import BinaryTree.BinaryTree.Pair;

public class BinaryTree {

	private class Node {
		Node left, right;
		int data;

		@Override
		public String toString() {
			return this.data+" ";
		}
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	Node root;
//	50 true 60 true 40 true 30 false false true 35 false false true 45 false false true 70 false false

	public BinaryTree() {
		this.root = construct(new Scanner(System.in), null, -1);
	}

	public BinaryTree(int pre[], int in[]) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int pre_l, int pre_h, int[] in, int in_l, int in_h) {
		if (pre_l > pre_h) {
			return null;
		}
		Node nn = new Node(pre[pre_l]);
		int si = -1;
		for (int i = in_l; i <= in_h; i++) {
			if (in[i] == pre[pre_l]) {
				si = i;
				break;
			}
		}
		int nel = si - in_l;
		nn.left = construct(pre, pre_l + 1, pre_l + nel, in, in_l, si - 1);
		nn.right = construct(pre, pre_l + nel + 1, pre_h, in, si + 1, in_h);
		return nn;
	}

	private Node construct(Scanner sc, Node parent, int right) {
		if (parent == null)
			System.out.println("Please enter the data for parent root");
		else
			System.out.println("Enter " + (right == 1 ? "right" : "left") + "child data of " + parent.data);
		Node nn = new Node(sc.nextInt());
		System.out.println("Is " + nn.data + " have left child?");
		if (sc.nextBoolean()) {
			nn.left = construct(sc, nn, 0);
		}

		System.out.println("Is " + nn.data + " have right child?");
		if (sc.nextBoolean()) {
			nn.right = construct(sc, nn, 1);
		}

		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node root) {
		if (root == null)
			return;
		String str = "";
		if (root.left != null)
			str += root.left.data;
		str += " <- " + root.data + " ->";
		if (root.right != null)
			str += root.right.data;
		System.out.println(str);
		display(root.left);
		display(root.right);

	}

	public int height() {
		return height(this.root);
	}

	private int height(Node root) {
		if (root == null)
			return -1;
		int ht = -1;
		int hl = height(root.left);
		if (hl > ht)
			ht = hl;
		int hr = height(root.right);
		if (hr > ht)
			ht = hr;
		return ht + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node root) {
		int max = root.data;

		if (root.left != null) {
			int max_l = max(root.left);
			if (max_l > max)
				max = max_l;
		}
		if (root.right != null) {
			int max_r = max(root.right);
			if (max_r > max) {
				max = max_r;
			}
		}
		return max;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node root, int data) {
		if (root.data == data)
			return true;

		if (root.left != null && find(root.left, data))
			return true;

		if (root.right != null && find(root.right, data))
			return true;

		return false;

	}

	public int diameter() {
		return diameter(this.root);
	}

	public int diameter(Node root) {
		if (root == null)
			return 0;
		int ld = diameter(root.left);
		int rd = diameter(root.right);
		int md = height(root.left) + height(root.right) + 2;
		return Math.max(ld, Math.max(rd, md));

	}

	private class Pair {
		public int height, diameter;
	}

	public int diameterPair() {
		return diameterPair(this.root).diameter;
	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " -> ");
		preorder(root.left);
		preorder(root.right);

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node root) {
		if (root == null)
			return;
		postorder(root.left);
		System.out.print(root.data + " -> ");
		;
		postorder(root.right);
	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		inorder(root.right);
		System.out.print(root.data + " -> ");
	}

	private Pair diameterPair(Node root) {
		if (root == null) {
			Pair br = new Pair();
			br.diameter = 0;
			br.height = -1;
			return br;
		}
//		System.out.println(ans++);
		Pair left = diameterPair(root.left);
		Pair right = diameterPair(root.right);
		Pair mr = new Pair();
		mr.height = Math.max(left.height, right.height) + 1;

		mr.diameter = Math.max(left.height + right.height + 2, Math.max(left.diameter, right.diameter));

		return mr;
	}

	public int deepestNode() {
		LinkedList<Node> queue = new LinkedList<BinaryTree.Node>();
		queue.addLast(this.root);
		LinkedList<Node> helper = new LinkedList<BinaryTree.Node>();
		Node top = this.root;
		while (!queue.isEmpty()) {
			top = queue.removeFirst();
			if (top.left != null)
				helper.addLast(top.left);
			if (top.right != null) {
				helper.addLast(top.right);
			}

			if (queue.isEmpty()) {
				queue = helper;
				helper = new LinkedList<BinaryTree.Node>();
			}
		}
		return top.data;
	}

	public boolean isBalancedTree() {
		return isBalancedTree(this.root).balance;
	}

	private class PairBal {
		boolean balance;
		int height;

		public PairBal() {
			balance = false;
			height = -1;
		}

	}

	private PairBal isBalancedTree(Node root) {
		if (root == null) {
			PairBal br = new PairBal();
			br.balance = true;
			br.height = -1;
			return br;
		}

		PairBal left = isBalancedTree(root.left);
		PairBal right = isBalancedTree(root.right);

		PairBal mr = new PairBal();
		mr.height = Math.max(left.height, right.height) + 1;
		int ans = Math.abs(left.height - right.height);
		if (left.balance && right.balance && ans <= 1) {
			mr.balance = true;
		} else {
			mr.balance = false;
		}

		return mr;
	}

	class PreOrderPair {
		boolean selfDone, leftDone, rightDone;
		Node node;

		PreOrderPair(Node node) {
			this.selfDone = false;
			this.rightDone = false;
			this.leftDone = false;
			this.node = node;
		}

	}

	public void preOrderIter() {
		LinkedList<PreOrderPair> stack = new LinkedList<>();
		stack.addFirst(new PreOrderPair(this.root));
		while (!stack.isEmpty()) {
			PreOrderPair top = stack.getFirst();
			if (!top.selfDone) {
				System.out.print(top.node.data + " ");
				top.selfDone = true;
			} else if (!top.leftDone) {
				if (top.node.left != null) {
					stack.offerFirst(new PreOrderPair(top.node.left));
				}
				top.leftDone = true;
			} else if (!top.rightDone) {
				if (top.node.right != null) {
					stack.offerFirst(new PreOrderPair(top.node.right));
				}
				top.rightDone = true;
			} else {
				stack.removeFirst();
			}

		}
	}

	private class BSTPair {
		int max, min, size;
		boolean isBST;
		Node largeNode;

		public BSTPair(Node node) {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
			this.size = 0;
			this.largeNode = node;
			this.isBST = true;
		}
	}

	public void printLargeBst() {
		BSTPair bt = getLargeBSTNode(this.root);
		System.out.println("ANS is " + bt.largeNode.data + "\n" + bt.size);
	}

	private BSTPair getLargeBSTNode(Node node) {

		if (node == null) {
			return new BSTPair(node);
		}

		BSTPair left = getLargeBSTNode(node.left);
		BSTPair right = getLargeBSTNode(node.right);
		BSTPair mr = new BSTPair(node);

		if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
			mr.max = Math.max(node.data, Math.max(right.max, left.max));
			mr.min = Math.min(node.data, Math.min(left.min, right.min));
			mr.isBST = true;
			mr.largeNode = node;
			mr.size = left.size + right.size + 1;
		} else {

			if (left.size > right.size) {
				mr = left;
			} else {
				mr = right;
			}
			mr.isBST = false;
		}

		return mr;
	}

	public void insert(int data) {
		insert(this.root, data);
	}

	public int leavesInTree() {
		int ans = 0;
		LinkedList<Node> queue = new LinkedList<BinaryTree.Node>();
		queue.addLast(this.root);
		Node top;
		while (!queue.isEmpty()) {
			top = queue.removeFirst();
			if (this.isLeaf(top)) {
//				System.out.println(top.data);
				ans++;
				continue;
			}
			if (top.left != null)
				queue.addLast(top.left);
			if (top.right != null) {
				queue.addLast(top.right);
			}

		}
		return ans;

	}

	public void printPath() {
		printPath(this.root, "");
	}

	private void printPath(Node node, String ans) {
		if (node.left == null && node.right == null) {
			System.out.println(ans + node.data);
			return;
		}
		if (node == null)
			return;

		printPath(node.left, ans + node.data + "->");
		printPath(node.right, ans + node.data + "->");

	}

	public void printPathWithSum(int target) {
		printPathWithSum(this.root, "", 0, target);
	}

	private void printPathWithSum(Node node, String ans, int curr, int target) {
		if (node.left == null && node.right == null) {
			if (curr + node.data == target) {
				System.out.println(ans + node.data);
			}
			return;
		}
		if (node == null)
			return;

		this.printPathWithSum(node.left, ans + node.data + "->", curr + node.data, target);
		this.printPathWithSum(node.right, ans + node.data + "->", curr + node.data, target);

	}

	public boolean isLeaf(Node node) {
		return !(node.left != null && node.right != null);
	}

	class HeapMax {
		int max, min;

		public HeapMax() {
			this.max = 0;
			this.min = 0;
		}
	}

	public void printVertical() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HeapMax max = printVertical(this.root, map, 0);
		for(int i=max.min;i<=max.max;i++) {
			System.out.println(map.get(i));
		}
	}

	private HeapMax printVertical(Node node, HashMap<Integer, String> map, int c) {

		HeapMax left, right;
		left = new HeapMax();
		right = new HeapMax();
		if (node.left != null) {
			left = printVertical(node.left, map, c - 1);
		}
		if (node.right != null) {
			right = printVertical(node.right, map, c + 1);
		}

		String data = "";
		if (map.containsKey(c)) {
			data = map.get(c);
		}
		data += node.data + " ";
		map.put(c, data);

		HeapMax mr = new HeapMax();

		mr.max = Math.max(c, Math.max(right.max, left.max));
		mr.min = Math.min(c, Math.min(right.min, left.min));
		return mr;
	}

	private void insert(Node node, int data) {
		if (node.left == null) {
			node.left = new Node(data);
			return;
		} else if (node.right == null) {
			node.right = new Node(data);
			return;
		}

		if (this.height(node.left) <= this.height(node.right)) {
			insert(node.left, data);
			return;
		} else {
			insert(node.right, data);
			return;
		}
	}

	public void insertIter(int data) {
		if (this.root == null) {
			this.root = new Node(data);
			return;

		}
		LinkedList<Node> stack = new LinkedList<BinaryTree.Node>();
		stack.addFirst(this.root);
		while (!stack.isEmpty()) {
			Node top = stack.getFirst();
			if (top.left == null) {
				top.left = new Node(data);
				return;
			} else {
				stack.addFirst(top.left);
			}

			if (top.right == null) {
				top.right = new Node(data);
				return;
			} else {
				stack.addFirst(top.right);
			}
		}

	}

	public ArrayList<Node> generate(int n) {
		if(n==0)
			return generate(1,0);
		return generate(1,n);
	}
	
	
	private ArrayList<Node> generate(int si, int ei) {
		
		ArrayList<Node> TreeList=new ArrayList<BinaryTree.Node>();
		if(si>ei) {
			TreeList.add(null);
			return TreeList;
			
		}
		
		for(int i=si;i<=ei;i++) {
			for(Node left:generate(si,i-1)) {
				for(Node right:generate(i+1,ei)) {
					Node nn=new Node(i);
					nn.left=left;
					nn.right=right;
					TreeList.add(nn);
				}
			}
		}
		
		
		
		
		return TreeList;
	}

	public static void main(String[] args) {
//		BinaryTree bt = new BinaryTree();
//		bt.display();
//		System.out.println(bt.height());
//		System.out.println(bt.max());
//		System.out.println(bt.find(7540));
		int pre[] = { 50, 42, 40, 30, 41, 45, 1 };
		int in[] = { 30, 40, 41, 42, 45, 50, 1 };
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameterPair());
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
//		bt.preorder();
//		System.out.println();
//		bt.postorder();
//		String str = "123 456";
//		Integer.parseInt(str.substring(0, str.indexOf(' ')));
//		System.out.println();
//		bt.inorder();
//		System.out.println(bt.isBalancedTree());
//		bt.preOrderIter();
//		System.out.println();
//		bt.printLargeBst();
//		bt.insert(71);
//		bt.insert(72);
//		bt.insert(73);
//		System.out.println();
//		bt.insertIter(9856);
//
//		bt.display();
//		System.out.println(bt.deepestNode());
//		System.out.println(bt.leavesInTree());
//		bt.printPath();
//		bt.printPathWithSum(51);
//		bt.printVertical();
//		System.out.println(bt.generate(3));
		ArrayList<Node> list=bt.generate(20);
		for(Node n:list) {
			
			System.out.println();
			bt.display(n);
		}

	}
}
