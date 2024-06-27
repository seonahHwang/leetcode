package Milla.LinkedList;

import java.util.HashMap;

/*
* Brainstorm
Understanding the problem: We need to implement a Least Recently Used (LRU) Cache that supports fast insertion, deletion, and retrieval operations.
Initial thoughts:
Use a HashMap for fast key-value lookups.
Use a doubly linked list to maintain the order of recently used items,
* where the head represents the least recently used item and the tail represents the most recently used item.
*
*
Plan
Data Structures:

cap: Capacity of the cache.
cache: HashMap to store key-value pairs for fast access.
left and right: Sentinels of a doubly linked list to maintain the order of access.
Operations:

LRUCache(int capacity): Initializes the cache with a given capacity, sets up the HashMap and the doubly linked list.
remove(Node node): Removes a node from the doubly linked list.
insert(Node node): Inserts a node at the end of the doubly linked list, marking it as the most recently used.
get(int key): Retrieves the value associated with a key from the cache, updates its position in the list to indicate recent use.
put(int key, int value): Inserts or updates the value associated with a key in the cache,
* managing capacity constraints by evicting the least recently used item when necessary.
*
* TC : O(1)
* */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        System.out.println(lRUCache.get(1));;      // return 10
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        System.out.println(lRUCache.get(2));     // returns 20
        System.out.println(lRUCache.get(1));      // return -1 (not found)
    }

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;
    public LRUCache(int capacity){
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node); // Remove the node from its current position
            insert(node); // Insert it at the end to mark as most recently used
            return node.val;
        }
        return -1; // Return -1 if key is not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // If key already exists, update the value and mark as recently used
            Node existingNode = cache.get(key);
            remove(existingNode); // Remove it to update position
        } else if (cache.size() >= cap) {
            // If cache exceeds capacity, remove the least recently used item
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }

        // Create a new node and insert it into the cache and linked list
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

