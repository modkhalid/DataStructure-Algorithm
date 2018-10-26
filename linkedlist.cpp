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
	 	cout<<endl;
	 	ll.display();
	 	ll.reverseDR();
	 	ll.display();
	 	ll.reverseDR();
	 	ll.display();
	 	//cout<<endl<<ll.Size()<<endl;
	 }catch(int x){
	 	cout<<"INVALID INDEX "<<x;
	 }

 }