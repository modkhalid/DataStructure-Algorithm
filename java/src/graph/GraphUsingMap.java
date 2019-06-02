package graph;

import java.util.HashMap;

import generic.LinkedList;
//import ;

class Graph2<T>{
	HashMap<T, LinkedList<T>> map;
	
	public Graph2() {
		
	}
	public void insert(T u,T v,boolean bidir) {
		map.put(u, v);
	}
	
	public void dispay() {
		System.out.println("hi");
	}
	
}

public class GraphUsingMap {
	public static void main(String[] args) {
		Graph2<String> g=new Graph2();
		g.insert("Delhi", "mumba", true);
	}
}
