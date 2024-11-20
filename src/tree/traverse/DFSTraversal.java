package tree.traverse;

import tree.Node;

public class DFSTraversal {
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

        System.out.println("Inorder Traversal: ");
        inOrder(root); //20 10 40 30 50

        System.out.println("Preorder Traversal: ");
        preOrder(root); //10 20 30 40 50

        System.out.println("Postorder Traversal: ");
        postOrder(root); //20 40 50 30 10
    }

    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    private static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }
}
