package tree.construct;

import tree.Node;

public class BTtoDLL {
    static Node prev = null;

    public static void main(String[] args) {
        Node root = new Node(50);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(10);
        Node node4 = new Node(20);
        root.left = node1;
        root.right = node2;
        root.right.left = node3;
        root.right.right = node4;

        Node head = bToDLL(root); //20 50 10 30 20
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.key);
            curr = curr.right;
        }
    }

    static Node bToDLL(Node root) {
        if (root == null) return root;
        Node head = bToDLL(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLL(root.right);
        return head;
    }
}
