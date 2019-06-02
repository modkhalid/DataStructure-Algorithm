package graph;

import java.util.LinkedList;

public class Graph {
	int size;
	LinkedList<Integer> []adjVer;
	
	public Graph() {
		this(5);
	}
	
	
	@SuppressWarnings("unchecked")
	public Graph(int cap) {
		this.size=cap;
		this.adjVer=new LinkedList[cap];
		for (int i = 0; i < this.size; i++) {
			this.adjVer[i]=new LinkedList<>();
		}
	}
	public void insert(int u,int v,boolean bidir) {
		this.adjVer[u].addLast(v);
		
		if(bidir) {
			this.adjVer[v].addLast(u);
		}
	}
	
	
	public void print() {
		for(int i=0;i<this.size;i++) {
			System.out.print(i+" -> ");
			
			for(int a:this.adjVer[i]) {
				System.out.print(a+",");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Graph g=new Graph();
		g.insert(0, 3, true);
		g.insert(0, 1, true);
		g.insert(0, 2, true);
		g.insert(3, 4, true);
		g.print();
	}
}
