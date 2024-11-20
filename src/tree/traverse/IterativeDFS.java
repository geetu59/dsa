package tree.traverse;

import tree.Node;

import java.util.Stack;

public class IterativeDFS {
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

        inorder(root);
        System.out.println("Pre");
        preOrder(root);
        System.out.println("Optmised pre order");
        optimisedPreOrder(root);
    }

    private static void optimisedPreOrder(Node root) {
        if (root == null) return;
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.key);
                if (curr.right != null) stack.push(curr.right);
                curr = curr.left;
            }
            if (!stack.isEmpty()) curr = stack.pop();
        }
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.key);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    private static void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.key);
            curr = curr.right;
        }
    }
}
