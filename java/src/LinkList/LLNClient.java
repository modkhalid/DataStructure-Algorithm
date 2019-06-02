package LinkList;

public class LLNClient {
	public static void main(String[] args) throws Exception {
		LinkedListNew ll=new LinkedListNew();
		ll.addLast(-1);
		ll.addFirst(12);
		ll.addFirst(11);
		ll.addFirst(10);
		ll.addLast(65);
		ll.addAt(115, 2);
		ll.addFirst(98);
//		ll.addFirst(56);
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeAt(2));

		ll.display();
//		ll.reverseDI();
//		ll.display();
//		ll.reverseDI();
//		ll.reverseDR();
//		ll.display();
//		ll.reverseDR();
//		ll.reverseDRwithoutHeap();
//		ll.reversePointerI();
//		ll.reversePointerI();
//		ll.reversePR();
		
//		ll.display();
//		System.out.println(ll.mid());
//		ll.fold();
//		ll.display();
		ll.kreverse(3);
		System.out.println(ll.size());
		ll.display();
	}
	
}
