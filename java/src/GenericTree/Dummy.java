package GenericTree;

import java.util.*;
import java.lang.Math;
import java.io.*;



class Node {
	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

public class Dummy  {
	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] pre = new int[n];
			char[] preLN = new char[n];
			for (int i = 0; i < n; i++) {
				int b = sc.nextInt();
				pre[i] = b;
			}
			for (int i = 0; i < n; i++) {
				char c = sc.next().charAt(0);
				preLN[i] = c;
			}
			GFG obj = new GFG();
			Node root = obj.constructTree(n, pre, preLN);
			inorder(root);
			System.out.println();
		}
	}
}


/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * class Node{ int data; Node left,right; Node(int d) { data=d; left=right=null;
 * } }
 */
//Function should return the root of the formed binary tree.
//import java.util.*;

class GFG {
	Node constructTree(int n, int pre[], char preLN[]) {
		if (preLN[0] == 'L')
			return new Node(pre[0]);

		LinkedList<Node> stack = new LinkedList<>();
		Node curr = null;
		stack.addLast(new Node(pre[0]));

		int i = 1;
		while (!stack.isEmpty()) {

			if (i<=n && preLN[i] == 'N') {
				stack.addFirst(new Node(pre[i]));

			} else {
				Node pop = stack.getFirst();
				if (curr == null) {
					if (pop.left == null) {
						pop.left = new Node(pre[i]);

					} else {
						pop.right = new Node(pre[i]);
						curr = stack.removeFirst();
					}
				} else {
					pop.left = curr;
					if (i >= n) {
						pop.right = null;
						break;
					} else {
						pop.right = new Node(pre[i]);
					}
					curr = stack.removeFirst();
				}

			}
			i++;

		}
		return curr;
	}

}