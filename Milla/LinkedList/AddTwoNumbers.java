package Milla.LinkedList;

import java.util.ArrayList;
import java.util.List;
/*
* We need to add two numbers represented as linked lists and return the sum as a linked list.
* Convert each linked list into an integer.
* Add the two integers.
* Conver the sum back into a linked list.
*
* Plan
* Convert linked list to Integer
* Sum the Integers
* Convert thesum to linked list
*
* If the both lists are empty, should I return null?
*
* TC : converting and adding integers is linear in the number of digits, So It will take O(n)
* SC : I'll use linkedlist to store each Linkedlist. so It will take O(N)
*
* ***** ListNode만 사용해서 풀기!! 
* */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode node2 = new ListNode(4,new ListNode(5,new ListNode(6)));
        addTwoNumbers(node1,node2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();

        // Traverse the first linked list and store its values in reverse order
        while (head != null) {
            if (head.val > 0) { // Only add positive values to the list
                li1.add(0, head.val); // Add value to the beginning of the list to reverse the order
            }
            head = head.next; // Move to the next node
        }

        head = l2; // Reset head to the start of the second linked list
        // Traverse the second linked list and store its values in reverse order
        while (head != null) {
            if (head.val > 0) { // Only add positive values to the list
                li2.add(0, head.val); // Add value to the beginning of the list to reverse the order
            }
            head = head.next; // Move to the next node
        }

        // Convert the reversed lists to integers and sum them
        int sum1 = getSum(li1);
        int sum2 = getSum(li2);
        int total = sum1 + sum2;

        System.out.println("total" + total); // Print the total sum for debugging

        // Convert the total sum to a string
        String s = Integer.toString(total);
        int len = s.length(); // Get the length of the sum string

        ListNode node = new ListNode(); // Create the head of the result linked list
        ListNode cur = node; // Pointer to the current node in the result linked list
        // Create the result linked list from the sum string
        for (int i = 0; i < len; i++) {
            cur.val = Integer.parseInt(String.valueOf(s.charAt(len - 1 - i))); // Set the current node's value
            ListNode add = new ListNode(); // Create a new node for the next digit
            cur.next = add; // Link the current node to the new node
            if (cur.next != null) cur = cur.next; // Move to the next node
        }

        return node; // Return the head of the result linked list
    }

    // Helper method to convert a list of integers to a single integer
    static int getSum(List li) {
        int product = (int) Math.pow(10, li.size() - 1); // Initialize the place value (e.g., hundreds, tens, ones)
        int sum = 0; // Initialize the sum
        for (int i = 0; i < li.size(); i++) {
            sum += (int) li.get(i) * product; // Add the digit multiplied by its place value to the sum
            product /= 10; // Move to the next place value (e.g., tens to ones)
        }
        return sum; // Return the computed sum
    }

}
