package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {
	private ArrayList<Integer> data;
	
	public Heap(){
		this.data=new ArrayList<Integer>();
	}
	public void insert(int data) {
		this.data.add(data);
		upheapify(this.data.size()-1);
	}
	private void upheapify(int ci) {
//		if(ci<0)
//			return;
		int pi=(ci-1)/2;
//		System.out.println(this.data.get(pi)+" "+pi+" & "+ci+" "+this.data.get(ci));
		if(this.data.get(pi)<this.data.get(ci)) {
//			System.out.println(pi+" "+this.data.get(pi));
			swap(pi,ci);
			this.upheapify(pi);
		}
	}
	private void swap(int pi, int ci) {
		int t1=this.data.get(ci);
		int t2=this.data.get(pi);
		
		this.data.set(ci, t2);
		this.data.set(pi, t1);
	}
	public void display() {
		System.out.println(this.data);
	}
	public int remove() {
		if(this.data.size()==0)
			return -1;
		swap(0,this.data.size()-1);
		int ans=this.data.remove(this.data.size()-1);
		downheapify(0);
		System.out.println(ans);
		return ans;
	}
	
	private void downheapify(int ci) {
		int l=ci*2+1;
		int r=ci*2+2;
		int max=ci;
		int size=this.data.size();
		if(l<size &&this.data.get(max)<this.data.get(l)) {
			max=l;
		}
		if(r<size &&this.data.get(max)<this.data.get(r)) {
			max=r;
		}
		if(max!=ci) {
			swap(ci,max);
			downheapify(max);
		}
		
		
		
	}
	public static void main(String[] args) {
		Heap h=new Heap();
		Scanner sc=new Scanner(System.in);
//		while(true) {
//			h.insert(sc.nextInt());
//			h.display();
//			h.remove();
//			h.display();
//		}
		for (int i = 0; i < 5; i++) {
			h.insert(sc.nextInt());
			h.display();
		}
		while(true) {
			h.remove();
			h.display();
			sc.nextInt();
		}
		
	}
}
