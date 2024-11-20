package tree;

import java.util.LinkedList;
import java.util.Queue;

import static tree.traverse.DFSTraversal.inOrder;

public class Delete {
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

        delete(root, 20);
        inOrder(root);
    }

    private static void delete(Node root, int key) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curr = null; //rightmost node
        Node keyNode = null; //node to be deleted
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.key == key)
                keyNode = curr;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        int x = curr.key;
        deleteDeepest(root, curr);
        keyNode.key = x;
    }

    private static void deleteDeepest(Node root, Node temp) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.right != null) {
                if (curr.right == temp) {
                    curr.right = null;
                    temp = null;
                    return;
                } else
                    queue.add(curr.right);
            }
            if (curr.left != null) {
                if (curr.left == temp) {
                    curr.left = null;
                    temp = null;
                    return;
                } else
                    queue.add(curr.left);
            }
        }
    }
}
