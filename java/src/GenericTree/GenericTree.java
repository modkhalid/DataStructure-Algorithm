package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	private class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	Node root;
	int size;
	public GenericTree() {
		this.root=construct(new Scanner(System.in),null,-1);
		
	}
	private Node construct(Scanner sc, Node node, int ith) {
		if(node==null) {
			System.out.println("Please enter the data for the root node");
		}else {
			System.out.println("Enter the data of "+ith+" node of "+node.data);
		}
		int data=sc.nextInt();
		Node nn=new Node();
		nn.data=data;
		System.out.println("please enter the Number of children for the Node "+data);
		int noc=sc.nextInt();
		for (int i = 0; i < noc; i++) {
			nn.children.add(construct(sc, nn, i));
		}
		
		return nn;
	}
	public static void main(String[] args) {
		GenericTree g=new GenericTree();
	}
}
















