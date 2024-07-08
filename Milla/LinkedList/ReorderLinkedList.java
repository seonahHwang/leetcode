package Milla.LinkedList;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;

/*

Brainstorm
Understanding the problem: We need to reorder the list in a specific pattern.
Initial thoughts:
Split the list into two halves.
Reverse the second half.
Merge the two halves by alternating nodes from each half.

Plan
Find the Middle of the List:
Use two pointers (slow and fast) to find the midpoint of the list.
Reverse the Second Half:
Reverse the second half of the list.
Merge the Two Halves:
Merge the first half and the reversed second half by alternating nodes.

TC : O(n)
SC : O(1) just use extra pointers
*/

public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8))));
        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        // Find the middle of the list using fast and slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            slow = slow.next; // Move slow pointer one step
        }

        ListNode first = head; // First half starts from the head
        ListNode second = slow.next; // Second half starts from the node after slow
        ListNode prev = slow.next = null; // Split the list into two halves

        // Reverse the second half of the list
        while (second != null) {
            ListNode tmp = second.next; // Store the next node
            second.next = prev; // Reverse the link
            prev = second; // Move prev to the current node
            second = tmp; // Move to the next node
        }

        second = prev; // Reset second to the new head of the reversed half
        // Merge the two halves
        while (second != null) {
            ListNode tmp1 = first.next; // Store the next node of the first half
            ListNode tmp2 = second.next; // Store the next node of the second half
            first.next = second; // Link first half node to second half node
            second.next = tmp1; // Link second half node to the next first half node
            first = tmp1; // Move to the next node in the first half
            second = tmp2; // Move to the next node in the second half
        }
    }

}