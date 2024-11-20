package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAtSameLevel {
    public static void main(String[] args) {
        SpecialNode root = new SpecialNode(1);
        SpecialNode node1 = new SpecialNode(2);
        SpecialNode node2 = new SpecialNode(3);
        SpecialNode node3 = new SpecialNode(4);
        SpecialNode node4 = new SpecialNode(5);
        SpecialNode node5 = new SpecialNode(6);
        SpecialNode node6 = new SpecialNode(7);
        root.left = node1;
        root.right = node2;
        root.left.left = node3;
        root.left.right = node4;
        root.right.left = node5;
        root.right.right = node6;

        connect(root);
    }

    public static void connect(SpecialNode root) {
        if (root == null) {
            return;
        }

        // Initialize a queue for level-order traversal
        Queue<SpecialNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);  // Level marker

        while (!queue.isEmpty()) {
            SpecialNode currentNode = queue.poll();

            if (currentNode != null) {
                // Set next pointer to the next node in the queue
                currentNode.next = queue.peek();

                // Enqueue left and right children
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            } else {
                // End of current level
                if (!queue.isEmpty()) {
                    // Add level marker for the next level
                    queue.add(null);
                }
            }
        }
    }
}

class SpecialNode {
    int key;
    SpecialNode left;
    SpecialNode right;
    SpecialNode next;

    public SpecialNode(int key) {
        this.key = key;
    }
}
