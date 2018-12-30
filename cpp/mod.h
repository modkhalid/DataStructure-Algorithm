#include <iostream>
using namespace std;
class Node
{
public:
	int data;
	Node *next;	
	Node(int item){
		this->data=item;
		this->next=NULL;
	}
};
class heapMover{
		public:
			Node *left;
};

class LinkedList
{

	Node *head,*tail;
	int size;


public:
	LinkedList(){
		this->head=NULL;
		this->tail=NULL;
		this->size=0;
	}
	void addFirst(int item){
		Node *nn=new Node(item);
		if(this->head==NULL){
			this->tail=nn;
			this->head=nn;
		}else{
			nn->next=this->head;
			this->head=nn;
		}
		this->size++;
	}


	void addLast(int item){
		Node *nn=new Node(item);
		if(this->head==NULL){
			this->tail=nn;
			this->head=nn;

		}else{
			this->tail->next=nn;
			this->tail=nn;
		}
		this->size++;
	}

	void display(){
		Node *temp=this->head;
		while(temp!=NULL){
			cout<<temp->data<<" ";
			temp=temp->next;
		}
		cout<<"\n-----------------"<<endl;
	}

	int Size(){
		return this->size;
	}

	Node* getFirstNode(){
		return this->head;
	}

	Node* getLastNode(){
		return this->tail;
	}

	Node* getNodeAt(int idx){
		if(idx<0 || idx>=this->size){
			throw idx;
		}else{
			Node* temp=this->head;
			for (int i = 0; i < idx; ++i)
			{
				temp=temp->next;
			}
			return temp;
		}
	}

	int getFirst(){
		return this->head->data;
	}

	int getLast(){
		return this->tail->data;
	}

	int getAt(int idx){
		if(idx<0 || idx>=this->size){
			throw idx;
		}else{
			Node* temp=this->head;
			for (int i = 0; i < idx; ++i)
			{
				temp=temp->next;
			}
			return temp->data;
		}
	}
	void addAt(int idx,int item){
		if(idx<0 || idx>this->size){
			throw idx;
		}else{
			if(idx==0){
				this->addFirst(item);
			}else if(idx==this->size){
				this->addLast(item);
			}else{
				Node* mnm=getNodeAt(idx-1);
				Node* nn=new Node(item);
				nn->next=mnm->next;
				mnm->next=nn;
				this->size++;

			}

		}
	}
	int setSize(int value){
		this->size+=value;
	}

	int removeFirst(){
		if(this->head==NULL){
			cout<<"LinkedList is Empty";
			throw 1;

		}else{
			Node* res=this->head;
			this->head=this->head->next;
			this->size--;
			return res->data;
		}
	}
	int removeLast(){
		if(this->head==NULL){
			cout<<"LinkedList is Empty";
			throw 1;

		}else{
			int mr=this->tail->data;
			this->tail=getNodeAt(this->size-2);
			this->size--;
			return mr;
		}
	}

	int removeAt( int idx){
		if(this->head==NULL || idx<0 || idx>=this->size){
			throw 2;
		}

		if(idx==0){
			return this->removeFirst();
		}else if(idx==this->size-1){
			return this->removeLast();
		}else{
			Node* nn=getNodeAt(idx-1);
			Node* mr=nn->next;
			nn->next=nn->next->next;
			this->size++;
			return mr->data;
		}

	}
	void reverseDI(){
		for (int i = 0; i < this->size/2; ++i)
		{
			Node* first=getNodeAt(i);
			Node* last=getNodeAt(this->size-1-i);
			int data=first->data;
			first->data=last->data;
			last->data=data;

			
		}
	}

	void reversePI(){
		Node *curr,*next,*prev;
		curr=this->head;
		next=NULL;
		prev=NULL;
		while(curr!=NULL){
			next=curr->next;
			curr->next=prev;
			prev=curr;
			curr=next;
		}
		next=this->head;
		this->head=this->tail;
		this->tail=next;
	}


