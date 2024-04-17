# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if(l1 is None):
            return l2
        if(l2 is None):
            return l1
        
        sorting_head = None
        if(l1.val <= l2.val):
            sorting_head = l1
            l1 = l1.next
        else:
            sorting_head = l2
            l2 = l2.next
        
        sorting = sorting_head
        
        while(l1 and l2):
            if l1.val <= l2.val:
                sorting.next = l1
                sorting = sorting.next
                l1 = l1.next
            else:
                sorting.next = l2
                sorting = sorting.next
                l2 = l2.next
        
        if(l1 == None):
            sorting.next = l2
        
        if(l2 == None):
            sorting.next = l1
        
        return sorting_head