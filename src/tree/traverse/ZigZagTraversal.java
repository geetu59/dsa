package tree.traverse;

import tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//spiral traversal
public class ZigZagTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        root.left = node1;
        root.right = node2;
        root.left.left = node3;
        root.left.right = node4;
        root.right.left = node5;
        root.right.right = node6;

        spiral(root);
        zigzag(root); //1 3 2 4 5 6 7
    }

    private static void spiral(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Stack<Node> stack = new Stack<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                if (reverse) stack.push(node);
                else System.out.print(node.key + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (reverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().key + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    private static void zigzag(Node root) {
        if (root == null) return;
        Stack<Node> currStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();
        boolean leftToRight = true;
        currStack.push(root);
        while (!currStack.isEmpty()) {
            Node curr = currStack.pop();
            System.out.println(curr.key);
            if (leftToRight) {
                if (curr.left != null) nextStack.push(curr.left);
                if (curr.right != null) nextStack.push(curr.right);
            } else {
                if (curr.right != null) nextStack.push(curr.right);
                if (curr.left != null) nextStack.push(curr.left);
            }
            if (currStack.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = nextStack;
                nextStack = currStack;
                currStack = temp;
            }
        }
    }
}
