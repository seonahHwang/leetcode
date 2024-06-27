'''
❓ 링크드 리스트가 주어졌을때 tail에서 n번째 떨어진 노드를 제거하고 리턴하는문제

Explore
input: linked list, integer - n
output: linked list - nth node from the tail removed  

Brainstorm
- Brute force: We can traverse the list to count the total number of nodes,
    then traverse again to remove the nth node from the end O(2N)
- Optimal: We can use two-pointers. Move the first pointer n steps ahead, 
    then move both pointers until first pointer reach the end. 

Plan
1. Handle edge case
2. Have dummy node, slow and fast pointers pointing to the dummy node
3. Move fast pointer n step ahead
4. While fast
    4-1. Move fast and slow pointers
5. Exiting from the while loop means we are at nth from the tail
6. Have slow.next pointint to slow.next.next so that we can remove that node
7. Return dummy.next

=> TC: O(N), SC: O(1)
'''

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

def removeNthFromEnd(head, n):
    if not head:
        return
    dummy = ListNode(0)
    dummy.next = head
    fast = dummy
    slow = dummy

    for i in range(n + 1):
        fast = fast.next
    
    while fast:
        fast = fast.next
        slow = slow.next
    
    slow.next = slow.next.next
    return dummy.next




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
    head = list_to_linked_list([1, 2, 3, 4, 5])
    n = 2
    print(linked_list_to_list(removeNthFromEnd(head, n)) == [1, 2, 3, 5])

    # Edge case
    head = list_to_linked_list([1])
    n = 1
    print(linked_list_to_list(removeNthFromEnd(head, n)) == [])

    head = list_to_linked_list([1, 2])
    n = 2
    print(linked_list_to_list(removeNthFromEnd(head, n)) == [2])

test()
