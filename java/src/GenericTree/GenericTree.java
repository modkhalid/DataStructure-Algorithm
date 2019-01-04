package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
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
	
	void display() {
		display(this.root);
	}
	
	int Size() {
		return Size(this.root);
	}
	
	private int Size(Node node) {
		int res=0;
		for(Node child:node.children) {
			res+=Size(child);
		}
		return res+1;
	}
	
	int max() {
		return max(this.root);
	}
	
	private int max(Node node) {

		int m=node.data;
		for(Node child:node.children) {
			int temp=max(child);
			if(temp>=m)
				m=temp;
		}
		return m;
	}

	public boolean find(int data) {
		return find(this.root,data);
	}
	
	private boolean find(Node node, int data) {
		if(node.data==data)
			return true;
		for(Node child:node.children) {
			boolean temp=find(child,data);
			if(temp)
				return temp;
		}
		return false;
	}
	
	public int height() {
		return height(this.root);
	}
	
	private int height(Node node) {
		int ht=-1;
		for(Node child:node.children) {
			int ch=height(child);
			if(ch>ht)
				ht=ch;
		}
		return ht+1;
	}
	
	public void mirror() {
		mirror(this.root);
	}
	private void mirror(Node node) {
		for (int i = 0; i < node.children.size()/2; i++) {
			Node temp1=node.children.get(i);
			Node temp2=node.children.get(node.children.size()-1-i);
			node.children.set(i, temp2);
			node.children.set(node.children.size()-1-i, temp1);			
		}
		for(Node child:node.children) {
			mirror(child);
		}
		
	}

	
	public boolean structuallySimilar(GenericTree gt) {
		return structuallySimilar(this.root,gt.root);
	}
	
	private boolean structuallySimilar(Node th, Node ot) {
		if(th.children.size()!=ot.children.size()) {
			return false;
		}
		boolean flag=true;
		for(int i=0;i<th.children.size();i++) {
			flag=structuallySimilar(th.children.get(i), ot.children.get(i));
			if(!flag) {
				return flag;
			}
		}
		return flag;
	}
	
	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		System.out.print(node.data+" ");
		for(Node child:node.children) {
			preorder(child);
		}
	}
	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {
		for(Node child:node.children) {
			preorder(child);
		}
		System.out.print(node.data+" ");
	}
	
	public void levelorder() {
		LinkedList<Node> queue=new LinkedList<>();
		queue.addLast(this.root);
		while(!queue.isEmpty()) {
			Node temp=queue.removeFirst();
			System.out.print(temp.data+" ");
			for(Node child:temp.children) {
				queue.addLast(child);
			}
		}
	}

	private void display(Node node) {
		String str=node.data+" -> ";
		for (int i = 0; i < node.children.size(); i++) {
			str+=node.children.get(i).data+" , ";
		}
		System.out.println(str);
		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 
	 ||||||||||||||||||||
	 ||                ||
	 ||                ||
	 ||                ||
	 ||                ||
	 ||      main      ||
	 ||                ||
	 ||                ||
	 ||                ||
	 ||||||||||||||||||||
	 
	 */
	
	
	
	
	
	public static void main(String[] args) {
//		5 3 1 0 2 0 3 2 12 0 35 0
		GenericTree g=new GenericTree();
		g.display();
//		System.out.println(g.Size());
//		System.out.println(g.max());
//		System.out.println(g.find(35));
//		System.out.println(g.find(36));
//		System.out.println(g.height());
//		g.mirror();
//		g.display();
//		GenericTree g2=new GenericTree();
//		g2.display();
//		System.out.println(g.structuallySimilar(g2));
//		g.preorder();
		g.levelorder();
	}
}
