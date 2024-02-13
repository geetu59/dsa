package linkedlist.singlell;

import java.util.HashMap;

public class LRUCache {
    private static HashMap<Integer, Node> map;
    private static int count, capacity;
    private static Node head, tail;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        this.capacity = cap;
        map = new HashMap<>();
        count = 0;
        //head and tail as a sentinel node or a placeholder and does not contain actual data,
        //so insertion at head and del from tail will happen before and after it
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    public static void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //Function to return value corresponding to the key.
    public static int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int value = node.value;
            deleteNode(node);
            addToHead(node);
            return value;
        }
        return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value) {
        if (map.get(key) == null) {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }

        } else {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


