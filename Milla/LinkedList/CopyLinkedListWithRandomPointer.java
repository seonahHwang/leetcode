package Milla.LinkedList;

import java.util.HashMap;

/*
* Brainstorm
* We need to creat a deep copy of a linked list where each node has a next pointer and a random pointer. Is that right?
* I'm going to use a hash map to store the mapping between original nodes and their copies.
* I'll iterate through the list twice. first to create all nodes, and second to set up the next and random pointers for the copied nodes.
*
* Edge case
* If some node doesn't have random node, Should I return null?
*
* Plan
* Use a hash map to map each original node to its copied node.
* Traverse the original list to creat a new node for each existing node and store the mapping in the hash map.
* Traverse the original list again to set the next and random pointers of the copied nodes using the hash map.
*
* TC : It will take O(n) because creating nodes and storing them in the map takes o(n),
* and setting the next and random pointers for each copied node also take O(n)
* SC : Storing mappings for n nodes take o(n) space.
* */
public class CopyLinkedListWithRandomPointer {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;
        node3.next = null;
        node.random = null;
        node2.random = node3;
        node3.random = node3;

        Node result = copyRandomList(node);
        while (result != null){
            if (result.next != null) System.out.print(result.next.val);
            else System.out.print("null");
            System.out.print(",");
            if (result.random != null) System.out.print(result.random.val);
            else System.out.print("null");
            result = result.next;
            System.out.print(" / ");
        }
    }

    public static Node copyRandomList(Node head) {
        // Create a hash map to map original nodes to their copies
        HashMap<Node,Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null,null); //Map mull to mull for edge cases where a node might not have a random pointer.
        Node cur = head;

        //Create all nodes and store them in the hash map
        while (cur != null){
            Node node = new Node(cur.val); //Create a new node with the same value as the current node.
            oldToCopy.put(cur,node); //Map the current original node to the new node.
            cur = cur.next; //Move to the next node in the original list
        }
        //Reset cur to the head for the second pass
        cur = head;

        //I'll make second pass : set the next and random pointer for the copied nodes.
        while (cur != null){
            Node copy = oldToCopy.get(cur); //Get the copy of the current node from the hash map
            copy.next = oldToCopy.get(cur.next); //Set the next pointer of the copied node using the hash map
            //node값을 전달하기 때문에 깊은복사
            copy.random = oldToCopy.get(cur.random);
//            Node copy = oldToCopy.get(cur); pointer값을 주는거라 얕은복사가 된다.
//            copy.next = cur.next;
//            copy.random = cur.random;
            cur = cur.next;
        }

        //return the head of the copied list.
        return oldToCopy.get(head);
    }
}
