package avl;

public class Avl {

	class Node {
		int data;
		Node left;
		Node right;
		int height;

		public Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	Node root;

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private Node insert(Node node, int data) {

		if (node == null) {
			return new Node(data);
		}

		if (node.data <= data) {
			node.right = insert(node.right, data);
		} else {
			node.left = insert(node.left, data);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		int bf = bancingFactor(node);
		
		// LL problem
		if (bf > 1 && data < node.left.data) {
			return rightRotate(node);
		}

//		RR problem
		if (bf < -1 && data > node.right.data) {
			return leftRotate(node);
		}
//		LR problem
		if(bf>1 && data>node.left.data) {
			node.left=leftRotate(node.left);//will get a node form c>b>a
			return rightRotate(node);
		}
		
//		RL rotation prblem
		
		if(bf<-1 && data<node.right.data) {
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	public Node rightRotate(Node c) {
		Node b = c.left;
		Node T3 = b.right;

		b.right = c;
		c.left = T3;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right));
		return b;

	}

	public Node leftRotate(Node c) {
		Node b = c.right;
		Node T3 = b.left;
		b.left = c;
		c.right = T3;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right));
		return b;
	}

	public int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	public int bancingFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void inorder() {
		inorder(this.root);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node == null)
			return;

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}
	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		// self work
		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " => " + node.data + " <= ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}
}
