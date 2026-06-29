# LINKED LIST INSERTION AT BEGINNING->https://www.geeksforgeeks.org/problems/linked-list-insertion-at-beginning/1
# COMPLEXITY=O(n)
"""
class Node:

    def __init__(self, data):
        self.data = data
        self.next = None
"""

class Solution:
    def insertAtFront(self, head, x):
        #code here
        newNode=Node(x)
        newNode.next=head
        head=newNode
        
        return head


# DELETE NODE IN A LINKED LIST->https://leetcode.com/problems/delete-node-in-a-linked-list/description/
# COMPLEXITY=O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """

        node.val=node.next.val
        node.next=node.next.next


# FIND THE LENGTH OF THE LINKED LIST->https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
# COMPLEXITY=O(n)

''' Structure of linked list Node
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
'''
class Solution:
    def getCount(self, head):
        # code here
        length=0
        if head.next is None:
            return 1
            
        cur=head
        
        while cur is not None:
            length+=1
            cur=cur.next
            
        return length

# SEARCH IN LINKED LIST->https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1
# COMPLEXITY=O(n)

'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
'''

class Solution:
    def searchKey(self, head, key):
        #Code here
        cur=head
        present=False
        
        while cur is not None:
            if cur.data==key:
                present=True
                return present
            cur=cur.next
                
        return present

# MIDDLE OF THE LINKED LIST->https://leetcode.com/problems/middle-of-the-linked-list/description/
# COMPLEXITY=O(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:

        slow=head
        fast=head

        while fast and fast.next  is not None :
            slow=slow.next
            fast=fast.next.next


        return slow

        
# REVERSE THE LINKED LIST->https://leetcode.com/problems/reverse-linked-list/submissions/2049944611/
# COMPLEXITY=O(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        if head is None:
            return head

        prev=None
        curr=head
        Next=head

        while Next is not None:
            Next=curr.next
            curr.next=prev
            prev=curr
            curr=Next


        return prev

    



        
        