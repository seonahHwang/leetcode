'''
❓ 링크드 리스트가 주어졌을때, 리트를 첫번재 노드, 마지막 노드, 두번째 노드... 순서로 재정렬하는 문제

Explore
input: linked list
output: linked list (modify head in-place)

Brainstorm
Use slow, fast pointers to find the mid point. reverse the second half, then merge O(N)

Plan
1. Handle edge case
2. Use slow, fast pointers, move the pointers till fast.next
3. The position where the slow pointer is at is the mid point. 
    Reverse the second half of the LL starting from slow
4. Merge those Linked Lists

=> TC: O(N), SC: O(1)
'''
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reorderList(head):
    if not head or not head.next:
        return

    slow, fast = head, head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    prev, curr = None, slow

    while curr:
        temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp 
    
    first, second = head, prev
    
    while second.next:
        temp1, temp2 = first.next, second.next
        first.next = second
        second.next = temp1
        first, second = temp1, temp2



def test():
    def list_to_linked_list(elements):
        dummy = ListNode(0)
        current = dummy
        for element in elements:
            current.next = ListNode(element)
            current = current.next
        return dummy.next

    def linked_list_to_list(node):
        result = []
        while node:
            result.append(node.val)
            node = node.next
        return result

    # Normal case
    head = list_to_linked_list([1, 2, 3, 4])
    reorderList(head)
    print(linked_list_to_list(head) == [1, 4, 2, 3])


    head = list_to_linked_list([1, 2, 3, 4, 5])
    reorderList(head)
    print(linked_list_to_list(head) == [1, 5, 2, 4, 3])

    # Edge Case
    head = list_to_linked_list([1])
    reorderList(head)
    print(linked_list_to_list(head) == [1])

    # Test Case 5: Empty list
    head = list_to_linked_list([])
    reorderList(head)
    print(linked_list_to_list(head) == [])

test()