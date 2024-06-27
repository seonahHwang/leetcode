'''
❓ 두개의 링크드리스트가 주어졌을때, 각각 노드의 value 값을 더해서 하나의 링크드리스트로 반환하는 문제

Explore
input: 2 Linked List - each node represents single digit. Stored in the reversed order
output: Linked List - sum of the two numbers, also in reverse order

Clarifications:
- Can the input linked lists have different lengths? -> Yes
- Do I add the carry-over digit to the next significant digit? Yes
- Can the input lists contain negative numbers? No, non-negative integers only

Test Cases
[2,4,3], [5,6,4] => [8,0,7]
[9,9,9,9,9,9,9], [9,9,9,9] =>[8,9,9,9,0,0,0,1]
[9,9,9,9], [1] => [1]

Brainstorm
- Brute force: Converting linked list into integers, sum them, and convert the result back to LL. O(N), O(N)
- Optimal approach: Traverse both lists simultaneously, sum corresponding digits along with carry, 
and create new nodes for the result. (Still O(N), O(N) but more optimal)

Plan
1. Handle edge case
2. Initialzie curr, dummy to the new ListNode
3. while both l1 and l2 
    3-1. Use divmod to get the digit and carry
    3-2. Have the next node pointint to the new Listnode with digit as the value
    3-3. Move the pointers (l1, l2, curr)
[Handling remianing nodes and carry]
4. Store the remaining portion => (At this point, either l1 or l2 can have the remainign portion)
5. Do the same step for the rest of the portion
6. Return dummy.next

=> TC: O(N), SC: O(N)
'''

class ListNode:
    def __init__(self, val, next = None):
        self.val = val
        self.next = next
    
def addTwoNumbers(l1, l2):
    if not l1 or not l2:
        return l1 or l2
    
    curr = dummy = ListNode(0)
    carry = 0

    while l1 and l2:
        carry, digit = divmod(l1.val + l2.val + carry, 10)
        curr.next = ListNode(digit)
        l1, l2, curr = l1.next, l2.next, curr.next
    
    l = l1 or l2

    while l:
        carry, digit = divmod(l.val + carry, 10)
        curr.next = ListNode(digit)
        l, curr = l.next, curr.next

    if carry:
        curr.next = ListNode(carry)

    return dummy.next
    

def test():
    def create_linked_list(numbers):
        dummy = ListNode(0)
        current = dummy
        for number in numbers:
            current.next = ListNode(number)
            current = current.next
        return dummy.next

    def linked_list_to_list(node):
        result = []
        while node:
            result.append(node.val)
            node = node.next
        return result

    # Normal Cases
    l1 = create_linked_list([2, 4, 3])
    l2 = create_linked_list([5, 6, 4])
    print(linked_list_to_list(addTwoNumbers(l1, l2)) == [7, 0, 8])  # 342 + 465 = 807

    # Edge Cases
    l1 = create_linked_list([9, 9, 9, 9])
    l2 = create_linked_list([1])
    print(linked_list_to_list(addTwoNumbers(l1, l2)) == [0, 0, 0, 0, 1])  # 9999 + 1 = 10000

    l1 = create_linked_list([])
    l2 = create_linked_list([0, 1])
    print(linked_list_to_list(addTwoNumbers(l1, l2)) == [0, 1])  # 0 + 10 = 10

test()
