'''
❓ 링크드리스트가 주어졌을때, reverse해서 반환하는 문제

Explore
input: linked list
output: linked list - reversed

Clarifications
- Can the input be empty? Yes
- Do I just return the node itself if the list has a single node? Yes

Brainstorm
- Brute force: We can use stack to store node values and then reconstruct the linked list. O(N) extra space
- Optimal: Use three pointers: prev, curr, next to revrse the linked list in-place. O(N), 0(1)

Plan
1. Handle edge case
2. have prev = None, curr = head
3. While curr:
    3-1. Store curr.next to the temporary node
    3-2. curr.next = prev (reverse the pointer)
    3-3. prev = curr (move prev one step ahead)
    3-4. curr = temp (move curr one step ahead)
4. return prev (our new head starting from the tail)

=> TC: O(N), SC: O(1)
'''

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

def reverseList(head):
    if not head:
        return 
    prev = None
    curr = head

    while curr:
        temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp
    return prev


def test():
    def list_to_linked_list(elements):
        dummy = ListNode(0)
        current = dummy
        for el in elements:
            current.next = ListNode(el)
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
    print(linked_list_to_list(reverseList(head)) == [5, 4, 3, 2, 1])


    # Edge case
    head = list_to_linked_list([])
    print(linked_list_to_list(reverseList(head)) == [])

    head = list_to_linked_list([42])
    print(linked_list_to_list(reverseList(head)) == [42])


test()
