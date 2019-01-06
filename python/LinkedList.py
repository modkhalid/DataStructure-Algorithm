# class Node:
#     def __init__(self,item):
#         self.data=item
#         self.next=None
#
# class LinkedList:
#     def __init__(self):
#         self.head=None
#         self.tail=None
#         self.size=0
#
#     def addFirst(self,item):
#         nn=Node(item)
#         if self.head is None:
#             self.head=nn
#             self.tail=nn
#         else:
#             nn.next=self.head
#             self.head=nn
#         self.size+=1
#
#     def addLast(self,item):
#         nn=Node(item)
#         if self.head is None:
#             self.head=nn
#             self.tail=nn
#         else:
#             self.tail.next=nn
#             self.tail=nn
#
#         self.size+=1
#     def getNodeAt(self,idx):
#         if idx >= self.size and idx <0:
#             print("Invalid Index")
#             return
#         if idx is 0:
#             return self.head
#         elif idx is self.size-1:
#             return self.tail
#         else:
#             temp=self.head
#             for i in range(0,idx):
#                 temp=temp.next
#             return temp
#     def addAt(self,idx,item):
#         if idx >= self.size and idx <0:
#             print("Invalid Index")
#             return
#         if idx==0:
#             return self.addFirst(item)
#         elif idx is self.size:
#             return self.addLast(item)
#         else:
#             n=self.getNodeAt(idx-1)
#             nn=Node(item)
#             nn.next=n.next
#             n.next=nn
#             self.size+=1
#
#
#
#
#     def display(self):
#         temp=self.head
#         while temp is not None:
#             print(temp.data,end=" ")
#             temp=temp.next
#
#
#
# ll=LinkedList()
#
# ll.addFirst(9)
# ll.addFirst(8)
# ll.addFirst(7)
# ll.addFirst(6)
# ll.addFirst(5)
# ll.addAt(3,6.5)
# print(ll.getNodeAt(4).data)
#
# ll.display()



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
        nm=getNodeAt(self.size-2)
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
            nm=getNodeAt(idx-1)
            data=nm.next.data
            
            return data







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
