package LinkList;

//import LinkedList.HeapMover;

//import java.util.Scanner;
class Node{
	int data;
	Node next=null;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
public class LinkedList {
	private Node head,tail;
	private int size;

//	constructor
	public LinkedList() {
		this.tail=null;
		this.head=null;
		this.size=0;
	}

	class HeapMover{
		Node left;
		public HeapMover(Node node) {
			this.left=node;
		}
	}

//	add first method
	public void addFirst(int data) {
		Node nn=new Node(data);
		if(this.size==0) {
			this.head=nn;
			this.tail=nn;
			this.size++;
		}else{
			nn.next=this.head;
			this.head=nn;
			this.size++;
		}
	}

//	add last method O(1)
	void addLast(int data) {
		Node nn=new Node(data);
		if(this.size==0) {
			this.head=nn;
			this.tail=nn;
		}else {
			this.tail.next=nn;
			this.tail=nn;
		}
		this.size++;
	}

	public Node getNodeAt(int idx) throws Exception{
		if(idx<0 && idx>=this.size) {
			throw new Exception("Invalid Index in GetNodeAt("+idx+")");
		}
		if(idx==0) {
			return this.head;
		}else if(idx==this.size-1) {
			return this.tail;
		}else {
			Node temp=this.head;
			for (int i = 0; i < idx; i++) {
				temp=temp.next;
			}
			return temp;
		}
	}

	public void addAt(int idx,int data) throws Exception {
		if(idx==0) {
			addFirst(data);
		}else if(this.size==idx) {
			addLast(data);
		}else {
			Node nn=new Node(data);
			Node temp=getNodeAt(idx-1);
			nn.next=temp.next;
			temp.next=nn;
			this.size++;

		}
	}
//	o(1)
	public int removeFirst() throws Exception{
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		int temp=this.head.data;
		this.head=this.head.next;
		this.size--;
		return temp;

	}

	public int removeLast() throws Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		Node temp=getNodeAt(this.size-2);
		this.tail=temp;
		int data=temp.next.data;
		this.tail.next=null;
		this.size--;
		return data;
	}

