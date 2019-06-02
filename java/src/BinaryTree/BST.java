package BinaryTree;

public class BST {
	private class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public BST(int in[]) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int in_l, int in_h) {
		if (in_l > in_h) {
			return null;
		}
		int mid = (in_l + in_h) / 2;
		Node nn = new Node(in[mid]);

		nn.left = construct(in, in_l, mid - 1);
		nn.right = construct(in, mid + 1, in_h);
		return nn;
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node root) {
		if (root == null)
			return;

		postorder(root.left);

		postorder(root.right);

		System.out.print(root.data + " ");
	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	private void display(Node root) {

		if (root == null) {
			return;
		}
		String str = "";
		if (root.left != null)
			str += root.left.data;
		str += " -> " + root.data + " <- ";
		if (root.right != null)
			str += root.right.data;

		System.out.println(str);
		if (root.left != null) {
			display(root.left);
		}
		if (root.right != null) {
			display(root.right);
		}

	}

	public void display() {
		display(this.root);
	}

	public void printInRange(int ll, int hh) {
		printInRange(this.root, ll, hh);
	}

	private void printInRange(Node root, int ll, int hh) {
		if (root == null)
			return;
		if (root.data >= ll && root.data <= hh) {
			printInRange(root.left, ll, hh);
			System.out.print(root.data + " ");
			printInRange(root.right, ll, hh);
		} else if (root.data < ll) {
			printInRange(root.right, ll, hh);
		} else if (root.data > hh) {
			printInRange(root.left, ll, hh);
		}
	}

	public void printDesendingOrder() {
		printDesendingOrder(this.root);

	}

	private void printDesendingOrder(Node root) {
		if (root == null)
			return;
		printDesendingOrder(root.right);
		System.out.print(root.data + " ");
		printDesendingOrder(root.left);
	}

	private class Heap {
		int sum;

		public Heap() {
			this.sum = 0;
		}
	}

	public void replaceWithSumLarger() {
		replaceWithSumLarger(this.root, new Heap());
	}

	private void replaceWithSumLarger(Node root, Heap mover) {
		if (root == null) {
			return;
		}

		replaceWithSumLarger(root.left, mover);
//		int temp=root.data;
		root.data += mover.sum;
		mover.sum = root.data;
		replaceWithSumLarger(root.right, mover);

	}

	public void deleteNode(int data) {
//		if (this.root != null && this.root.data == data) {
//			this.root = null;
//		}
		deleteNode(this.root, data, 0);
	}

	private void deleteNode(Node root, int data, int counter) {
		if (root == null)
			return;
		Node checkNode;
		int count = 0;
		if (root.data == data && counter == 0) {
			checkNode = root;
			count = -1;
		} else if (root.data <= data) {
			checkNode = root.right;
			count = 1;
		} else {
			checkNode = root.left;
		}
		if (checkNode == null)
			return;
		if (data == checkNode.data) {
			int number = getChildStatus(checkNode);
			switch (number) {
			case 0:
				if (count == -1) {
					this.root = null;
				} else if (count == 0) {
					root.left = null;
				} else {
					root.right = null;
				}
				break;

			case -1:
				if (count == -1) {
					this.root.left = root.left.left;
				} else if (count == 0) {
					root.left = root.left.left;
				} else {
					root.right = root.right.left;
				}
				break;

			case 1:
				if (count == -1) {
					this.root.left = root.left.right;
				} else if (count == 0) {
					root.left = root.left.right;
				} else {
					root.right = root.right.right;
				}
				break;
			default:
				Node node = checkNode.right;

				int min = this.min(node);
//				System.out.println(min);
				checkNode.data = min;
//				this.display();
				this.deleteNode(checkNode, min, 1);
				break;
			}

		} else {
			this.deleteNode(checkNode, data, 1);
		}

	}

	public int min() {
		return min(this.root);
	}

	private int min(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int min_l = min(root.left);
		int min_r = min(root.right);

		return Math.min(root.data, Math.min(min_l, min_r));
	}

	public int getChildStatus(Node node) {
		if (node.left != null && node.right != null)
			return 2;
		else if (node.left != null && node.right == null) {
			return -1;
		} else if (node.left == null && node.right != null) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BST bst = new BST(arr);
		bst.inorder();
		System.out.println();
//		System.out.println();
		bst.postorder();
		System.out.println();
		bst.display();

//		bst.deleteNode(9);
//		bst.deleteNode(3);
		bst.deleteNode(2);
		bst.deleteNode(5);
		System.out.println();
		bst.display();
//		bst.printInRange(5, 8);
//		bst.printDesendingOrder();
//		bst.replaceWithSumLarger();
//		bst.display();
//		bst.inorder();

	}
}
