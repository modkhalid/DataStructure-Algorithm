package LinkList;

public class LinkedListNew {

	class Node {
		int data;
		Node next = null;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node() {
			this(-1);
		}
	}

	private Node head, tail;
	private int size;

	public LinkedListNew() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public LinkedListNew(LinkedListNew ll) {
		this.head = ll.getHead();
		this.tail = ll.getTail();
		this.size = ll.size;
	}

	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.tail;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(int data) {
		Node nn = new Node(data);
		if (this.head == null) {
			this.tail = nn;
		} else {
			nn.next = this.head;
		}
		this.head = nn;
		this.size++;
	}

	public void addLast(int data) {
		Node nn = new Node(data);
		if (this.head == null) {
			this.head = nn;
		} else {
			this.tail.next = nn;
		}
		this.tail = nn;
		this.size++;
	}

	public Node getNodeAt(int index) throws Exception {

		if (index < 0 || index >= this.size)
			throw new Exception("Invalid Somthing");

		if (index == 0)
			return this.getHead();

		if (index == this.size - 1)
			return this.getTail();

		Node temp = this.head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index >= this.size)
			throw new Exception("Index Out of Bounds of LinkedList MODExeption");

		if (index == 0)
			this.addFirst(data);

		if (index == this.size - 1)
			this.addLast(data);

		Node temp = this.getNodeAt(index - 1);
		Node nn = new Node(data);
		nn.next = temp.next;
		temp.next = nn;
		this.size++;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList empty");
		int data = this.head.data;
		if (this.size == 1) {
			this.tail = null;
		}
		this.head = this.head.next;
		this.size--;

		return data;
	}

	public int removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList empty");

		int data = this.tail.data;
		if (this.size == 1) {
			this.tail = null;
			this.head = null;

		} else {
			Node temp = this.getNodeAt(this.size - 2);
			temp.next = null;
			this.tail = temp;
		}
		this.size--;

		return data;
	}

	public int removeAt(int index) throws Exception {
		if (this.size == 0)
			throw new Exception("LinkedList empty");

		if (index == this.size - 1) {
			return removeLast();
		}
		if (index == 0)
			return this.removeFirst();

		Node temp = getNodeAt(index - 1);
		int data = temp.next.data;
		temp.next = temp.next.next;
		this.size--;

		return data;
	}

	public void reverseDI() throws Exception {
		for (int i = 0; i < this.size / 2; i++) {
			Node temp = this.getNodeAt(this.size - 1 - i);
			int t1 = temp.data;
			Node fNode = this.getNodeAt(i);
			temp.data = fNode.data;
			fNode.data = t1;
		}
	}

	private class HeapMover {
		Node left;
	}

	public void reverseDR() {
		reverseDR(this.head, 0, new HeapMover());
	}

	private void reverseDR(Node right, int count, HeapMover mover) {
		if (right == null) {
			mover.left = this.head;
			return;
		}
		reverseDR(right.next, count + 1, mover);
		if (count > this.size / 2) {

			int data = right.data;
			right.data = mover.left.data;
			mover.left.data = data;
			mover.left = mover.left.next;
		}
	}

	public void reverseDRwithoutHeap() {
		RDRWH(this.head, 0);
	}

	private Node RDRWH(Node right, int count) {
		if (right == null) {
			return this.head;
		}
		Node left = RDRWH(right.next, count + 1);
		if (count > this.size / 2) {
			int data = right.data;
			right.data = left.data;
			left.data = data;
		}
		return left.next;
	}

	public void reversePointerI() {
		Node prev = null, curr, temp;
		curr = this.head;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		this.tail = this.head;
		this.head = prev;
	}

	public void reversePR() {
		reversePR(this.head, this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node left, Node right) {
		if (right == null)
			return;

		reversePR(right, right.next);
		right.next = left;

	}

	public int mid() {
		Node slow = this.head;
		Node fast = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

	public void fold() {
		fold(new HeapMover(), this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {
		if (right == null) {
			mover.left = this.head;
			return;
		}
		fold(mover, right.next, count + 1);

		if (count > this.size / 2) {
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;
			mover.left = ahead;
		} else if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void kreverse(int k) throws Exception {
		LinkedListNew ll = new LinkedListNew(this);
		LinkedListNew ml = null;
		while (!ll.isEmpty()) {
			LinkedListNew sl = new LinkedListNew();
			for (int i = 0; i < k && !ll.isEmpty(); i++) {
				sl.addFirst(ll.removeFirst());
			}

			if (ml == null) {
				ml = sl;
			} else {
				ml.tail.next = sl.head;
				ml.tail = sl.tail;
				ml.size += sl.size();
			}
		}
		this.head = ml.head;
		this.tail = ml.tail;

	}

	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println("\n----------------");
	}

}