	public int removeAt(int idx) throws Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		if(idx==0) {
			return this.removeFirst();
		}else if(idx==this.size-1) {
			return this.removeLast();
		}else {
			Node nm=this.getNodeAt(idx-1);
			int data=nm.next.data;
			nm.next=nm.next.next;
			this.size--;
			return data;
		}
	}


	public void removeKey(int key) {
		Node temp=this.head;
		if(temp!=null && temp.data==key) {
			this.head=temp.next;
			return;
		}
		Node prev=null;

		while(temp!=null && temp.data!=key) {
			prev=temp;
			temp=temp.next;
		}

		if(temp==null) {
			return ;
		}

		prev.next=temp.next;
	}



	public void ReversePointerItr() {
		Node curr=this.head;
		Node prev=null,avail=null;
		while(curr!=null) {
			avail=curr.next;
			curr.next=prev;
			prev=curr;
			curr=avail;
		}
		avail=this.tail;
		this.tail=this.head;
		this.head=avail;
	}

	public void reverseDataItr() throws Exception {
		Node last=null,first=null;
		for (int i = 0; i < this.size/2; i++) {
			first=getNodeAt(i);
			last=getNodeAt(this.size-1-i);
			int data=first.data;
			first.data=last.data;
			last.data=data;
		}
	}

	public void reverseDataRec() {
		this.reverseDataRec(this.head,this.head,0);
	}

	private Node reverseDataRec(Node left, Node right,int count) {
		if(right==null) {
			return left;
		}
		Node temp=this.reverseDataRec(left,right.next,count+1);
		if(count>=this.size/2) {
			int data=right.data;
			right.data=temp.data;
			temp.data=data;
		}
		return temp.next;

	}

	public void reversePointerRec() {
		this.reversePointerRec(this.head,this.head);
		Node temp=this.head;
		this.head=this.tail;
		this.tail=temp;
		this.tail.next=null;
	}

	private void reversePointerRec(Node prev, Node curr) {
		if(curr==null) {
			return;
		}
		this.reversePointerRec(curr,curr.next);
		curr.next=prev;



	}

	public void reverseDataWithHeap() {
		reverseDataWithHeap(new HeapMover(this.head),this.head,0);
	}

	private void reverseDataWithHeap(HeapMover heap, Node curr,int count) {
		if(curr==null) {
			return;
		}
		this.reverseDataWithHeap(heap, curr.next,count+1);
		if(count>=this.size/2) {
			int data=curr.data;
			curr.data=heap.left.data;
			heap.left.data=data;
		}
		heap.left=heap.left.next;
	}

	public int MidNodeData() {
		Node slow=this.head;
		Node fast=this.head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}


	public void kReverse(int k) throws Exception {
		LinkedList ml=new LinkedList();
		while(!this.isEmpty()) {
			LinkedList ll=new LinkedList();
			for (int i = 0; i < k && !this.isEmpty(); i++) {
				ll.addFirst(this.removeFirst());
			}
			if(ml.head==null) {
				ml=ll;
			}else {
				ml.tail.next=ll.head;
				ml.tail=ll.tail;
				ml.size+=ll.size;
			}
//			ll=null;
		}
		this.tail=ml.tail;
		this.head=ml.head;
		this.size=ml.size;
	}

	public int kthFromLast(int k) {
		Node slow=this.head;
		Node fast=this.head;
		for (int i = 0; i < k; i++) {
			fast=fast.next;
		}
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow.data;
	}


	public int countOccurence(int key) {
		Node temp=this.head;
		int count=0;
		while(temp!=null) {
			if(temp.data==key) {
				count++;
			}
			temp=temp.next;
		}
		return count;
	}


	void CreateLoop(int idx) throws Exception {
		if(idx<0 && idx>=this.size) {
			throw new Exception("Invalid Index in GetNodeAt("+idx+")");
		}
		this.tail.next=getNodeAt(idx);

	}

	void DetectAndRemoveLoop() {
		Node slow=this.head;
		Node fast=this.head;
//		finding the middle node in the loop
//		Ex. 1-2-3-4-5-6-7-8-then 4
//		ans is 6
		while(true) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				break;
			}
		}
//		System.out.println(fast.data+"  "+slow.data);
//		will get 4
		slow=this.head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
//		System.out.println("L2");
		while(fast.next!=slow) {
			fast=fast.next;
		}
//		System.out.println("L3");
		fast.next=null;
		this.tail=fast;

	}
	
	
//	remove duplicates
	
	public void removeDuplicatesFromSortedLinkedList() {
		Node temp=this.head;
		if(temp==null) {
			return;
		}
		while(temp!=null && temp.next!=null) {
			if(temp.data==temp.next.data) {
				temp.next=temp.next.next;
			}else
				temp=temp.next;
		}
	}
	
	
//remove duplicates from linkedlist recursive approach
	
	public void remDFSLLRec() {
		remDFSLLRec(this.head);
	}

	private void remDFSLLRec(Node head) {
		if(head==null || head.next==null) {
			return;
		}
		if(head.data==head.next.data) {
			head.next=head.next.next;
			remDFSLLRec(head);
		}else {
			this.remDFSLLRec(head.next);
		}
	}

	
	
	
	boolean isEmpty() {
		return this.size==0;
	}


	public void fold() {
		fold(new HeapMover(this.head),this.head,0);
	}
	private void fold(HeapMover mover, Node right, int count) {
		if(right==null) {
			return;
		}
		fold(mover,right.next,count+1);
		if(count>this.size/2) {
			Node ahead=mover.left.next;
			mover.left.next=right;
			right.next=ahead;
			mover.left=ahead;
		}else if(this.size==0) {
			this.tail=right;
			this.tail.next=null;
		}

	}

	public int Size() {
		return this.size;
	}

	//	display function
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
}
