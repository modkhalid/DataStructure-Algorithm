package g;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		LinkedList ll=new LinkedList();
		ll.addFirst(5);
		ll.addFirst(4);
		ll.addLast(6);
//		ll.display();
		ll.addAt(1, 3);
//		ll.addFirst(1);
//		ll.addFirst(-1);
//		ll.addFirst(-3);
//		ll.display();
//		ll.removeFirst();
//		ll.display();
//		ll.removeLast();
//		ll.display();
//		ll.removeAt(0);
//		ll.display();
//		ll.display();
//		ll.reverseDataItr();
//		ll.reverseDataRec();
//		ll.reverseDataRec();
//		ll.reversePointerRec();
//		ll.reverseDataItr();
//		ll.reverseDataWithHeap();
//		ll.reverseDataWithHeap();
//		System.out.println(ll.MidNodeData());
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addFirst(0);
		
		ll.display();
		ll.kReverse(3);
		ll.display();

	}

}
