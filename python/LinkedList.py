class Node:
    def __init__(self,item):
        self.data=item
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None
        self.tail=None
        self.size=0

    def addFirst(self,item):
        nn=Node(item)
        if self.head is None:
            self.head=nn
            self.tail=nn
        else:
            nn.next=self.head
            self.head=nn
        self.size+=1

    def addLast(self,item):
        nn=Node(item)
        if self.head is None:
            self.head=nn
            self.tail=nn
        else:
            self.tail.next=nn
            self.tail=nn

        self.size+=1
    def getNodeAt(self,idx):
        if idx >= self.size and idx <0:
            print("Invalid Index")
            return
        if idx is 0:
            return self.head
        elif idx is self.size-1:
            return self.tail
        else:
            temp=self.head
            for i in range(0,idx):
                temp=temp.next
            return temp
    def addAt(self,idx,item):
        if idx >= self.size and idx <0:
            print("Invalid Index")
            return
        if idx==0:
            return self.addFirst(item)
        elif idx is self.size:
            return self.addLast(item)
        else:
            n=self.getNodeAt(idx-1)
            nn=Node(item)
            nn.next=n.next
            n.next=nn
            self.size+=1




    def display(self):
        temp=self.head
        while temp is not None:
            print(temp.data,end=" ")
            temp=temp.next



ll=LinkedList()

ll.addFirst(9)
ll.addFirst(8)
ll.addFirst(7)
ll.addFirst(6)
ll.addFirst(5)
ll.addAt(3,6.5)
print(ll.getNodeAt(4).data)

ll.display()