	void reverseDR(){
		reverseDR(this->head,this->head,0);
	}
	bool isEmpty(){
		return this->size==0;
	}
private:
	Node* reverseDR(Node* left,Node* right,int count){
		if(right==NULL){
			return left;
		}

		Node* nn=reverseDR(left,right->next,count+1);
		if(count>=this->size/2){
			int data=nn->data;
			nn->data=right->data;
			right->data=data;
		}
		return nn->next;
	}
	void reverseDRH(heapMover *mover,Node* right,int count){
		if(right==NULL){
			return;
		}
		reverseDRH(mover,right->next,count+1);
		if(count>=this->size/2){
			int data=mover->left->data;
			mover->left->data=right->data;
			right->data=data;
		}
		mover->left=mover->left->next;
	}
	void reversePR(Node* prev,Node* curr){
		if(curr==NULL){
			return;
		}
		reversePR(curr,curr->next);
		curr->next=prev;
	}

	void fold(heapMover *mover,Node* right,int count){
		if(right==NULL){
			return;
		}

		fold(mover,right->next,count+1);
		if(count>this->size/2){
			Node* temp=mover->left->next;
			mover->left->next=right;
			right->next=temp;
			mover->left=temp;
		}else if(count==this->size/2){
			this->tail=right;
			this->tail->next=NULL;
		}
	}
public:
	void reversePR(){
		reversePR(this->head,this->head->next);
		Node *ptr=this->head;
		this->head=this->tail;
		this->tail=ptr;
		this->tail->next=NULL;

	}

	void reverseDRH(){
		heapMover* mover;
		mover=new heapMover();
		mover->left=this->head;
		reverseDRH(mover,this->head,0);
	}

	int modData(){
		Node *n1=this->head;
		Node *n2=this->head;
		while(n2->next!=NULL && n2->next->next!=NULL){
			n2=n2->next->next;
			n1=n1->next;
		}
		return n1->data;
	}

	int kThFromLast(int k){
		Node *n1=this->head;
		Node *n2=this->head;
		for (int i = 0; i < k; ++i)
		{
			if(n2==NULL){
				throw k;
			}
			n2=n2->next;
		}
		while(n2!=NULL){
			n2=n2->next;
			n1=n1->next;
		}
		return n1->data;
	}

	void fold(){
		heapMover *mover=new heapMover();
		mover->left=this->head;
		fold(mover,this->head,0);
	}


	void kReverse(int k){
		LinkedList rl;
		while(!this->isEmpty()){
			LinkedList nl;
			for (int i = 0; i < k && !this->isEmpty(); ++i)
			{
				nl.addFirst(this->removeFirst());
			}

			if(rl.head==NULL){
				rl=nl;
			}else{
				rl.tail->next=nl.head;
				rl.tail=nl.tail;
				// rl.size+=nl.size;
				//nl=new LinkedList();
				rl.setSize(nl.Size());
			}
		}
		this->head=rl.head;
		this->size=rl.size;
		this->tail=rl.tail;
	}

	void createLoop(int idx){
		if(idx<0 || idx>=this->size){
			throw 89;
		}
		Node *ptr=getNodeAt(idx);
		this->tail->next=ptr;
	}

	// DECECT AND REMOVE LOOP FROM LINK LIST 
	void detectAndremoveLoop(){
		Node* slow=this->head,*fast=this->head;
		while(true){
			slow=slow->next;
			fast=fast->next->next;
			if(slow==fast){
				break;
			}
		}
		// Node *ptr;
		// cout<<"oneloop";

		slow=this->head;
		while(slow!=fast){
			slow=slow->next;
			fast=fast->next;
		}
		// cout<<"Second loop";
		// fast=fast->next;
		while(fast->next!=slow){
			fast=fast->next;
		}
		// cout<<"third loop";
		fast->next=NULL;
		this->tail=fast;
	}

	/*LinkedList sum(LinkedList second){
		LinkedList ml;
		Node *temp=this->head;
		while()
	}*/


	arrangeOnNumber(int number){
		Node *temp=this->head,*currTail=this->tail,*endTail=this->tail;
		while(temp!=this->tail){
			if(temp->data==number){
				currTail->next=temp;
			}
			temp=temp->next;
		}
	}
};