class Node:
    def __init__(self,data):
        self.data=data
        self.next=None


class LinkedList:
    def __init__(self):
        self.head=None
        self.tail=None
        self.size=0


    def addFirst(self,data):
        nn=Node(data)
        if self.size is 0:
            self.head=nn
            self.tail=nn
        else:
            nn.next=self.head
            self.head=nn
        self.size+=1

    def addLast(self,data):
        nn=Node(data)
        if self.size is 0:
            self.head=nn
            self.tail=nn
        else:
            self.tail.next=nn
            self.tail=nn
        self.size+=1

    def getNodeAt(self,idx):
        if idx < 0 and idx >= self.size:
            print("Invalid Index")
            return
        temp=self.head
        for a in range(0,idx):
            temp=temp.next
        return temp

    def addAt(self,idx,data):
        if idx <0 and idx>self.size:
            print("invalid index")
            return
        if idx is 0:
            self.addFirst(data)
        elif idx is self.size:
            self.addLast(data)
        else:
            nm=self.getNodeAt(idx-1)
            nn=Node(data)
            nn.next=nm.next
            nm.next=nn
            self.size+=1


    def removeFirst(self):
        if self.size is 0:
            print("empty LinkedList")
            return
        data=self.head.data
        self.head=self.head.next
        self.size-=1
        return data

    def removeLast(self):
        if self.size is 0:
            print("empty LinkedList")
            return
        nm=self.getNodeAt(self.size-2)
        data=self.tail.data
        self.tail=nm
        self.tail.next=None
        self.size-=1
        return data

    def removeAt(self,idx):
        if idx<0 and idx>self.size:
            print("Invalid index")
            return -1
        if idx is 0:
            return self.removeFirst()
        elif idx is self.size-1:
            removeLast()
        else:
            nm=self.getNodeAt(idx-1)
            data=nm.next.data
            nm.next=nm.next.next
            self.size-=1
            return data


    def reverseDI(self):
        for i in range(0,int(self.size/2)):
            t1=self.getNodeAt(i).data
            self.getNodeAt(i).data=self.getNodeAt(self.size-1-i).data
            self.getNodeAt(self.size-1-i).data=t1

    def reversePI(self):
        prev=None
        temp=None
        curr=self.head
        while curr is not None:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        temp=self.tail
        self.tail=self.head
        self.head=temp;



    def reverseDR(self):
        self.__reverseDR(self.head,self.head,0)
    def __reverseDR(self,left,right,count):
        if right is None:
            return left
        temp=self.__reverseDR(left,right.next,count+1)

        if count > self.size/2:
            data=temp.data
            temp.data=right.data
            right.data=data
        return temp.next

    def reversePR(self):
        self.__reversePR(self.head,self.head)
        temp=self.head
        self.head=self.tail
        self.tail=temp
        self.tail.next=None
    def __reversePR(self,prev,curr):
        if curr is None:
            return
        self.__reversePR(curr,curr.next)
        curr.next=prev

    def display(self):
        temp=self.head
        while temp is not None:
            print(temp.data,end=" ")
            temp=temp.next



ll=LinkedList()
ll.addLast(5)
ll.addLast(6)
ll.addFirst(3)
# ll.addLast(3)
ll.addFirst(2)
ll.addAt(2,4)
ll.display()
print('\n---------')
# print(ll.removeAt(2))
# ll.reversePI()
# ll.reversePI()
# ll.reverseDR()
# ll.reverseDR()
ll.reversePR()
ll.display()

print('\n---------\n')
# ll.x();
