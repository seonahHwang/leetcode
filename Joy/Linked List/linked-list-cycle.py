'''
❓ 주어진 링크드리스트에 사이클이 존재하는지 확인하는 문제

Explore
input: linked list
output: boolean - check if there is a cycle in the linked list

Clarifications
- Can the linked list be empty? Yes (False)
- Can the linked list only have one node? Yes (False)

Brainstorm
Brute Force: Kep track of visited node. If a node is visited, there is a cycle. O(N) / O(N)
Optimal: Use slow and fast pointers. If slow and fast meet, there is a cycle. O(N) / O(1)

Plan
1. Handle the edge case
2. Initialize slow and fast pointers
3. While fast and fast.next:
    3-1. Move the pointers
    3-2. If slow == fast, return True. (cycle detected)
4. Return False

=> TC: O(N), SC: O(1)
'''

class ListNode:
    def __init__(self, val, next = None):
        self.val = val
        self.next =next

def hasCycle(head):
    if not head or not head.next:
        return False

    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

        if slow == fast:
            return True
    return False


def test():
    def create_linked_list_with_cycle(elements, pos):
        if not elements:
            return None
        head = ListNode(elements[0])
        current = head
        cycle_node = None
        for index, value in enumerate(elements[1:], 1):
            current.next = ListNode(value)
            current = current.next
            if index == pos:
                cycle_node = current
        if pos != -1:
            current.next = cycle_node
        return head

    def create_linked_list(elements):
        if not elements:
            return None
        head = ListNode(elements[0])
        current = head
        for value in elements[1:]:
            current.next = ListNode(value)
            current = current.next
        return head

    # Normal case
    cycle = create_linked_list_with_cycle([3, 2, 0, -4], 1)  
    print(hasCycle(cycle) == True)

    # Edge case
    single_node_no_cycle = create_linked_list([1])
    print(hasCycle(single_node_no_cycle) == False) 

    empty_list = create_linked_list([])
    print(hasCycle(empty_list) == False) 

test()
