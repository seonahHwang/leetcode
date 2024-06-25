'''
❓ val, next, random 포인터를 갖는 링크드 리스트가 주어졌을때, 원본리스트와 동일한 새 링크드리스트를 만들어 리턴하는 문제

Explore
input: Linked List 
output: Linked list - deep copy of the input list

Clarification
1. Should the copied list maintain the exact order and structure (both next and random) as the original? Yes
2. How should we handle an empty list? -> Return None

Brainstorm
Use hashmap to keep track of original nodes and their corresponding new nodes
This will allow O(1) access time for setting 'next' and 'random' pointers in the copied list O(N) / O(N)

Plan
1. Handle edge case
2. Initailize the dictionary, curr
3. First pass - create copies
    3-1. Iterate through the original list and create the copy of node
    3-2. Store them into dict {old : new} - these are the address
4. Second pass - update pointers
    4-1. Iterate through the list again to update 'next' and 'random' pointers
5. Return dict[head] => this will return the head of the new list

=> O(N) / O(N)
'''
class ListNode:
    def __init__(self, val=0, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random

def copyRandomList(head):
    if not head:
        return None
    
    curr = head
    old_to_new = {}

    while curr:
        node = ListNode(curr.val)
        old_to_new[curr] = node
        curr = curr.next
    
    curr = head
    while curr:
        new_node = old_to_new[curr]
        new_node.next = old_to_new[curr.next] if curr.next else None
        new_node.random = old_to_new[curr.random] if curr.random else None
        curr = curr.next
    
    return old_to_new[head]


def test():
    def create_linked_list(arr):
        nodes = [ListNode(x[0]) for x in arr]
        for i, x in enumerate(arr):
            if i < len(arr) - 1:
                nodes[i].next = nodes[i + 1]
            if x[1] is not None:
                nodes[i].random = nodes[x[1]]
        return nodes[0] if nodes else None

    def compare_lists(head1, head2):
        while head1 and head2:
            if head1.val != head2.val or (head1.random and head2.random and head1.random.val != head2.random.val):
                return False
            head1 = head1.next
            head2 = head2.next
        return head1 is None and head2 is None

    # Normal Case
    head = create_linked_list([(7, None), (13, 0), (11, 4), (10, 2), (1, 0)])
    copy = copyRandomList(head)
    print(compare_lists(head, copy))  # Expected: True

    # Edge Case
    head = create_linked_list([])
    copy = copyRandomList(head)
    print(compare_lists(head, copy))  # Expected: True

    head = create_linked_list([(1, None)])
    copy = copyRandomList(head)
    print(compare_lists(head, copy))  # Expected: True

test()
