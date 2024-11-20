package tree;

import java.util.LinkedList;
import java.util.Queue;

import static tree.traverse.DFSTraversal.inOrder;

public class Insert {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        root.left = node1;
        root.right = node2;
        root.right.left = node3;
        root.right.right = node4;

        insert(root, new Node(60));
        inOrder(root); // 60 20 10 40 30 50
    }

    private static void insert(Node root, Node node) {
        if (root == null) {
            root = node;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left != null) queue.add(curr.left);
            else {
                curr.left = node;
                break;
            }
            if (curr.right != null) queue.add(curr.left);
            else {
                curr.right = node;
                break;
            }
        }
    }
}
