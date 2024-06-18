'''
❓ 두개의 정렬된 링크드 리스트가 주어졌을때, 하나의 정렬된 링크드리스트로 merge하는 문제
Explore
input: 2 linked lists
output: 1 linke list (merged)

Clarifications
1. Do we return the 1 linked list in the ascending order? Yes
2. Can the list be empty? Yes
3. Then What should I return if both are empty? You just return empty linked list

Brainstorm
- Brute force: We can concatenate both lists into a single list then sort the combined list. O(nlog)
- Optimal: We can iterate through each list once. 
We will keep comparing the current node and append the smaller one to the merged list

Plan
1. handle the edge case
2. Have the dummy node, have current pointint to the dummy node
3. while list1 and list2 both exist,
    3-1. If list1.val > list2.val
            3-2. current.next = list2
            3-3. list2 = list2.next
    3-4. same thing here
4. exiting from the while loop means either list1 or list2 ends.
    4-1. so we will just pointing current.next to the remaining list
5. return dummy.next

=> TC: O(N), SC: O(1)
'''
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeTwoLists(list1, list2):
    if not list1 or not list2:
        return list1 or list2
    dummy = ListNode(0)
    current = dummy

    while list1 and list2:
        if list1.val > list2.val:
            current.next = list2
            list2 = list2.next
        else:
            current.next = list1
            list1 = list1.next
        current = current.next
    
    if list1:
        current.next = list1
    else:
        current.next = list2
        
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
    list1 = list_to_linked_list([1, 2, 4])
    list2 = list_to_linked_list([1, 3, 4])
    print(linked_list_to_list(mergeTwoLists(list1, list2)) == [1, 1, 2, 3, 4, 4])

    # Edge Test Cases
    list1 = list_to_linked_list([])
    list2 = list_to_linked_list([])
    print(linked_list_to_list(mergeTwoLists(list1, list2)) == [])

    list1 = list_to_linked_list([1])
    list2 = list_to_linked_list([])
    print(linked_list_to_list(mergeTwoLists(list1, list2)) == [1])

    list1 = list_to_linked_list([2])
    list2 = list_to_linked_list([1])
    print(linked_list_to_list(mergeTwoLists(list1, list2)) == [1, 2])

test()
