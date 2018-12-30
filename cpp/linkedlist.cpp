 #include "mod.h"
 int main(){
 	try{
	 	LinkedList ll;
	 	ll.addFirst(20);
	 	ll.addLast(30);
	 	ll.addLast(370);
	 	ll.addLast(345);
	 	ll.addLast(12);
	 	ll.addLast(15);
	 	ll.addLast(345);
	 	// cout<<endl;
	 	// ll.display();
	 	// ll.reverseDR();
	 	ll.display();
	 	// ll.reverseDRH();
	 	// ll.display();
	 	// cout<<ll.modData()<<endl;
	 	// cout<<ll.kThFromLast(5);
	 	// ll.fold();

	 	// cout<<ll.Size()<<endl;
	 	// ll.kReverse(3);
	 	// ll.display();	
	 	// cout<<ll.Size()<<endl;
	 	//cout<<endl<<ll.Size()<<endl;
	 	ll.createLoop(5);
	 	ll.detectAndremoveLoop();
	 	ll.display();
	 	// ll.display();
	 }catch(int x){
	 	cout<<"INVALID INDEX "<<x<<endl;
	 }

 }